package com.ovn.momo.feature.admin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ovn.momo.R
import com.ovn.momo.core.utils.noRippleClickable
import com.ovn.momo.feature.theme.Background
import com.ovn.momo.feature.theme.MomoTheme
import com.ovn.momo.feature.theme.Typography

@Preview
@Composable
fun TopBar_delete_Preview() {
	MomoTheme {
		TopBar(titleResId = R.string.top_bar_title_register_session, onClickLeftButton = { }, rightTextResId = R.string.top_bar_delete, onClickRightText = {})
	}
}

@Preview
@Composable
fun TopBar_Preview() {
	MomoTheme {
		TopBar(titleResId = R.string.top_bar_title_start_session, onClickLeftButton = { })
	}
}

@Preview
@Composable
fun MangeTopBar_Preview() {
	MomoTheme {
		MangeTopBar(R.drawable.icon_excel, R.string.top_bar_title_register_session) {}
	}
}

@Composable
fun TopBar(modifier: Modifier = Modifier, titleResId: Int, onClickLeftButton: () -> Unit, rightTextResId: Int = -1, onClickRightText: () -> Unit = {}) {
	Box(
		modifier = modifier
			.height(80.dp)
			.padding(horizontal = 24.dp)) {
		Text(
			text = stringResource(id = titleResId), modifier = Modifier
				.fillMaxWidth()
				.align(Alignment.Center), textAlign = TextAlign.Center)

		Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.align(Alignment.Center)) {
			Image(painter = painterResource(id = R.drawable.icon_back), contentDescription = "back", modifier = Modifier.clickable { onClickLeftButton() })

			Spacer(modifier = Modifier.weight(1f))
			if (rightTextResId > 0) {
				Text(text = stringResource(id = rightTextResId), modifier = Modifier.clickable { onClickRightText() })
			}
		}
	}
}

@Composable
fun MangeTopBar(iconResId: Int, titleResId: Int, onClick: () -> Unit) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.background(Background)
			.height(60.dp)
			.padding(horizontal = 24.dp), verticalAlignment = Alignment.CenterVertically) {

		Image(painterResource(id = R.drawable.icon_nexters), contentDescription = "")

		Spacer(modifier = Modifier.weight(1f))
		Row(
			modifier = Modifier.noRippleClickable { onClick() },
			verticalAlignment = Alignment.CenterVertically) {
			Image(painter = painterResource(id = iconResId), contentDescription = "")
			Spacer(modifier = Modifier.padding(start = 6.dp))
			Text(text = stringResource(id = titleResId), style = Typography.body1)
		}
	}
}
