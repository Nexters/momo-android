package com.ovn.momo.feature.attendance

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.ovn.momo.R
import com.ovn.momo.core.navigation.AppComposeNavigator
import com.ovn.momo.feature.signup.SignUpViewModel
import com.ovn.momo.feature.theme.Typography

@Composable
fun AttendanceScreen(
	composeNavigator: AppComposeNavigator,
	viewModel: SignUpViewModel = hiltViewModel(),
) {

	Column() {
		Column(
			modifier = Modifier.padding(top = 20.dp)
		) {

			ConstraintLayout(
				modifier = Modifier
					.fillMaxWidth()
					.padding(
						horizontal = 24.dp
					)
			) {

				val (locale, userIcon) = createRefs()

				Row(
					modifier = Modifier
						.constrainAs(locale) {
							top.linkTo(parent.top)
							start.linkTo(parent.start)
						},
				) {
					Text(
						text = "서울특별시 강남구 역삼로",
						style = Typography.body1,
						fontWeight = FontWeight.W500
					)

					Spacer(modifier = Modifier.width(12.dp))

					Image(
						painter = painterResource(id = R.drawable.ic_attendance_locale),
						contentDescription = ""
					)
				}

				Image(
					modifier = Modifier
						.constrainAs(userIcon) {
							end.linkTo(parent.end)
						},
					painter = painterResource(id = R.drawable.ic_attendance_user),
					contentDescription = "",
				)
			}

			Spacer(modifier = Modifier.height(20.dp))

			ActiveUserSessionScreen()
		}
	}
}