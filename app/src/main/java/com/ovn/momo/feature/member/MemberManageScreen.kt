package com.ovn.momo.feature.member

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.ovn.momo.R
import com.ovn.momo.feature.admin.MangeTopBar
import com.ovn.momo.feature.session.SessionList
import com.ovn.momo.feature.theme.Background
import com.ovn.momo.feature.theme.FontGray800
import com.ovn.momo.feature.theme.MomoTheme
import com.ovn.momo.feature.theme.Typography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Preview
@Composable
fun MemberManageScreen_Preview() {
	MomoTheme {
		MemberManageScreen()
	}
}

@Composable
fun MemberManageScreen() {
	Surface(
		modifier = Modifier
			.fillMaxSize()
			.padding(bottom = 68.dp)) {
		Column {
			MangeTopBar(R.drawable.icon_excel, R.string.top_bar_title_register_member) {}
			HorizontalPagerScreen()
			SessionList(Modifier.weight(1f))
		}
	}
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerScreen() {
	Column(
		modifier = Modifier
			.fillMaxSize()
	) {
		val items = createItems()
		val pagerState = rememberPagerState()
		val coroutineScope = rememberCoroutineScope()

		HorizontalTabs(
			items = items,
			pagerState = pagerState,
			scope = coroutineScope
		)

		HorizontalPager(
			count = items.size,
			state = pagerState,
			modifier = Modifier.weight(1f)
		) { currentPage ->
			when (currentPage) {
				0 -> MemberListScreen(getTestMemberItems())
				else -> AttendanceListScreen(getTestMemberAttendanceItems())
			}
		}
	}
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalTabs(
	items: List<HorizontalTabItem>,
	pagerState: PagerState,
	scope: CoroutineScope,
) {
	TabRow(
		selectedTabIndex = pagerState.currentPage,
		modifier = Modifier
			.fillMaxWidth()
			.background(Background)
			.height(40.dp)
			.padding(top = 3.dp)
			.padding(horizontal = 24.dp),
		indicator = { }
	) {
		items.forEachIndexed { index, item ->
			val selected = pagerState.currentPage == index
			val tabSelectedModifier = Modifier
				.background(Background)
				.clip(shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
				.background(
					Color.White
				)

			Tab(
				modifier = if (selected) tabSelectedModifier else Modifier.background(Background),
				selected = selected,
				onClick = {
					scope.launch {
						pagerState.animateScrollToPage(page = index)
					}
				},
				text = { Text(text = stringResource(id = item.titleResId), style = Typography.h4, color = FontGray800) }
			)
		}
	}
}

private fun createItems() = listOf(
	HorizontalTabItem(R.string.member_tab_title_member),
	HorizontalTabItem(R.string.member_tab_title_attendance)
)

data class HorizontalTabItem(
	val titleResId: Int
)