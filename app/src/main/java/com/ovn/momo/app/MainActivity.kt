package com.ovn.momo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ovn.momo.core.navigation.AppComposeNavigator
import com.ovn.momo.feature.theme.MomoTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

	@Inject
	internal lateinit var appComposeNavigator: AppComposeNavigator

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MomoTheme {
				MomoMain(composeNavigator = appComposeNavigator)
			}
		}
	}
}