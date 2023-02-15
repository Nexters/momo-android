package com.ovn.momo.core.navigation

import androidx.navigation.NamedNavArgument

/**
 * 화면별 Route 관련 정보 설정
 */
sealed class MomoScreens(
	val route: String,
	navArguments: List<NamedNavArgument> = emptyList()
) {
	val name: String = route.appendArguments(navArguments)

	// login screen
	object Login : MomoScreens("login")

	// login screen
	object SignUp : MomoScreens("signup")

	companion object {
		const val argument_channel_id = "channelId"
	}
}

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
	val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
		.takeIf { it.isNotEmpty() }
		?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
		.orEmpty()
	val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
		.takeIf { it.isNotEmpty() }
		?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
		.orEmpty()
	return "$this$mandatoryArguments$optionalArguments"
}