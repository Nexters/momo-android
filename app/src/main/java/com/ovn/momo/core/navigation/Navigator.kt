package com.ovn.momo.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onSubscription

// Navigator는 Flow와 연관된 객체
abstract class Navigator {
	// SharedFlow를 통해 Navigation의 동작들 모두 관찰
	val navigationCommands = MutableSharedFlow<NavigationCommand>(extraBufferCapacity = Int.MAX_VALUE)

	// StateFlow를 통해 ViewModel이 navigation 변경된 결과들을 관찰하도록 설정
	val navControllerFlow = MutableStateFlow<NavController?>(null)

	fun navigateUp() {
		navigationCommands.tryEmit(NavigationCommand.NavigateUp)
	}
}

/**
 * AppComposeNavigator는 추상객체로서 App Module에서 실제 객체([MomoComposeNavigator]가 상속받아 사용할 기능들로 구현
 */
abstract class AppComposeNavigator : Navigator() {
	abstract fun navigate(route: String, optionsBuilder: (NavOptionsBuilder.() -> Unit)? = null)
	abstract fun navigateAndClearBackStack(route: String)

	abstract fun popUpTo(route: String, inclusive: Boolean)
	abstract fun <T> navigateBackWithResult(key: String, result: T, route: String?)

	// flow를 통해 감지된 navController 동작 유형들에 따라 handleComposeNavigationCommand 함수에서 처리
	suspend fun handleNavigationCommands(navController: NavController) {
		navigationCommands
			.onSubscription { this@AppComposeNavigator.navControllerFlow.value = navController }
			.onCompletion { this@AppComposeNavigator.navControllerFlow.value = null }
			.collect { navController.handleComposeNavigationCommand(it) }
	}

	private fun NavController.handleComposeNavigationCommand(navigationCommand: NavigationCommand) {
		when (navigationCommand) {
			is NavigationCommand.NavigateUp -> navigateUp()
			is NavigationCommand.NavigateToRoute -> {
				navigate(navigationCommand.route, navigationCommand.options)
			}
			is NavigationCommand.PopUpToRoute -> popBackStack(
				navigationCommand.route,
				navigationCommand.inclusive
			)
			is NavigationCommand.NavigateUpWithResult<*> -> {
				navUpWithResult(navigationCommand)
			}
		}
	}

	private fun NavController.navUpWithResult(
		navigationCommand: NavigationCommand.NavigateUpWithResult<*>
	) {
		val backStackEntry = navigationCommand.route?.let { getBackStackEntry(it) } ?: previousBackStackEntry
		backStackEntry?.savedStateHandle?.set(
			navigationCommand.key,
			navigationCommand.result
		)

		navigationCommand.route?.let { popBackStack(it, false) } ?: run { navigateUp() }
	}

	fun canNavUp(navController: NavController): Boolean = navController.backQueue.isNotEmpty()
}