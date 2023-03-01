package com.ovn.momo.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ovn.momo.feature.mangeClub.ManageClubScreen
import com.ovn.momo.feature.member.MemberManageScreen
import com.ovn.momo.feature.session.SessionManageScreen

@Composable
fun AdminNavHost(navController: NavHostController = rememberNavController()) {
	NavHost(navController = navController, startDestination = AdminNavItem.Session.screenRoute) {
		composable(AdminNavItem.Session.screenRoute) {
			SessionManageScreen()
		}
		composable(AdminNavItem.Member.screenRoute) {
			MemberManageScreen()
		}
		composable(AdminNavItem.ManageClub.screenRoute) {
			ManageClubScreen()
		}
	}
}