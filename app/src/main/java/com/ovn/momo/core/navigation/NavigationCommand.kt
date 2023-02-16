package com.ovn.momo.core.navigation

import androidx.navigation.NavOptions


/**
 * Navigation에서 사용되는 구체화된 명령어들을 정리한 sealed class
 */
sealed class NavigationCommand {
	object NavigateUp : NavigationCommand()

	data class NavigateToRoute(val route: String, val options: NavOptions? = null) : NavigationCommand()

	data class NavigateUpWithResult<T>(
		val key: String,
		val result: T,
		val route: String? = null
	) : NavigationCommand()

	data class PopUpToRoute(val route: String, val inclusive: Boolean) : NavigationCommand()
}