package com.ovn.momo.feature.registerClub

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ovn.momo.R
import com.ovn.momo.feature.admin.TopBar
import com.ovn.momo.feature.theme.MomoTheme


@Preview
@Composable
fun RegisterAdminInfo_Preview() {
	MomoTheme {
		RegisterAdminInfo(R.string.register_admin_info_generation, buttonTextResId = R.string.next)
	}
}

@Composable
fun RegisterAdminInfo(titleResId: Int, descriptionResId: Int = -1, buttonTextResId: Int, onClick: () -> Unit = {}) {
	Column {
		val horizontalPadding = Modifier.padding(horizontal = 24.dp)

		TopBar(titleResId = R.string.top_bar_title_register_session, onClickLeftButton = {})
		Spacer(modifier = Modifier.padding(top = 68.dp))
		Text(modifier = horizontalPadding, text = stringResource(id = titleResId), style = MaterialTheme.typography.h1)
		Spacer(modifier = Modifier.padding(top = 8.dp))
		Text(modifier = horizontalPadding, text = stringResource(id = descriptionResId))
		Spacer(modifier = Modifier.padding(top = 91.dp))
		TextField(modifier = horizontalPadding.fillMaxWidth(), value = "", onValueChange = {})
		Spacer(modifier = Modifier.weight(1f))
		CompleteButton(
			modifier = horizontalPadding.padding(bottom = 18.dp), stringResource(id = buttonTextResId), onClick)
	}
}

@Composable
fun CompleteButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit = {}) {
	Card(shape = RoundedCornerShape(7.dp), modifier = modifier
		.fillMaxWidth()
		.clickable { onClick() }) {
		Text(
			text = text, modifier = Modifier
				.background(MaterialTheme.colors.primary)
				.padding(vertical = 16.5.dp), textAlign = TextAlign.Center, color = Color.White)
	}
}