package com.ovn.momo.core.common_ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun CustomOutlinedTextField(
	paddingDp: Int,
	roundCornerDp: Int,
	text: String,
	placeHolder: String,
	textVisualTransformation: VisualTransformation,
	valueChangeListener: (value: String) -> Unit
) {
	val keyboardController = LocalSoftwareKeyboardController.current
	val textData = rememberSaveable { mutableStateOf(text) }

	OutlinedTextField(
		modifier = Modifier
			.padding(paddingDp.dp)
			.fillMaxWidth(),
		shape = RoundedCornerShape(roundCornerDp.dp),
		value = textData.value,
		visualTransformation = textVisualTransformation,
		onValueChange = {
			textData.value = it
			valueChangeListener(it)
		},
		placeholder = { Text(placeHolder) },
		maxLines = 1,
		keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
		keyboardActions = KeyboardActions {
			keyboardController?.hide()
		}
	)
}