package com.ovn.momo.feature.attendance

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ovn.momo.R
import com.ovn.momo.feature.theme.FontGray600
import com.ovn.momo.feature.theme.Typography

@Composable
fun NoSessionData() {
	Column(
		modifier = Modifier
			.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {

		Spacer(modifier = Modifier.height(46.dp))

		Image(
			painter = painterResource(id = R.drawable.img_no_session),
			contentDescription = ""
		)

		Spacer(modifier = Modifier.height(19.dp))

		Text(
			text = "상세정보가 업데이트 될 예정이예요",
			color = FontGray600,
			style = Typography.body1
		)

		Spacer(modifier = Modifier.height(50.dp))
	}
}