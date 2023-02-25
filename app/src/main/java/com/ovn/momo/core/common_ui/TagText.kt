package com.ovn.momo.core.common_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ovn.momo.feature.theme.Purple100
import com.ovn.momo.feature.theme.Purple400

@Composable
fun TagText(
	text: String = ""
) {
	Text(
		modifier = Modifier
			.background(
				color = Purple100
			)
			.padding(
				vertical = 4.dp,
				horizontal = 12.dp
			),
		text = text,
		color = Purple400
	)
}