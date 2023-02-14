package com.ovn.momo.feature.signup

import android.util.Log
import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel
import com.ovn.momo.core.util.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(

) : ViewModel() {
	private val userEmail = MutableStateFlow("")

	private val userPw = MutableStateFlow("")

	private val userPwCheck = MutableStateFlow("")

	val toastMessage = MutableStateFlow("")

	fun setUserEmail(email: String) {
		userEmail.value = email
		Log.d("UserEmail", userEmail.value)
	}

	fun setUserPw(password: String) {
		userPw.value = password
		Log.d("UserPw", userPw.value)
	}

	fun setUserPwCheck(pwCheck: String) {
		userPwCheck.value = pwCheck
		Log.d("UserPwCheck", userPwCheck.value)
	}

	fun isSignUpSuccess(): Boolean {
		if (isEmailEmpty()) return false
		if (isNotSatisfyEmailPattern()) return false
		if (isPasswordEmpty()) return false
		if (isNotSatisfyPasswordLength()) return false
		if (isNotSatisfyPasswordValidation()) return false
		if (isPasswordNotSame()) return false
		toastMessage.value = "통과"
		return true
	}

	fun isEmailEmpty(): Boolean {
		val condition = userEmail.value.isEmpty()
		return getResultOfCondition(condition, EMAIL_EMPTY)
	}

	fun isNotSatisfyEmailPattern(): Boolean {
		val condition = !PatternsCompat.EMAIL_ADDRESS.matcher(userEmail.value).matches()
		return getResultOfCondition(condition, EMAIL_PATTERN_NOT_SATISFIED)
	}

	fun isPasswordEmpty(): Boolean {
		val condition = userPw.value.isEmpty()
		return getResultOfCondition(condition, PASSWORD_EMPTY)
	}

	fun isNotSatisfyPasswordLength(minLen: Int = 8, maxLen: Int = 20): Boolean {
		val length = userPw.value.length
		val condition = length < minLen || length > maxLen
		return getResultOfCondition(condition, PASSWORD_LENGTH_NOT_SATISFIED)
	}

	fun isNotSatisfyPasswordValidation(): Boolean {
		val reg = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,20}")
		val condition = !userPw.value.matches(reg)
		return getResultOfCondition(condition, PASSWORD_VALIDATION_NOT_SATISFIED)
	}

	fun isPasswordNotSame(): Boolean {
		val condition = userPw.value != userPwCheck.value
		return getResultOfCondition(condition, PASSWORD_NOT_SAME)
	}

	fun initToastMessage() {
		toastMessage.value = ""
	}

	// 조건을 만족하면 toast message와 함께 true, 아니면 false 반환
	private fun getResultOfCondition(condition: Boolean, message: String): Boolean =
		if (condition) {
			toastMessage.value = message
			true
		} else {
			false
		}
}