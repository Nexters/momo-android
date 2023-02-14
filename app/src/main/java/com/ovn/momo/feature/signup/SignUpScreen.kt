package com.ovn.momo.feature.signup

import android.content.Context
import android.widget.Toast
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ovn.momo.R.color
import com.ovn.momo.core.common_ui.BlackRoundBorderButton
import com.ovn.momo.core.common_ui.CustomOutlinedTextField

@Composable
fun SignUpScreen(
	// composeNavigator: AppComposeNavigator,
	viewModel: SignUpViewModel = hiltViewModel(),
) {

	val context = LocalContext.current
	SubscribeToastMessage(viewModel, context)

	Column(
		modifier = Modifier
			.padding(20.dp)
			.fillMaxSize(),
	) {
		Spacer(modifier = Modifier.height(62.dp))
		Text(
			text = "간단한 출석체크,\n모두모여에서",
			color = Color.Black,
			fontSize = 36.sp,
			fontWeight = FontWeight.Bold
		)
		Spacer(modifier = Modifier.height(32.dp))
		Text(text = "이메일")
		Spacer(modifier = Modifier.height(10.dp))

		CustomOutlinedTextField(
			paddingDp = 0,
			roundCornerDp = 8,
			text = "",
			placeHolder = "넥스터즈 가입 시 메일주소를 입력하세요.",
			textVisualTransformation = VisualTransformation.None
		) { email ->
			viewModel.setUserEmail(email)
		}

		Spacer(modifier = Modifier.height(32.dp))
		Text(text = "비밀번호")
		Spacer(modifier = Modifier.height(10.dp))

		CustomOutlinedTextField(
			paddingDp = 0,
			roundCornerDp = 8,
			text = "",
			placeHolder = "비밀번호를 입력해주세요",
			textVisualTransformation = PasswordVisualTransformation()
		) { password ->
			viewModel.setUserPw(password)
		}

		Spacer(modifier = Modifier.height(10.dp))

		CustomOutlinedTextField(
			paddingDp = 0,
			roundCornerDp = 8,
			text = "",
			placeHolder = "비밀번호 재입력",
			textVisualTransformation = PasswordVisualTransformation()
		) { passwordCheck ->
			viewModel.setUserPwCheck(passwordCheck)
		}

		Spacer(modifier = Modifier.height(20.dp))

		BlackRoundBorderButton(
			"가입하기", 50, 0, 10
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
				color = colorResource(color.text_gray)
			)
			Spacer(modifier = Modifier.width(10.dp))
			Text(
				text = "로그인 하기",
				style = TextStyle(textDecoration = TextDecoration.Underline),
				fontWeight = FontWeight.Bold,
				modifier = Modifier
					.padding(top = 2.dp)
					.clickable {

					}
			)
		}

		Spacer(modifier = Modifier.height(20.dp))

		Row(
			horizontalArrangement = Arrangement.Center,
			modifier = Modifier.fillMaxWidth()
		) {
			Text(
				text = AnnotatedString("로그인에 문제가 있나요?"),
				color = colorResource(color.text_gray),
				modifier = Modifier
					.clickable {

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