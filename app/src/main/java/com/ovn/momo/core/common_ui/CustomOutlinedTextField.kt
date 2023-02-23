package com.ovn.momo.core.common_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ovn.momo.feature.theme.*

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun CustomOutlinedTextField(
	paddingDp: Int = 0,
	text: String = "",
	placeHolder: String = "",
	textVisualTransformation: VisualTransformation = VisualTransformation.None,
	isError: State<Boolean> = remember { mutableStateOf(false) },
	errorMsg: State<String> = remember { mutableStateOf("") },
	valueChangeListener: (value: String) -> Unit = {},
	) {

	val keyboardController = LocalSoftwareKeyboardController.current
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
					color = if (isActive) FocusedBox else UnFocusedBox,
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
			textStyle = Typography.body1,
			keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
			keyboardActions = KeyboardActions {
				keyboardController?.hide()
			},
			colors = TextFieldDefaults.outlinedTextFieldColors(
				focusedBorderColor = FocusedBorder,
				unfocusedBorderColor = UnFocusedBorder,
				errorBorderColor = Warning
			),
			isError = isError.value
		)

		if (isError.value && errorMsg.value.isNotEmpty()) {
			Text(
				text = errorMsg.value,
				color = Warning,
				style = Typography.body2,
				modifier = Modifier.padding(start=3.dp, top = 2.dp)
			)
		}
	}

}