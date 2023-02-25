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
import com.ovn.momo.core.utils.DateTimeUtils.getDayTagResId
import com.ovn.momo.core.utils.DateTimeUtils.isPastSession
import com.ovn.momo.core.utils.DateTimeUtils.parseLocalDateTime
import com.ovn.momo.core.utils.noRippleClickable
import com.ovn.momo.feature.theme.*

@Preview
@Composable
fun SessionInfo_Preview() {
	MomoTheme {
		val sessionInfo =
			SessionDto(0, "우리 조를 구상해봐요!", 3, "내용내용", "2023-02-20T08:58:15.556", "2023-02-25T08:58:15.556", "address", "2023-02-25T08:58:15.556", "2023-02-25T08:58:15.556", "1234")
		SessionInfo(sessionInfo) {
		}
	}
}

@Composable
fun SessionInfo(session: SessionDto, onClick: () -> Unit) {
	val isPastSession = session.startAt?.isPastSession() == true
	val backgroundColor = if (isPastSession) PastBox else Color.White
	val dividerColor = if (isPastSession) Color.White else Background

	Column(modifier = Modifier
		.background(backgroundColor)
		.noRippleClickable { onClick() }) {
		val horizontalPadding = Modifier.padding(horizontal = 20.dp)

		Spacer(modifier = Modifier.padding(top = 20.dp))
		SessionHeader(horizontalPadding, session.week, session.startAt)
		Spacer(modifier = Modifier.padding(top = 11.dp))

		session.title?.let { title ->
			SessionTitle(horizontalPadding, title)
			Spacer(modifier = Modifier.padding(top = 20.dp))
		}

		session.content?.let { content ->
			SessionContent(horizontalPadding, content)
			Spacer(modifier = Modifier.padding(top = 20.dp))
		}

		session.checkCode?.let {
			CheckCode(horizontalPadding.defaultMinSize(minHeight = 72.dp), it)
		}

		Divider(
			modifier = Modifier
				.height(12.dp), color = dividerColor)
	}
}

@Composable
fun SessionHeader(modifier: Modifier = Modifier, week: Int, date: String?) {
	Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
		Text(text = stringResource(id = R.string.week_title, week), style = Typography.h3, fontWeight = FontWeight.Bold)
		Spacer(modifier = Modifier.padding(8.dp))
		date?.let { it.getDayTagResId()?.let { tagResId -> DayTag(stringResource(id = tagResId)) } }
		Spacer(modifier = Modifier.weight(1f))
		date?.let {
			Text(text = it.parseLocalDateTime(), style = Typography.body2)
			Spacer(modifier = Modifier.padding(start = 7.dp))
			Image(
				painter = painterResource(id = R.drawable.icon_go_to), contentDescription = "",
				modifier = Modifier
					.size(16.dp))
		}
	}
}

@Composable
fun DayTag(tag: String) {
	if (tag.isEmpty()) return

	Card(shape = RoundedCornerShape(8.dp), backgroundColor = MainColor) {
		Text(text = tag, modifier = Modifier.padding(horizontal = 9.dp, vertical = 4.dp), color = Color.White, style = Typography.body2, fontWeight = FontWeight.Bold)
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