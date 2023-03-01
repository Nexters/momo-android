package com.ovn.momo.core.model.dto

data class MemberDto(
	val name: String = "",
	val isActive: Boolean = true,
	val generation: Int,
	val occupation: String = "",
	val attendance: String,
)