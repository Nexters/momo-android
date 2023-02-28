package com.ovn.momo.feature.attendance

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ovn.momo.R
import com.ovn.momo.feature.theme.FontGray600
import com.ovn.momo.feature.theme.FontGray700
import com.ovn.momo.feature.theme.Typography
import com.ovn.momo.feature.theme.Warning
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UserAbsentBtmSheet(
	modalSheetState: ModalBottomSheetState,
	onChangeState: () -> Unit
) {
	val coroutineScope = rememberCoroutineScope()

	BackHandler(modalSheetState.isVisible) {
		coroutineScope.launch { modalSheetState.hide() }
	}

	val roundedCornerRadius = 20.dp
	ModalBottomSheetLayout(
		sheetState = modalSheetState,
		sheetShape = RoundedCornerShape(topStart = roundedCornerRadius, topEnd = roundedCornerRadius),
		sheetContent = {
			Column(
				modifier = Modifier.padding(vertical = 40.dp, horizontal = 24.dp),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Image(
					painter = painterResource(id = R.drawable.img_user_absent),
					contentDescription = ""
				)

				Spacer(modifier = Modifier.height(22.dp))

				Text(
					text = "넥스터즈 세션 참여가 어려운가요?",
					style = Typography.h3,
					fontWeight = FontWeight.W600,
					color = FontGray700
				)

				Spacer(modifier = Modifier.height(12.dp))

				Text(
					text = "불참사실은 운영진에게 전달되고 활동점수에서 -10점이 차감됩니다.",
					style = Typography.body1,
					fontWeight = FontWeight.W500,
					color = FontGray600
				)

				Spacer(modifier = Modifier.height(40.dp))

				Row(
					modifier = Modifier
						.height(60.dp)
						.fillMaxSize()
				) {
					Button(
						modifier = Modifier.weight(1f),
						colors = ButtonDefaults.buttonColors(
							backgroundColor = Color.White
						),
						onClick = {
							onChangeState()
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
							onChangeState()
							coroutineScope.launch { modalSheetState.hide() }
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

	}
}