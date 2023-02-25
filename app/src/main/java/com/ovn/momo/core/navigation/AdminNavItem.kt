package com.ovn.momo.core.navigation

import com.ovn.momo.R

const val SESSION = "session"
const val MEMBER = "member"
const val MANAGE_CLUB = "mange_club"

sealed class AdminNavItem(
	val iconResId: Int, val titleResId: Int, val screenRoute: String,
) {
	object Session : AdminNavItem(R.drawable.icon_session, R.string.bottom_nav_title_session, SESSION)
	object Member : AdminNavItem(R.drawable.icon_user, R.string.bottom_nav_title_member, MEMBER)
	object ManageClub : AdminNavItem(R.drawable.icon_setting, R.string.bottom_nav_title_manage_club, MANAGE_CLUB)
}