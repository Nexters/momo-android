package com.ovn.momo.feature.attendance

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SessionDetailDialog(onChangeState: () -> Unit) {
	AlertDialog(
		onDismissRequest = { onChangeState() },
		title = {
			Text(text = "Dialog Title")
		},
		text = {
			Text("Here is a text ")
		},
		dismissButton = {
			Button(
				onClick = { onChangeState() }
			) {
				Text("취소")
			}
		},
		confirmButton = {
			Button(

				onClick = {
					onChangeState()
				}) {
				Text("실행")
			}
		}
	)
}