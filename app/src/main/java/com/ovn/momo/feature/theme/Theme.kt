package com.ovn.momo.feature.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
	primary = MainColor,
	background = Background,
	onPrimary = FontGray800,
	onSecondary = FontGray700,
	error = Warning
)

@Composable
fun MomoTheme(content: @Composable () -> Unit) {
	MaterialTheme(
		colors = LightColorPalette,
		typography = Typography,
		shapes = Shapes,
		content = content
	)
}