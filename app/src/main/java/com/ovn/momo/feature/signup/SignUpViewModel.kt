package com.ovn.momo.feature.signup

import android.util.Log
import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(

) : ViewModel() {
	private val userEmail = MutableStateFlow("")
	private val _userEmailError = MutableStateFlow(false)
	val userEmailError get() = _userEmailError.asStateFlow()

	private val _userEmailErrorMsg = MutableStateFlow("")
	val userEmailErrorMsg get() = _userEmailErrorMsg.asStateFlow()

	private val userPw = MutableStateFlow("")
	private val _userPwError = MutableStateFlow(false)
	val userPwError get() = _userPwError.asStateFlow()

	private val _userPwErrorMsg = MutableStateFlow("")
	val userPwErrorMsg get() = _userPwErrorMsg.asStateFlow()

	private val userPwCheck = MutableStateFlow("")

	private val _toastMessage = MutableStateFlow("")
	val toastMessage: StateFlow<String> get()=_toastMessage.asStateFlow()

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

	fun setToastMessage(message: String) {
		_toastMessage.value = message
	}

	fun isSignUpSuccess(): Boolean {
		if (isEmailEmpty()) return false
		if (isNotSatisfyEmailPattern()) return false
		if (isPasswordEmpty()) return false
		if (isNotSatisfyPasswordLength()) return false
		if (isNotSatisfyPasswordValidation()) return false
		if (isPasswordNotSame()) return false
		return true
	}

	fun isEmailEmpty(): Boolean {
		val condition = userEmail.value.isEmpty()
		return getResultOfEmailCondition(condition, EMAIL_EMPTY)
	}

	fun isNotSatisfyEmailPattern(): Boolean {
		val condition = !PatternsCompat.EMAIL_ADDRESS.matcher(userEmail.value).matches()
		return getResultOfEmailCondition(condition, EMAIL_PATTERN_NOT_SATISFIED)
	}

	fun isPasswordEmpty(): Boolean {
		val condition = userPw.value.isEmpty()
		return getResultOfPwCondition(condition, PASSWORD_EMPTY)
	}

	fun isNotSatisfyPasswordLength(minLen: Int = 8, maxLen: Int = 20): Boolean {
		val length = userPw.value.length
		val condition = length < minLen || length > maxLen
		return getResultOfPwCondition(condition, PASSWORD_LENGTH_NOT_SATISFIED)
	}

	fun isNotSatisfyPasswordValidation(): Boolean {
		val reg = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,20}")
		val condition = !userPw.value.matches(reg)
		return getResultOfPwCondition(condition, PASSWORD_VALIDATION_NOT_SATISFIED)
	}

	fun isPasswordNotSame(): Boolean {
		val condition = userPw.value != userPwCheck.value
		return getResultOfPwCondition(condition, PASSWORD_NOT_SAME)
	}

	fun initToastMessage() {
		_toastMessage.value = ""
	}

	// 조건을 만족하면 toast message와 함께 true, 아니면 false 반환
	private fun getResultOfEmailCondition(condition: Boolean, errorMsg: String): Boolean {
		_userEmailError.value = condition
		_userEmailErrorMsg.value = if (condition) errorMsg else ""
		return condition
	}

	// 조건을 만족하면 toast message와 함께 true, 아니면 false 반환
	private fun getResultOfPwCondition(condition: Boolean, errorMsg: String): Boolean {
		_userPwError.value = condition
		_userPwErrorMsg.value = if (condition) errorMsg else ""
		return condition
	}
}