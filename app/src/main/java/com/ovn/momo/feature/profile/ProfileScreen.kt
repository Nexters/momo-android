package com.ovn.momo.feature.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.ovn.momo.R
import com.ovn.momo.core.navigation.AppComposeNavigator
import com.ovn.momo.feature.theme.*

@Composable
fun ProfileScreen(
	composeNavigator: AppComposeNavigator,
	viewModel: ProfileViewModel = hiltViewModel(),
) {

	val scrollState = rememberScrollState()
	ConstraintLayout(
		modifier = Modifier.verticalScroll(scrollState)
	) {

		val (topbar, image, userContent) = createRefs()


		Column(
			modifier = Modifier
				.background(color = Color.Black)
				.height(200.dp)
				.constrainAs(topbar) {
					top.linkTo(parent.top)
				}
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.padding(20.dp)
			) {
				val whiteArrowBack = painterResource(id = R.drawable.ic_arrow_back_white)
				Image(
					modifier = Modifier
						.weight(1f)
						.padding(top = 5.dp)
						.clickable {
							composeNavigator.navigateUp()
						},
					alignment = Alignment.CenterStart,
					painter = whiteArrowBack,
					contentDescription = "",
				)

				Text(
					modifier = Modifier
						.weight(1f)
						.fillMaxWidth(),
					text = stringResource(id = R.string.profile_topbar_text),
					color = Color.White,
					style = Typography.body1,
					fontWeight = FontWeight.W500,
					textAlign = TextAlign.Center
				)

				Text(
					modifier = Modifier
						.weight(1f),
					text = "로그아웃",
					textAlign = TextAlign.End,
					color = TextBox2,
					style = Typography.body2,
					fontWeight = FontWeight.W500
				)
			}
		}

		Image(
			painter = painterResource(id = R.drawable.ic_launcher_background),
			contentDescription = "",
			modifier = Modifier
				.clip(CircleShape)
				.border(
					shape = CircleShape,
					color = Color.White,
					width = 5.dp
				)
				.constrainAs(image) {
					top.linkTo(topbar.bottom, margin = (-80).dp)
					start.linkTo(parent.start)
					end.linkTo(parent.end)
				})

		Column(
			modifier = Modifier
				.fillMaxSize()
				.constrainAs(userContent) {
					top.linkTo(image.bottom, margin = 20.dp)
				}
		) {

			Row(
				modifier = Modifier.fillMaxWidth(),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.Center
			) {
				Text(
					text = "김넥터",
					color = FontGray800,
					fontSize = 20.sp,
					fontFamily = pretendard,
					fontWeight = FontWeight.W600
				)

				Spacer(modifier = Modifier.width(8.dp))

				RoundBgText(
					text = "Designer",
					textColor = OccupationText,
					fontWeight = FontWeight.W600,
					bgColor = OccupationBg,
					borderRadius = 8,
					paddingHorizontal = 9,
					paddingVertical = 4
				)
			}

			Spacer(modifier = Modifier.height(6.dp))

			Text(
				modifier = Modifier.fillMaxWidth(),
				textAlign = TextAlign.Center,
				text = "nexters@naver.com",
				style = Typography.body1,
				fontFamily = pretendard,
				color = FontGray600,
				fontWeight = FontWeight.W500
			)

			Row(
				modifier = Modifier
					.padding(26.dp)
					.fillMaxWidth()
			) {
				AttendanceBox("출석", "3")
				Spacer(modifier = Modifier.width(9.dp))
				AttendanceBox("지각", "0")
				Spacer(modifier = Modifier.width(9.dp))
				AttendanceBox("결석", "0")
			}

			Spacer(modifier = Modifier.height(35.dp))

			Text(
				modifier = Modifier.padding(
					horizontal = 24.dp
				),
				text = "출석 히스토리",
				fontWeight = FontWeight.W600,
				style = Typography.body1,
				color = FontGray700
			)

			Spacer(modifier = Modifier.height(16.dp))

			Spacer(
				modifier = Modifier
					.background(color = AttendanceHistoryDivideLine)
					.height(1.dp)
					.fillMaxWidth()
			)

			Spacer(modifier = Modifier.height(24.dp))

			for (i in 0 until 5) {

				AttendanceHistory("4주차 (4/7)")

			}
		}
	}
}

@Composable
fun AttendanceHistory(
	dateText: String,
) {
	Row(
		modifier = Modifier.padding(horizontal = 24.dp)
	) {
		Text(
			text = dateText,
			color = FontGray600,
			style = Typography.body2,
			fontWeight = FontWeight.W500
		)

		Spacer(modifier = Modifier.width(16.dp))

		val image = painterResource(id = R.drawable.ic_launcher_background)
		Image(
			modifier = Modifier
				.width(14.dp)
				.height(20.dp)
				.clickable {

				},
			alignment = Alignment.CenterStart,
			painter = image,
			contentDescription = "",
		)

		Spacer(modifier = Modifier.width(4.dp))

		Column(
			modifier = Modifier
				.weight(1f)
		) {
			Text(
				text = "결석 (무단)",
				color = FontGray700,
				fontWeight = FontWeight.W600,
				fontFamily = pretendard,
				style = Typography.body1
			)

			Spacer(modifier = Modifier.height(4.dp))

			Text(
				text = "2023.02.07 12:00",
				color = FontGray600,
				fontWeight = FontWeight.W500,
				style = Typography.body2
			)
		}

		RoundBgText(
			text = "-15",
			textColor = Color.Red,
			fontWeight = FontWeight.W500,
			bgColor = AttendanceAbsent,
			borderRadius = 5,
			paddingHorizontal = 10,
			paddingVertical = 4
		)
	}
	Spacer(modifier = Modifier.height(24.dp))

}

@Composable
fun AttendanceBox(
	boxText: String,
	attendanceText: String
) {
	Column(
		modifier = Modifier
			.border(
				width = 1.dp,
				color = AttendanceTextBorder,
				shape = RoundedCornerShape(8.dp)
			),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(
			modifier = Modifier.padding(
				start = 39.dp,
				end = 39.dp,
				top = 16.dp
			),
			text = boxText,
			style = Typography.body2,
			color = FontGray600
		)
		Text(
			modifier = Modifier.padding(
				start = 39.dp,
				end = 39.dp,
				top = 9.dp,
				bottom = 16.dp
			),
			text = attendanceText,
			fontWeight = FontWeight.W400,
			color = FontGray800,
			fontSize = 39.sp
		)
	}
}

@Composable
fun RoundBgText(
	text: String = "",
	textColor: Color = Color.White,
	fontWeight: FontWeight = FontWeight.Normal,
	bgColor: Color = Color.White,
	borderRadius: Int = 0,
	paddingHorizontal: Int = 0,
	paddingVertical: Int = 0,
) {

	Text(
		modifier = Modifier
			.background(
				color = bgColor,
				shape = RoundedCornerShape(borderRadius.dp)
			)
			.padding(horizontal = paddingHorizontal.dp, vertical = paddingVertical.dp),
		text = text,
		color = textColor,
		fontWeight = fontWeight
	)

}
