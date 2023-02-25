package com.ovn.momo.feature.session

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ovn.momo.R
import com.ovn.momo.core.model.dto.SessionDto
import com.ovn.momo.core.utils.noRippleClickable
import com.ovn.momo.feature.theme.*

@Preview
@Composable
fun SessionInfo_Preview() {
	MomoTheme {
		val sessionInfo =
			SessionDto(0, "우리 조를 구상해봐요!", 3, "내용내용", "2023-02-25T08:58:15.556Z", "2023-02-25T08:58:15.556Z", "address", "2023-02-25T08:58:15.556Z", "2023-02-25T08:58:15.556Z")
		SessionInfo(sessionInfo)
	}
}

@Composable
fun SessionInfo(session: SessionDto) {
	Column(modifier = Modifier.background(Color.White)) {
		val horizontalPadding = Modifier.padding(horizontal = 20.dp)

		Spacer(modifier = Modifier.padding(top = 20.dp))
		SessionHeader(horizontalPadding, session.week, session.startAt) {

		}
		Spacer(modifier = Modifier.padding(top = 11.dp))
		SessionTitle(horizontalPadding, session.title ?: "")
		Spacer(modifier = Modifier.padding(top = 20.dp))
		SessionContent(horizontalPadding, session.content ?: "")
		Spacer(modifier = Modifier.padding(top = 20.dp))
		CheckCode(horizontalPadding.defaultMinSize(minHeight = 72.dp), "1234")
		Divider(
			modifier = Modifier
				.height(12.dp)
				.background(Background))
	}
}

@Composable
fun SessionHeader(modifier: Modifier = Modifier, week: Int, date: String, onClick: () -> Unit) {
	Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
		Text(text = stringResource(id = R.string.week_title, week), style = Typography.h3, fontWeight = FontWeight.Bold)
		Spacer(modifier = Modifier.padding(8.dp))
		DayTag()
		Spacer(modifier = Modifier.weight(1f))
		Text(text = date, style = Typography.body2)
		Spacer(modifier = Modifier.padding(start = 7.dp))
		Image(painter = painterResource(id = R.drawable.icon_go_to), contentDescription = "", modifier = Modifier
			.size(16.dp)
			.noRippleClickable { onClick() })
	}
}

@Composable
fun DayTag() {
	Card(shape = RoundedCornerShape(8.dp), backgroundColor = MainColor) {
		Text(text = "Today", modifier = Modifier.padding(horizontal = 9.dp, vertical = 4.dp), color = Color.White, style = Typography.body2, fontWeight = FontWeight.Bold)
	}
}

@Composable
fun SessionTitle(modifier: Modifier = Modifier, title: String) {
	Card(modifier = modifier, backgroundColor = Background, shape = RoundedCornerShape(4.dp)) {
		Text(text = title, modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp), style = Typography.body2)
	}
}

@Composable
fun SessionContent(modifier: Modifier = Modifier, content: String) {
	Row(modifier = modifier) {
		Text(text = content, style = Typography.body2)
	}
}

@Composable
fun CheckCode(modifier: Modifier = Modifier, code: String) {
	Row(
		modifier = Modifier
			.background(BackMainColor)
			.then(modifier), verticalAlignment = Alignment.CenterVertically) {
		Text(text = stringResource(id = R.string.check_code, code), textAlign = TextAlign.Center, color = MainColor)
		Spacer(modifier = Modifier.weight(1f))
		Image(painter = painterResource(id = R.drawable.icon_lock), contentDescription = "")
	}
}