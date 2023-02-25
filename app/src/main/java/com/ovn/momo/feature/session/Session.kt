package com.ovn.momo.feature.session

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ovn.momo.R
import com.ovn.momo.feature.admin.MangeTopBar
import com.ovn.momo.feature.theme.*

@Preview
@Composable
fun SessionScreen_Preview() {
	MomoTheme {
		SessionScreen()
	}
}

@Composable
fun SessionScreen() {
	Surface(
		modifier = Modifier.fillMaxSize()) {
		Column {
			MangeTopBar(R.drawable.icon_excel, R.string.top_bar_title_register_session) {}
			SessionList(Modifier.weight(1f))
		}
	}
}

@Composable
fun SessionList(modifier: Modifier = Modifier) {
	Column(
		modifier = modifier
			.fillMaxWidth()
			.background(Background), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
		Text(stringResource(id = R.string.session_empty), style = Typography.body1)
	}
}