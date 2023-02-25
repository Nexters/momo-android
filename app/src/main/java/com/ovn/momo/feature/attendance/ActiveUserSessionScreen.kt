package com.ovn.momo.feature.attendance

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ovn.momo.R
import com.ovn.momo.feature.theme.*

@Composable
fun ActiveUserSessionScreen() {
	val scrollState = rememberScrollState()

	Column(
		modifier = Modifier
			.verticalScroll(scrollState)
	) {

		Spacer(modifier = Modifier.height(7.dp))

		Row(
			modifier = Modifier
				.padding(horizontal = 24.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(
				text = "1주차",
				style = Typography.h1
			)

			Spacer(modifier = Modifier.width(8.dp))

			Text(
				modifier = Modifier
					.background(
						color = MainColor,
						shape = RoundedCornerShape(8.dp)
					)
					.padding(
						horizontal = 9.dp,
						vertical = 4.dp
					),
				text = "D-3",
				color = Color.White
			)
		}

		Spacer(modifier = Modifier.height(4.dp))

		Text(
			modifier = Modifier.padding(horizontal = 24.dp),
			text = "2023.01.07 토요일 Pm 1:00",
			style = Typography.body2,
			color = FontGray800
		)

		Spacer(modifier = Modifier.height(21.dp))

		Spacer(
			modifier = Modifier
				.background(color = DivideLine)
				.height(1.dp)
				.fillMaxWidth()
		)

		Spacer(modifier = Modifier.height(43.dp))

		Row(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center
		) {
			Image(
				painter = painterResource(id = R.drawable.img_attendance_dday_before),
				contentDescription = ""
			)
		}

		Spacer(modifier = Modifier.height(13.dp))

		Text(
			modifier = Modifier.padding(horizontal = 24.dp),
			text = "무엇을 하나요?",
			style = Typography.h3,
			fontWeight = FontWeight.W600
		)

		Spacer(modifier = Modifier.height(20.dp))

		Spacer(
			modifier = Modifier
				.background(color = DivideLine)
				.height(1.dp)
				.fillMaxWidth()
		)

		Spacer(modifier = Modifier.height(20.dp))

		Row(
			modifier = Modifier.padding(24.dp)
		) {
			Text(
				modifier = Modifier
					.background(
						color = TextBox1,
						shape = RoundedCornerShape(4.dp)
					)
					.padding(
						horizontal = 13.dp,
						vertical = 10.dp
					),
				text = "1주차, 우리 조를 구성해봐요!",
				style = Typography.body1,
				fontWeight = FontWeight.W500
			)
		}

		Spacer(modifier = Modifier.height(16.dp))

		Text(
			modifier = Modifier.padding(horizontal = 24.dp),
			text = "팀별로 구현할 서비스의 핵심 기능과 개발 일정을 구성원이 다 함께 기획합니다. 2달 간의 정규 활동을 통해 서비스를 런칭할 수 있도록 열정 가득한 시작을 함께해보세요!",
			style = Typography.body1,
			fontWeight = FontWeight.W500
		)

		Spacer(modifier = Modifier.height(26.dp))

		Spacer(
			modifier = Modifier
				.background(color = DivideLine)
				.height(1.dp)
				.fillMaxWidth()
		)

		Row(
			modifier = Modifier
				.height(70.dp)
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center,
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(
				text = "해당 세션 참여가 어려워요"
			)
			Spacer(modifier = Modifier.width(12.dp))

			Image(
				painter = painterResource(id = R.drawable.ic_arrow_next),
				contentDescription = ""
			)
		}

		Spacer(
			modifier = Modifier
				.background(color = Background)
				.height(12.dp)
				.fillMaxWidth()
		)

		Text(
			modifier = Modifier
				.padding(horizontal = 24.dp, vertical = 20.dp),
			text = "상세정보",
			color = FontGray800,
			style = Typography.h3,
			fontWeight = FontWeight.W800
		)

		SessionData()


	}
}