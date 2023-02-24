package com.ovn.momo.feature.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ovn.momo.R
import com.ovn.momo.core.common_ui.CustomOutlinedTextField
import com.ovn.momo.core.common_ui.MainRoundBorderButton
import com.ovn.momo.core.navigation.AppComposeNavigator
import com.ovn.momo.feature.theme.FontGray600
import com.ovn.momo.feature.theme.Typography
import com.ovn.momo.feature.theme.pretendard

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun SignUpSecurityCodeScreen(
	composeNavigator: AppComposeNavigator,
	viewModel: SignUpSecurityCodeViewModel = hiltViewModel(),
) {
	Column(
		modifier = Modifier
			.background(color = Color.White)
			.padding(20.dp)
			.fillMaxSize(),
	) {
		Row(
			modifier = Modifier.fillMaxWidth()) {
			val image: Painter = painterResource(id = R.drawable.ic_arrow_back)
			Image(
				modifier = Modifier
					.padding(top = 5.dp)
					.clickable {
						composeNavigator.navigateUp()
					},
				painter = image, contentDescription = "",
			)

			Text(
				modifier = Modifier.weight(1f),
				text = stringResource(id = R.string.signup_security_code_topbar_text),
				style = Typography.body1,
				fontWeight = FontWeight.W500,
				textAlign = TextAlign.Center)
		}
		Spacer(modifier = Modifier.height(62.dp))

		Text(
			text = stringResource(id = R.string.signup_security_code_title),
			color = Color.Black,
			fontFamily = pretendard,
			style = Typography.h1,
		)

		Spacer(modifier = Modifier.height(8.dp))

		Text(
			text = "보안코드를 모를 경우 운영진에게 문의해주세요",
			style = Typography.body1,
			color = FontGray600,
		)

		Spacer(modifier = Modifier.height(31.dp))

		CustomOutlinedTextField(
			placeHolder = stringResource(id = R.string.signup_security_code_textfield_placeholder)) {
			viewModel.setSecurityCode(it)
		}

		Spacer(modifier = Modifier.height(60.dp))

		val btnEnabled = viewModel.securityBtn.collectAsStateWithLifecycle()

		MainRoundBorderButton(
			text = "다음", heightDp = 50, roundDp = 10, btnEnabled) {

		}
	}
}