package com.ovn.momo.feature.session

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ovn.momo.R
import com.ovn.momo.core.model.dto.SessionDto
import com.ovn.momo.feature.admin.MangeTopBar
import com.ovn.momo.feature.theme.*

@Preview
@Composable
fun SessionScreen_Preview() {
	MomoTheme {
		SessionScreen()
	}
}

@Composable
fun SessionScreen() {
	Surface(
		modifier = Modifier
			.fillMaxSize()
			.padding(bottom = 68.dp)) {
		Column {
			MangeTopBar(R.drawable.icon_excel, R.string.top_bar_title_register_session) {}
			SessionList(Modifier.weight(1f), getTestItems())
		}
	}
}

@Composable
fun SessionList(modifier: Modifier = Modifier, list: List<SessionDto>) {
	if (list.isEmpty()) {
		Column(modifier = modifier
			.fillMaxSize()
			.background(Background), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
			Text(text = stringResource(id = R.string.session_empty), style = Typography.body2, color = FontGray500)
		}
		return
	}

	val context = LocalContext.current

	LazyColumn(modifier = modifier) {
		items(list) {
			SessionInfo(session = it) {
				Toast.makeText(context, "세션 상세 정보로 이동", Toast.LENGTH_SHORT).show()
			}
		}
	}
}

private fun getTestItems(): List<SessionDto> {
	return listOf(
		SessionDto(1, null, 8, null, null, null, null, null, null, null),
		SessionDto(1, null, 7, "내용내용", null, null, null, null, null, null),
		SessionDto(1, "우리 조를 구상해봐요!", 6, null, "2023-03-25T08:58:15.556", "2023-02-25T08:58:15.556", "address", "2023-02-25T08:58:15.556", "2023-02-25T08:58:15.556", null),
		SessionDto(1, "우리 조를 구상해봐요!", 5, "내용내용", "2023-03-19T08:58:15.556", "2023-02-25T08:58:15.556", "address", "2023-02-25T08:58:15.556", "2023-02-25T08:58:15.556", null),
		SessionDto(1, "우리 조를 구상해봐요!", 4, "내용내용", "2023-03-10T08:58:15.556", "2023-02-25T08:58:15.556", "address", "2023-02-25T08:58:15.556", "2023-02-25T08:58:15.556", null),
		SessionDto(1, "우리 조를 구상해봐요!", 3, "내용내용", "2023-02-25T08:58:15.556", "2023-02-25T08:58:15.556", "address", "2023-02-25T08:58:15.556", "2023-02-25T08:58:15.556", "1234"),
		SessionDto(0, "우리 조를 구상해봐요!", 2, "내용내용", "2023-02-24T08:58:15.556", "2023-02-25T08:58:15.556", "address", "2023-02-25T08:58:15.556", "2023-02-25T08:58:15.556", null),
		SessionDto(0, "우리 조를 구상해봐요!", 1, "내용내용", "2023-02-23T08:58:15.556", "2023-02-25T08:58:15.556", "address", "2023-02-25T08:58:15.556", "2023-02-25T08:58:15.556", null)
	)
}
