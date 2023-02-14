package com.ovn.momo.core.common_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BlackRoundBorderButton(text: String, heightDp: Int, horizontalDp: Int, roundDp: Int, clickEvent: () -> Unit) {
	Button(
		onClick = { clickEvent() },
		colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
		modifier = Modifier
			.height(heightDp.dp)
			.padding(horizontal = horizontalDp.dp)
			.fillMaxWidth()
			.background(
				color = Color.Black,
				shape = RoundedCornerShape(roundDp.dp)
			)
	) {
		Text(
			text = text,
			color = Color.White
		)
	}
}