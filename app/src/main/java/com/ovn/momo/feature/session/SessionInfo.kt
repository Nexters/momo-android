package com.ovn.momo.feature.session

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.ovn.momo.R
import com.ovn.momo.feature.theme.MomoTheme

@Preview
@Composable
fun SessionInfo_Preview() {
	MomoTheme {
		SessionInfo()
	}
}

@Composable
fun SessionInfo() {
	Card(shape = RoundedCornerShape(12.dp)) {
		Column {
			val horizontalPadding = Modifier.padding(horizontal = 20.dp)

			Spacer(modifier = Modifier.padding(top = 20.dp))
			SessionTitle(horizontalPadding)
			Spacer(modifier = Modifier.padding(top = 8.dp))
			SessionHashTag(horizontalPadding)
			Spacer(modifier = Modifier.padding(top = 8.dp))
			SessionContent(horizontalPadding)
			Spacer(modifier = Modifier.padding(top = 20.dp))
			CheckCode(
				Modifier
					.background(Color.Red)
					.padding(vertical = 16.5.dp))
		}
	}
}

@Composable
fun SessionTitle(modifier: Modifier = Modifier) {
	Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
		Text(text = "3주차")
		Spacer(modifier = Modifier.padding(8.dp))
		DayTag()
		Spacer(modifier = Modifier.weight(1f))
		Text(text = "1011.11.11")
		Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "gotodetail", modifier = Modifier.size(16.dp))
	}
}

@Composable
fun DayTag() {
	Card(shape = RoundedCornerShape(6.dp), backgroundColor = Color.Green) {
		Text(text = "Today", modifier = Modifier.padding(horizontal = 11.dp, vertical = 8.dp), color = Color.White)
	}
}

@Composable
fun SessionHashTag(modifier: Modifier = Modifier) {
	Row(modifier = modifier) {
		Text(text = "#기획 #MVP #와이어프레임")
	}
}

@Composable
fun SessionContent(modifier: Modifier = Modifier) {
	Row(modifier = modifier) {
		Text(text = LoremIpsum(30).values.joinToString())
	}
}

@Composable
fun CheckCode(modifier: Modifier = Modifier) {
	Row(modifier = modifier) {
		Text(text = "출석 체크 코드 2222", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, color = Color.White)
	}
}