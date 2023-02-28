package com.ovn.momo.feature.attendance

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ovn.momo.core.navigation.AppComposeNavigator
import com.ovn.momo.feature.signup.SignUpViewModel

@Composable
fun AttendanceScreen(
	composeNavigator: AppComposeNavigator,
	viewModel: SignUpViewModel = hiltViewModel(),
) {

	Column() {
		ActiveUserSessionScreen(composeNavigator)
	}
}