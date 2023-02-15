package com.ovn.momo.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.ovn.momo.core.navigation.AppComposeNavigator
import com.ovn.momo.feature.theme.MomoTheme
import com.ovn.momo.core.navigation.Navigator

@Composable
fun MomoMain(
	composeNavigator: AppComposeNavigator
) {
	MomoTheme {
		val navHotController = rememberNavController()

		/**
		 * [Navigator]의 navigationCommands을 Flow로 설정해서 Navigation의 결과들을 지속해서 관찰
		 */
		LaunchedEffect(Unit) {
			composeNavigator.handleNavigationCommands(navHotController)
		}

		MomoNavHost(navHostController = navHotController, composeNavigator = composeNavigator)
	}
}