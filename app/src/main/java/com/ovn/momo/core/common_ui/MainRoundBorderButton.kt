package com.ovn.momo.core.common_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ovn.momo.R

@Composable
fun MainRoundBorderButton(text: String, heightDp: Int, roundDp: Int, clickEvent: () -> Unit) {
	Button(
		onClick = { clickEvent() },
		colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.main_color)),
		modifier = Modifier
			.height(heightDp.dp)
			.fillMaxWidth()
			.background(
				color = Color.Black,
				shape = RoundedCornerShape(roundDp.dp)
			)
	) {
		Text(
			text = text,
			fontWeight = FontWeight.Bold,
			color = Color.White
		)
	}
}