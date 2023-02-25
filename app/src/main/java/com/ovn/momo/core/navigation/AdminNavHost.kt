package com.ovn.momo.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ovn.momo.feature.mangeClub.ManageClubScreen
import com.ovn.momo.feature.member.MemberScreen
import com.ovn.momo.feature.session.SessionScreen

@Composable
fun AdminNavHost(navController: NavHostController = rememberNavController()) {
	NavHost(navController = navController, startDestination = AdminNavItem.Session.screenRoute) {
		composable(AdminNavItem.Session.screenRoute) {
			SessionScreen()
		}
		composable(AdminNavItem.Member.screenRoute) {
			MemberScreen()
		}
		composable(AdminNavItem.ManageClub.screenRoute) {
			ManageClubScreen()
		}
	}
}