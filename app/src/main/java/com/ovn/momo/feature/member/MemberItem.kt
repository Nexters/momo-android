package com.ovn.momo.feature.member

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ovn.momo.R
import com.ovn.momo.core.model.dto.MemberDto
import com.ovn.momo.feature.theme.Background
import com.ovn.momo.feature.theme.Typography

@Composable
fun MemberBaseItem(member: MemberDto, button: @Composable (String) -> Unit) {
	Column(
		modifier = Modifier
			.background(Color.White)
			.padding(horizontal = 24.dp)) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.defaultMinSize(minHeight = 56.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(text = member.name, style = Typography.body1, modifier = Modifier.width(56.dp), overflow = TextOverflow.Ellipsis)
			Spacer(modifier = Modifier.size(12.dp))
			Text(text = stringResource(id = R.string.attendance_generation, member.generation), style = Typography.body1)
			Spacer(modifier = Modifier.size(13.dp))
			Text(text = member.occupation, style = Typography.body1)
			Spacer(modifier = Modifier.weight(1f))

			button(member.attendance)
		}

		Divider(modifier = Modifier.height(0.5.dp), color = Background)
	}
}