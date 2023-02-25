package com.ovn.momo.feature.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ovn.momo.core.navigation.AdminNavHost

@Composable
fun AdminScreen() {
	val navController = rememberNavController()

	Scaffold(bottomBar = { AdminBottomNavigation(navController) }) {
		Column(Modifier.padding(it)) {
			AdminNavHost(navController = navController)
		}
	}
}
