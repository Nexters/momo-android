package com.ovn.momo.feature.login

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ovn.momo.core.navigation.AppComposeNavigator
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MomoLogin(
	composeNavigator: AppComposeNavigator,
	viewModel: MomoLoginViewModel = hiltViewModel()
) {
	Text(text = "Login Screen입니다.")
}