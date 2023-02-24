package com.ovn.momo.feature.signup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpSecurityCodeViewModel @Inject constructor(

) : ViewModel() {

	private val _securityCode = MutableStateFlow("")
	private val _securityBtn = MutableStateFlow(false)
	val securityBtn = _securityBtn.asStateFlow()

	fun setSecurityCode(code: String) {
		_securityCode.value = code
		_securityBtn.value = _securityCode.value.isNotEmpty()
	}
}