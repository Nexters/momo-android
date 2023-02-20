package com.ovn.momo.feature.signup

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ovn.momo.R.color
import com.ovn.momo.core.common_ui.CustomOutlinedTextField
import com.ovn.momo.core.common_ui.MainRoundBorderButton
import com.ovn.momo.core.navigation.AppComposeNavigator
import com.ovn.momo.core.navigation.MomoScreens
import com.ovn.momo.feature.theme.*

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun SignUpScreen(
	composeNavigator: AppComposeNavigator,
	viewModel: SignUpViewModel = hiltViewModel(),
) {

	val context = LocalContext.current
	SubscribeToastMessage(viewModel, context)

	Column(
		modifier = Modifier
			.background(color = Color.White)
			.padding(20.dp)
			.fillMaxSize(),
	) {
		Spacer(modifier = Modifier.height(62.dp))

		Text(
			text = "간단한 출석체크",
			style = Typography.h1
		)
		Spacer(modifier = Modifier.height(10.dp))

		Text(
			text = "MDMY",
			color = Color.Black,
			style = mdmyTextStyle
		)
		Spacer(modifier = Modifier.height(32.dp))

		Text(
			text = "이메일",
			style = Typography.body1,
			fontWeight = FontWeight.Bold,
			color = FontGray500,
		)
		Spacer(modifier = Modifier.height(10.dp))

		CustomOutlinedTextField(
			placeHolder = "넥스터즈 가입 시 메일주소를 입력하세요.",
			isError = viewModel.userEmailError.collectAsStateWithLifecycle(),
			errorMsg = viewModel.userEmailErrorMsg.collectAsStateWithLifecycle()
		) { email ->
			viewModel.setUserEmail(email)
		}

		Spacer(modifier = Modifier.height(32.dp))

		Text(
			text = "비밀번호",
			style = Typography.body1,
			color = FontGray500,
			fontWeight = FontWeight.Bold
		)

		Spacer(modifier = Modifier.height(10.dp))

		CustomOutlinedTextField(
			placeHolder = "비밀번호를 입력해주세요",
			textVisualTransformation = PasswordVisualTransformation(),
			isError = viewModel.userPwError.collectAsStateWithLifecycle(),
		) { password ->
			viewModel.setUserPw(password)
		}

		Spacer(modifier = Modifier.height(10.dp))

		CustomOutlinedTextField(
			placeHolder = "비밀번호 재입력",
			textVisualTransformation = PasswordVisualTransformation(),
			isError = viewModel.userPwError.collectAsStateWithLifecycle(),
			errorMsg = viewModel.userPwErrorMsg.collectAsStateWithLifecycle()
		) { passwordCheck ->
			viewModel.setUserPwCheck(passwordCheck)
		}

		Spacer(modifier = Modifier.height(20.dp))

		MainRoundBorderButton(
			"가입하기", 60, 6
		) {

			if (viewModel.isSignUpSuccess()) {
//				composeNavigator.navigate(MomoScreens.SignUpSecurityCode.name)
			}
		}

		Spacer(modifier = Modifier.height(20.dp))

		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center
		) {
			Text(
				text = "이미 가입했다면?",
				color = FontGray600
			)

			Spacer(modifier = Modifier.width(10.dp))

			Text(
				text = "로그인 하기",
				color = colorResource(color.black),
				style = Typography.body1,
				fontWeight = FontWeight.Bold,
				modifier = Modifier
					.clickable {
						composeNavigator.navigate(MomoScreens.Login.name)
					}
			)
		}

		Spacer(modifier = Modifier.height(30.dp))

		Row(
			horizontalArrangement = Arrangement.Center,
			modifier = Modifier.fillMaxWidth()
		) {
			Text(
				text = AnnotatedString("로그인에 문제가 있나요?"),
				style = Typography.body1,
				fontWeight = FontWeight.Bold,
				color = FontGray550,
				modifier = Modifier
					.clickable {
						viewModel.setToastMessage("운영진에게 문의해주세요.")
					}
			)
		}
	}
}

@Composable
@OptIn(ExperimentalLifecycleComposeApi::class)
private fun SubscribeToastMessage(viewModel: SignUpViewModel, context: Context) {
	val toastMessage by viewModel.toastMessage.collectAsStateWithLifecycle()
	if (toastMessage == "") return
	Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
	viewModel.initToastMessage()
}