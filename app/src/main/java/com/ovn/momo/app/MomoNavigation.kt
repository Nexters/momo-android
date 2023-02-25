package com.ovn.momo.app

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ovn.momo.core.navigation.AppComposeNavigator
import com.ovn.momo.core.navigation.MomoScreens
import com.ovn.momo.feature.attendance.AttendanceScreen
import com.ovn.momo.feature.login.MomoLogin
import com.ovn.momo.feature.signup.SignUpScreen


fun NavGraphBuilder.momoHomeNavigation(
	composeNavigator: AppComposeNavigator
) {

	composable(route = MomoScreens.Login.name) {
		MomoLogin(composeNavigator = composeNavigator)
	}

	composable(route = MomoScreens.SignUp.name) {
		SignUpScreen(composeNavigator = composeNavigator)
	}

	composable(route = MomoScreens.Attendance.name) {
		AttendanceScreen(composeNavigator = composeNavigator)
	}
}