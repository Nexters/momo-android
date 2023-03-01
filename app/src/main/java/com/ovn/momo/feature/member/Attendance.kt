package com.ovn.momo.feature.member


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ovn.momo.R
import com.ovn.momo.core.utils.noRippleClickable
import com.ovn.momo.feature.theme.*

enum class Attendance {
	ATTENDANCE, LATE, ABSENT, NOTICED_ABSENT
}

@Preview
@Composable
fun Attendance_Preview() {
	MomoTheme {
		Column {
			AttendancePresent()
			AttendanceLate()
			AttendanceAbsent()
			AttendanceNoticedAbsent()
		}
	}
}

@Composable
fun AttendanceBadge(attendance: String) {
	when (attendance) {
		Attendance.ATTENDANCE.name -> AttendancePresent()
		Attendance.LATE.name -> AttendanceLate()
		Attendance.ABSENT.name -> AttendanceAbsent()
		Attendance.NOTICED_ABSENT.name -> AttendanceNoticedAbsent()
	}
}

@Composable
fun AttendanceBase(color: Color, textResId: Int, onClick: () -> Unit) {
	Card(shape = RoundedCornerShape(6.dp), backgroundColor = color, modifier = Modifier
		.noRippleClickable { onClick() }
		.defaultMinSize(minHeight = 28.dp, minWidth = 60.dp)) {
		Text(
			text = stringResource(id = textResId),
			style = Typography.caption,
			color = Color.White,
			fontWeight = FontWeight.Bold,
			modifier = Modifier.padding(horizontal = 7.5.dp, vertical = 5.5.dp), textAlign = TextAlign.Center)
	}
}

@Composable
fun AttendancePresent(onClick: () -> Unit = {}) {
	AttendanceBase(AttendanceChecked, R.string.attendance_present) {
		onClick()
	}
}

@Composable
fun AttendanceLate(onClick: () -> Unit = {}) {
	AttendanceBase(AttendanceLate, R.string.attendance_late) {
		onClick()
	}
}

@Composable
fun AttendanceAbsent(onClick: () -> Unit = {}) {
	AttendanceBase(AttendanceAbsent, R.string.attendance_absent) {
		onClick()
	}
}

@Composable
fun AttendanceNoticedAbsent(onClick: () -> Unit = {}) {
	AttendanceBase(AttendanceNoticedAbsent, R.string.attendance_noticed_absent) {
		onClick()
	}
}