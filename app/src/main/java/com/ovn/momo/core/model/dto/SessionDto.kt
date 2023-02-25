package com.ovn.momo.core.model.dto

data class SessionDto(
	val id: Int?,
	val title: String?,
	val week: Int,
	val content: String?,
	val startAt: String?,
	val endAt: String?,
	val address: String?,
	val attendanceStartedAt: String?,
	val attendanceClosedAt: String?,
	val checkCode: String?
)