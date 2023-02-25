package com.ovn.momo.feature.admin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ovn.momo.core.navigation.AdminNavHost
import com.ovn.momo.core.navigation.AdminNavItem
import com.ovn.momo.core.utils.noRippleClickable
import com.ovn.momo.feature.theme.Divider
import com.ovn.momo.feature.theme.FontGray500
import com.ovn.momo.feature.theme.Typography


@Composable
fun AdminBottomNavigation(navController: NavHostController = rememberNavController()) {
	Scaffold(
		bottomBar = { BottomBar(navController = navController) }
	) {
		Modifier.padding(it)
		AdminNavHost(
			navController = navController
		)
	}
}

@Composable
fun BottomBar(navController: NavHostController) {
	val items = listOf(
		AdminNavItem.Session,
		AdminNavItem.Member,
		AdminNavItem.ManageClub
	)

	val navStackBackEntry by navController.currentBackStackEntryAsState()
	val currentDestination = navStackBackEntry?.destination

	Column {
		Divider(
			modifier = Modifier
				.height(1.dp)
				.background(Divider))
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.height(86.dp),
			horizontalArrangement = Arrangement.SpaceEvenly,
			verticalAlignment = Alignment.CenterVertically
		) {
			items.forEach { item ->
				AdminBottomNavItem(currentDestination, item = item) {
					navController.navigate(item.screenRoute) {
						navController.graph.startDestinationRoute?.let {
							popUpTo(it) { saveState = true }
						}
						launchSingleTop = true
						restoreState = true
					}
				}
			}
		}
	}
}

@Composable
private fun AdminBottomNavItem(navDestination: NavDestination?, item: AdminNavItem, onClick: () -> Unit) {
	val color = if (navDestination?.route == item.screenRoute) MaterialTheme.colors.primary else FontGray500

	Column(modifier = Modifier
		.noRippleClickable { onClick() }
		.padding(19.dp), horizontalAlignment = Alignment.CenterHorizontally) {
		Image(painter = painterResource(id = item.iconResId), contentDescription = "", colorFilter = ColorFilter.tint(color))
		Spacer(modifier = Modifier.padding(top = 5.dp))
		Text(text = stringResource(id = item.titleResId), style = Typography.caption, color = color)
	}
}