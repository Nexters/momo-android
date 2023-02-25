package com.ovn.momo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ovn.momo.feature.admin.AdminScreen
import com.ovn.momo.feature.theme.MomoTheme

class AdminActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MomoTheme {
				AdminScreen()
			}
		}
	}
}