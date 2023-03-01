package com.ovn.momo.feature.member

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ovn.momo.R
import com.ovn.momo.core.model.dto.MemberDto
import com.ovn.momo.feature.theme.*

@Preview
@Composable
fun MemberAttendanceItem_Preview() {
	MomoTheme {
		val member = MemberDto("홍길동", true,22, "DEVELOPER", "ABSENT")
		MemberBaseItem(member) { attendances ->
			AttendanceBadge(attendances)
		}
	}
}

@Preview
@Composable
fun AttendanceListScreen_Preview() {
	MomoTheme {
		AttendanceListScreen(getTestMemberAttendanceItems())
	}
}

@Composable
fun AttendanceListScreen(attendances: List<MemberDto>) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Background)
			.clip(shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
			.background(Color.White)
	) {

		Row(
			modifier = Modifier
				.padding(horizontal = 24.dp)
				.padding(bottom = 16.dp)) {
			Text(text = stringResource(id = R.string.member_title_sort_by_name), color= FontGray800, style = Typography.body1)
		}

		LazyColumn {
			items(attendances) { item ->
				MemberBaseItem(item) { attendances ->
					AttendanceBadge(attendances)
				}
			}
		}
	}
}

fun getTestMemberAttendanceItems(): List<MemberDto> {
	return listOf(
		MemberDto("홍길동홍", true,22, "DEVELOPER", "ABSENT"),
		MemberDto("홍길", true,22, "DEVELOPER", "LATE"),
		MemberDto("홍길동", true,22, "DEVELOPER", "NOTICED_ABSENT"),
		MemberDto("홍길동", true,22, "DEVELOPER", "ATTENDANCE"),
		MemberDto("홍길동", true,22, "DEVELOPER", "ABSENT"),
		MemberDto("홍길동", true,22, "DEVELOPER", "ATTENDANCE"),
		MemberDto("홍길동", true,22, "DEVELOPER", "ABSENT"),
		MemberDto("홍길동", true,22, "DEVELOPER", "LATE")
	)
}
