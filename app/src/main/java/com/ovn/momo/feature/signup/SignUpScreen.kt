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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ovn.momo.R
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
			text = stringResource(id = R.string.signup_title_sub),
			style = Typography.h1
		)
		Spacer(modifier = Modifier.height(10.dp))

		Text(
			text = stringResource(id = R.string.signup_title),
			color = Color.Black,
			style = mdmyTextStyle
		)
		Spacer(modifier = Modifier.height(32.dp))

		Text(
			text = stringResource(id = R.string.signup_email_text),
			style = Typography.body1,
			fontWeight = FontWeight.Bold,
			color = FontGray500,
		)
		Spacer(modifier = Modifier.height(10.dp))

		CustomOutlinedTextField(
			placeHolder = stringResource(id = R.string.signup_email_textfield_placeholder),
			isError = viewModel.userEmailError.collectAsStateWithLifecycle(),
			errorMsg = viewModel.userEmailErrorMsg.collectAsStateWithLifecycle()
		) { email ->
			viewModel.setUserEmail(email)
		}

		Spacer(modifier = Modifier.height(32.dp))

		Text(
			text = stringResource(id = R.string.signup_pw_text),
			style = Typography.body1,
			color = FontGray500,
			fontWeight = FontWeight.Bold
		)

		Spacer(modifier = Modifier.height(10.dp))

		CustomOutlinedTextField(
			placeHolder = stringResource(id = R.string.signup_pw_textfield_placeholder),
			textVisualTransformation = PasswordVisualTransformation(),
			isError = viewModel.userPwError.collectAsStateWithLifecycle(),
		) { password ->
			viewModel.setUserPw(password)
		}

		Spacer(modifier = Modifier.height(10.dp))

		CustomOutlinedTextField(
			placeHolder = stringResource(id = R.string.signup_pw_check_textfield_placeholder),
			textVisualTransformation = PasswordVisualTransformation(),
			isError = viewModel.userPwError.collectAsStateWithLifecycle(),
			errorMsg = viewModel.userPwErrorMsg.collectAsStateWithLifecycle()
		) { passwordCheck ->
			viewModel.setUserPwCheck(passwordCheck)
		}

		Spacer(modifier = Modifier.height(20.dp))

		MainRoundBorderButton(
			text = stringResource(id = R.string.signup_btn_text),
			heightDp = 60,
			roundDp = 6
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
				text = stringResource(id = R.string.signup_switch_login_sub_text),
				color = FontGray600
			)

			Spacer(modifier = Modifier.width(10.dp))

			Text(
				text = stringResource(id = R.string.signup_switch_login_text),
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
			val toastMsg = stringResource(id = R.string.signup_problem_toast)
			Text(
				text = stringResource(id = R.string.signup_problem_text),
				style = Typography.body1,
				fontWeight = FontWeight.Bold,
				color = FontGray550,
				modifier = Modifier
					.clickable {
						viewModel.setToastMessage(toastMsg)
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