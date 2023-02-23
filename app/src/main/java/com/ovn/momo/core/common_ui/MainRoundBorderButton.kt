package com.ovn.momo.core.common_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ovn.momo.feature.theme.FontGray600
import com.ovn.momo.feature.theme.MainColor

@Composable
fun MainRoundBorderButton(
	text: String,
	heightDp: Int,
	roundDp: Int,
	btnEnabled: State<Boolean> = remember { mutableStateOf(true) },
	clickEvent: () -> Unit
) {

	Button(
		onClick = { clickEvent() },
		colors = ButtonDefaults.buttonColors(
			backgroundColor = MainColor,
			disabledBackgroundColor = FontGray600
		),
		modifier = Modifier
			.height(heightDp.dp)
			.fillMaxWidth()
			.background(
				color = Color.Black,
				shape = RoundedCornerShape(roundDp.dp)
			),
		enabled = btnEnabled.value
	) {
		Text(
			text = text,
			fontWeight = FontWeight.Bold,
			color = Color.White
		)
	}
}