package com.ovn.momo.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.flow.*

abstract class Navigator {
	val navigationCommands = MutableSharedFlow<NavigationCommand>(extraBufferCapacity = Int.MAX_VALUE)

	// StateFlow를 통해 ViewModel이 navigation 결과들을 관찰하도록 설정
	val navControllerFlow = MutableStateFlow<NavController?>(null)

	fun navigateUp() {
		navigationCommands.tryEmit(NavigationCommand.NavigateUp)
	}
}

abstract class AppComposeNavigator : Navigator() {
	abstract fun navigate(route: String, optionsBuilder: (NavOptionsBuilder.() -> Unit)? = null)
	abstract fun <T> navigateBackWithResult(key: String, result: T, route: String?)

	abstract fun popUpTo(route: String, inclusive: Boolean)
	abstract fun navigateAndClearBackStack(route: String)

	suspend fun handleNavigationCommands(navController: NavController) {
		navigationCommands
			.onSubscription { this@AppComposeNavigator.navControllerFlow.value = navController }
			.onCompletion { this@AppComposeNavigator.navControllerFlow.value = null }
			.collect { navController.handleComposeNavigationCommand(it) }
	}

	private fun NavController.handleComposeNavigationCommand(navigationCommand: NavigationCommand) {
		when (navigationCommand) {
			is ComposeNavigationCommand.NavigateToRoute -> {
				navigate(navigationCommand.route, navigationCommand.options)
			}
			NavigationCommand.NavigateUp -> navigateUp()
			is ComposeNavigationCommand.PopUpToRoute -> popBackStack(
				navigationCommand.route,
				navigationCommand.inclusive
			)
			is ComposeNavigationCommand.NavigateUpWithResult<*> -> {
				navUpWithResult(navigationCommand)
			}
		}
	}

	private fun NavController.navUpWithResult(
		navigationCommand: ComposeNavigationCommand.NavigateUpWithResult<*>
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