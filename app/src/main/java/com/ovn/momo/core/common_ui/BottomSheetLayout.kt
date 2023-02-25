package com.ovn.momo.core.common_ui

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ovn.momo.feature.theme.Typography
import com.ovn.momo.feature.theme.Warning
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetLayout(
	screen: @Composable() () -> Unit,
	navigateFun: () -> Unit
) {
	val coroutineScope = rememberCoroutineScope()
	val modalSheetState = rememberModalBottomSheetState(
		initialValue = ModalBottomSheetValue.Hidden,
		confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
		skipHalfExpanded = true
	)

	BackHandler(modalSheetState.isVisible) {
		coroutineScope.launch { modalSheetState.hide() }
	}

	val roundedCornerRadius = 20.dp
	ModalBottomSheetLayout(
		sheetState = modalSheetState,
		sheetShape = RoundedCornerShape(topStart = roundedCornerRadius, topEnd = roundedCornerRadius),
		sheetContent = {
			Column(
				modifier = Modifier
					.padding(horizontal = 24.dp, vertical = 40.dp)
					.fillMaxWidth(),
				verticalArrangement = Arrangement.Center,
			) {

				Text(
					text = "저장하지 않고 나가시나요?",
					style = Typography.h3,
					fontWeight = FontWeight.W600
				)

				Spacer(modifier = Modifier.height(12.dp))

				Text(text = "나가신다면 작성한 내용은 저장되지 않습니다.")

				Spacer(modifier = Modifier.height(40.dp))

				Row(
					modifier = Modifier.height(60.dp).fillMaxWidth()
				) {
					Button(
						modifier = Modifier.weight(1f),
						colors = ButtonDefaults.buttonColors(
							backgroundColor = Color.White
						),
						onClick = {
							coroutineScope.launch { modalSheetState.hide() }
						}
					) {
						Text(
							modifier = Modifier.padding(vertical = 10.dp),
							text = "취소",
							style = Typography.body1,
							fontWeight = FontWeight.W600
						)
					}

					Spacer(modifier = Modifier.width(8.dp))

					Button(
						modifier = Modifier.weight(1f),
						colors = ButtonDefaults.buttonColors(
							backgroundColor = Warning
						),
						onClick = {
							navigateFun()
						}
					) {
						Text(
							modifier = Modifier.padding(vertical = 10.dp),
							text = "네, 불참합니다",
							style = Typography.body1,
							color = Color.White,
							fontWeight = FontWeight.W600
						)
					}
				}
			}
		}
	) {
		Scaffold {
			screen()

			Box(
				modifier = Modifier
					.fillMaxSize(),
				contentAlignment = Alignment.Center,
			) {


				Button(
					onClick = {
						coroutineScope.launch {
							if (modalSheetState.isVisible)
								modalSheetState.hide()
							else
								modalSheetState.animateTo(ModalBottomSheetValue.Expanded)
						}
					},
				) {
					Text(text = "Open Sheet")
				}
			}
		}

	}
}