package com.ovn.momo.feature.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
	h1 = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Bold,
		color = FontGray800,
		fontSize = 28.sp
	),
	h2 = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Normal,
		color = FontGray800,
		fontSize = 24.sp
	),
	h3 = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Normal,
		color = FontGray800,
		fontSize = 20.sp
	),
	h4 = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Normal,
		color = FontGray800,
		fontSize = 18.sp
	),
	body1 = TextStyle(
		fontFamily = pretendard,
		fontWeight = FontWeight.Normal,
		color = FontGray800,
		fontSize = 16.sp
	),
	body2 = TextStyle(
		fontFamily = pretendard,
		fontWeight = FontWeight.Normal,
		color = FontGray800,
		fontSize = 14.sp
	),
	caption = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Normal,
		color = FontGray800,
		fontSize = 12.sp
	),
)

val mdmyTextStyle = TextStyle(
	fontFamily = montserrat,
	fontWeight = FontWeight.Bold,
	fontSize = 34.sp
)