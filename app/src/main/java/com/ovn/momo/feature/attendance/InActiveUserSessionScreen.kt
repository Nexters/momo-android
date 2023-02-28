package com.ovn.momo.feature.attendance

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ovn.momo.R
import com.ovn.momo.core.common_ui.MainRoundBorderButton
import com.ovn.momo.core.navigation.AppComposeNavigator
import com.ovn.momo.feature.theme.FontGray600
import com.ovn.momo.feature.theme.FontGray700
import com.ovn.momo.feature.theme.Typography

@Composable
fun InactiveUserSessionScreen(
	composeNavigator: AppComposeNavigator,
) {
	Column {
		AttendanceTopBar()

		ConstraintLayout(
			modifier = Modifier.fillMaxSize()
		) {


			val (image, mainText, subText, button) = createRefs()

			Row(
				modifier = Modifier
					.fillMaxWidth()
					.constrainAs(image) {
						top.linkTo(parent.top, margin = 73.dp)
						start.linkTo(parent.start)
						end.linkTo(parent.end)
					},
				horizontalArrangement = Arrangement.Center
			) {
				Image(
					painter = painterResource(id = R.drawable.img_attendance_inactive),
					contentDescription = ""
				)
			}

			Spacer(modifier = Modifier.height(40.dp))

			Text(
				modifier = Modifier
					.fillMaxWidth()
					.constrainAs(mainText) {
						top.linkTo(image.bottom, margin = 40.dp)
						start.linkTo(parent.start)
						end.linkTo(parent.end)
					},
				text = "활동 기간이 아닙니다",
				style = Typography.h3,
				color = FontGray700,
				fontWeight = FontWeight.W600,
				textAlign = TextAlign.Center
			)

			Spacer(modifier = Modifier.height(8.dp))

			Text(
				modifier = Modifier
					.fillMaxWidth()
					.constrainAs(subText) {
						top.linkTo(mainText.bottom, margin = 8.dp)
						start.linkTo(parent.start)
						end.linkTo(parent.end)
					},
				text = "궁금한 점이 있으면 운영진에게 문의해주세요",
				color = FontGray600,
				style = Typography.body1,
				fontWeight = FontWeight.W500,
				textAlign = TextAlign.Center
			)

			Row(
				modifier = Modifier
					.padding(horizontal = 24.dp)
					.fillMaxWidth()
					.constrainAs(button) {
						bottom.linkTo(parent.bottom, margin = 56.dp)
						start.linkTo(parent.start)
						end.linkTo(parent.end)
					}
			) {
				MainRoundBorderButton(
					text = "문의하기", heightDp = 60, roundDp = 8) {

				}
			}

		}
	}
}