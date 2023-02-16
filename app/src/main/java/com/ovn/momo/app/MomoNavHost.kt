package com.ovn.momo.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.ovn.momo.core.navigation.AppComposeNavigator
import com.ovn.momo.core.navigation.MomoScreens
import com.ovn.momo.feature.signup.SignUpScreen

@Composable
fun MomoNavHost(
	navHostController: NavHostController,
	composeNavigator: AppComposeNavigator
) {
	/**
	 * 화면의 첫 번째 시작화면: [SignUpScreen]
	 * Navigation Route는 [MomoScreens] 내에서 관리
	 */
	NavHost(
		navController = navHostController,
		startDestination = MomoScreens.SignUp.route
	) {
		momoHomeNavigation(
			composeNavigator = composeNavigator
		)
	}
}