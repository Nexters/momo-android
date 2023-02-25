package com.ovn.momo.feature.attendance

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ovn.momo.R
import com.ovn.momo.core.common_ui.TagText
import com.ovn.momo.feature.theme.DivideLine
import com.ovn.momo.feature.theme.FontGray700
import com.ovn.momo.feature.theme.FontGray800
import com.ovn.momo.feature.theme.Typography

@Composable
fun SessionData() {
	Column(
		modifier = Modifier
			.padding(horizontal = 24.dp),
	) {
		Row(
			verticalAlignment = Alignment.CenterVertically
		) {
			TagText("시간")

			Text(
				modifier = Modifier
					.weight(1f),
				text = "2023.01.07 토요일 오후 1:00",
				color = FontGray800,
				style = Typography.body1,
				fontWeight = FontWeight.W500,
				textAlign = TextAlign.End
			)
		}

		Spacer(modifier = Modifier.height(17.dp))

		Row(
			verticalAlignment = Alignment.CenterVertically
		) {
			TagText("장소")

			Spacer(modifier = Modifier.width(10.dp))

			Column(
				modifier = Modifier.weight(1f),
			) {
				Text(
					modifier = Modifier
						.fillMaxWidth(),
					text = "서울특별시 강남구 역삼로",
					maxLines = 1,
					overflow = TextOverflow.Ellipsis,
					color = FontGray800,
					style = Typography.body1,
					fontWeight = FontWeight.W500,
					textAlign = TextAlign.End
				)

				Text(
					modifier = Modifier
						.fillMaxWidth(),
					text = "마루180 지하1층",
					maxLines = 1,
					overflow = TextOverflow.Ellipsis,
					color = FontGray800,
					style = Typography.body1,
					fontWeight = FontWeight.W500,
					textAlign = TextAlign.End
				)
			}
		}

		Spacer(modifier = Modifier.height(28.dp))

		Spacer(
			modifier = Modifier
				.background(color = DivideLine)
				.height(1.dp)
				.fillMaxWidth()
		)

		Row(
			modifier = Modifier
				.height(72.dp)
		) {
			Row(
				modifier = Modifier
					.weight(1f)
					.fillMaxHeight(),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.Center,
			) {
				Image(
					painter = painterResource(id = R.drawable.ic_attendance_find_route),
					contentDescription = ""
				)

				Spacer(modifier = Modifier.width(7.dp))

				Text(
					text = "길찾기",
					style = Typography.body1,
					color = FontGray700,
					fontWeight = FontWeight.W500
				)
			}

			Spacer(
				modifier = Modifier
					.background(color = DivideLine)
					.width(1.dp)
					.fillMaxHeight()
			)

			Row(
				modifier = Modifier
					.weight(1f)
					.fillMaxHeight(),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.Center,
			) {
				Image(
					painter = painterResource(id = R.drawable.ic_attendance_session_detail),
					contentDescription = ""
				)

				Spacer(modifier = Modifier.width(7.dp))

				Text(
					text = "세션 상세 정보",
					style = Typography.body1,
					color = FontGray700,
					fontWeight = FontWeight.W500
				)
			}
		}
	}
}