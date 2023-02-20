package com.ovn.momo.core.common_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ovn.momo.R
import com.ovn.momo.feature.theme.pretendard

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun CustomOutlinedTextField(
	paddingDp: Int = 0,
	text: String = "",
	textFontFamily: FontFamily = pretendard,
	placeHolder: String = "",
	textVisualTransformation: VisualTransformation = VisualTransformation.None,
	isError: State<Boolean> = remember { mutableStateOf(false) },
	errorMsg: State<String> = remember { mutableStateOf("") },
	valueChangeListener: (value: String) -> Unit = {},
	) {

	val keyboardController = LocalSoftwareKeyboardController.current

	val textFieldUnFocusedColor = colorResource(id = R.color.textfield_unfocused_color)
	val textFieldFocusedColor = colorResource(id = R.color.textfield_focused_color)
	val borderUnFocusedColor = colorResource(id = R.color.textfield_border_unfocused_color)
	val borderFocusedColor = colorResource(id = R.color.textfield_border_focused_color)
	val errorColor = colorResource(id = R.color.textfield_border_error_color)

	val focusRequester by remember { mutableStateOf(FocusRequester()) }

	// TextField 안에 사용될 text
	val textData = rememberSaveable { mutableStateOf(text) }
	// 현재 컴포넌트가 focus되어있는지 체크하는 변수
	var isFocused by rememberSaveable { mutableStateOf(false) }

	// text와 focus를 체크하여 내부 background 색상을 관리하는 변수
	var isActive by rememberSaveable { mutableStateOf(false) }

	Column {
		OutlinedTextField(
			modifier = Modifier
				.padding(paddingDp.dp)
				.focusRequester(focusRequester)
				.onFocusChanged {
					isFocused = it.hasFocus
					isActive = isFocused || textData.value.isNotEmpty()
				}
				.background(
					color = if (isActive) textFieldFocusedColor else textFieldUnFocusedColor,
					shape = RoundedCornerShape(6.dp))
				.fillMaxWidth(),
			value = textData.value,
			visualTransformation = textVisualTransformation,
			onValueChange = {
				textData.value = it
				valueChangeListener(it)

				isActive = isFocused || textData.value.isNotEmpty()
			},
			placeholder = { Text(placeHolder) },
			maxLines = 1,
			textStyle = TextStyle(
				fontSize = 16.sp,
				color = Color.Black,
				fontFamily = textFontFamily,
				fontWeight = FontWeight.W500
			),
			keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
			keyboardActions = KeyboardActions {
				keyboardController?.hide()
			},
			colors = TextFieldDefaults.outlinedTextFieldColors(
				focusedBorderColor = borderFocusedColor,
				unfocusedBorderColor = borderUnFocusedColor,
				errorBorderColor = errorColor
			),
			isError = isError.value
		)

		if (isError.value && errorMsg.value.isNotEmpty()) {
			Text(
				text = errorMsg.value,
				color = errorColor,
				style = MaterialTheme.typography.body1,
				modifier = Modifier.padding(start=3.dp, top = 2.dp)
			)
		}
	}

}