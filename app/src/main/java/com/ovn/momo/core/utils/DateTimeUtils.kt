package com.ovn.momo.core.utils

import com.ovn.momo.R
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object DateTimeUtils {
	private const val FORMAT = "yyyy.MM.dd"

	@JvmStatic
	fun String?.parseLocalDateTime(): String {
		return LocalDateTime.parse(this).format(DateTimeFormatter.ofPattern(FORMAT))
	}

	@JvmStatic
	fun String?.getDayTagResId(): Int? {
		return when (Duration.between(LocalDateTime.now(), LocalDateTime.parse(this)).toDays()) {
			-3L -> R.string.day_tag_d_3
			-2L -> R.string.day_tag_d_2
			-1L -> R.string.day_tag_d_1
			0L -> R.string.day_tag_today
			else -> null
		}
	}

	@JvmStatic
	fun String?.isPastSession(): Boolean {
		return Duration.between(LocalDateTime.now(), LocalDateTime.parse(this)).toDays() < 0
	}
}