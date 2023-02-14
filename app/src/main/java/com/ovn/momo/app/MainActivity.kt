package com.ovn.momo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ovn.momo.feature.signup.SignUpScreen
import com.ovn.momo.feature.theme.MomoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MomoTheme {
				// A surface container using the 'background' color from the theme
				SignUpScreen()
			}
		}
	}
}