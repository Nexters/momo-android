package com.ovn.momo.feature.signup

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ovn.momo.core.navigation.AppComposeNavigator
import com.ovn.momo.core.navigation.MomoScreens

@Composable
fun MomoSignUp(
	composeNavigator: AppComposeNavigator,
	viewModel: SignUpViewModel = hiltViewModel()
) {
	Button(
		onClick = {
			composeNavigator.navigate(MomoScreens.Login.name)
		}
	) {
		Text(
			text = "navigate"
		)
	}
}