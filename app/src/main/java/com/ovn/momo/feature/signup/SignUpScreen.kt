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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ovn.momo.R.color
import com.ovn.momo.core.common_ui.CustomOutlinedTextField
import com.ovn.momo.core.common_ui.MainRoundBorderButton
import com.ovn.momo.core.navigation.AppComposeNavigator
import com.ovn.momo.core.navigation.MomoScreens
import com.ovn.momo.feature.theme.montserrat
import com.ovn.momo.feature.theme.pretendard

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
			color = colorResource(id = color.gray_800),
			fontSize = 28.sp,
			fontFamily = pretendard,
			fontWeight = FontWeight.Bold
		)
		Spacer(modifier = Modifier.height(10.dp))

		Text(
			text = "MDMY",
			color = Color.Black,
			fontSize = 34.sp,
			fontFamily = montserrat,
			fontWeight = FontWeight.Bold
		)
		Spacer(modifier = Modifier.height(32.dp))

		Text(
			text = "이메일",
			fontSize = 16.sp,
			fontFamily = pretendard,
			color = Color(color = color.gray_500),
			fontWeight = FontWeight.Bold
		)
		Spacer(modifier = Modifier.height(10.dp))

		CustomOutlinedTextField(
			placeHolder = "넥스터즈 가입 시 메일주소를 입력하세요.",
		) { email ->
			viewModel.setUserEmail(email)
		}

		Spacer(modifier = Modifier.height(32.dp))

		Text(
			text = "비밀번호",
			fontSize = 16.sp,
			fontFamily = pretendard,
			color = Color(color = color.gray_500),
			fontWeight = FontWeight.Bold
		)
		Spacer(modifier = Modifier.height(10.dp))

		CustomOutlinedTextField(
			placeHolder = "비밀번호를 입력해주세요",
			textVisualTransformation = PasswordVisualTransformation()
		) { password ->
			viewModel.setUserPw(password)
		}

		Spacer(modifier = Modifier.height(10.dp))

		CustomOutlinedTextField(
			placeHolder = "비밀번호 재입력",
			textVisualTransformation = PasswordVisualTransformation()
		) { passwordCheck ->
			viewModel.setUserPwCheck(passwordCheck)
		}

		Spacer(modifier = Modifier.height(20.dp))

		MainRoundBorderButton(
			"가입하기", 60,  6
		) {
			if (viewModel.isSignUpSuccess()) {
//				composeNavigator.navigate()
			}
		}

		Spacer(modifier = Modifier.height(20.dp))

		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center
		) {
			Text(
				text = "이미 가입했다면?",
				color = colorResource(color.gray_600)
			)
			Spacer(modifier = Modifier.width(10.dp))
			Text(
				text = "로그인 하기",
				color = colorResource(color.black),
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
				fontWeight = FontWeight.Bold,
				color = colorResource(color.gray_900),
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