package com.ovn.momo.feature.signup

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

internal class SignUpViewModelTest {

	@Mock
	private lateinit var viewModel: SignUpViewModel

	@Before
	fun setup() {
		MockitoAnnotations.openMocks(this)
		viewModel = SignUpViewModel()
	}

	@Test
	fun isEmailEmpty() {
		Assert.assertTrue(viewModel.isEmailEmpty())
	}

	@Test
	fun isSatisfyEmailPattern() {
		viewModel.setUserEmail("hello")
		Assert.assertTrue(viewModel.isNotSatisfyEmailPattern())
		viewModel.setUserEmail("helloello@naver")
		Assert.assertTrue(viewModel.isNotSatisfyEmailPattern())
		viewModel.setUserEmail("hello@naver.com")
		Assert.assertFalse(viewModel.isNotSatisfyEmailPattern())
	}

	@Test
	fun isPasswordEmpty() {
		Assert.assertTrue(viewModel.isPasswordEmpty())
	}

	@Test
	fun isNotSatisfyPasswordLength() {
		Assert.assertTrue(viewModel.isNotSatisfyPasswordLength())
		viewModel.setUserPw("asdasdasdasdasdasdasdsadsadasdsadasdasd")
		Assert.assertTrue(viewModel.isNotSatisfyPasswordLength())
		viewModel.setUserPw("asdasdasda")
		Assert.assertFalse(viewModel.isNotSatisfyPasswordLength())
	}

	@Test
	fun passwordValidation() {
		viewModel.setUserPw("asd")
		Assert.assertTrue(viewModel.isNotSatisfyPasswordValidation())
		viewModel.setUserPw("asdasd")
		Assert.assertTrue(viewModel.isNotSatisfyPasswordValidation())
		viewModel.setUserPw("asd1234")
		Assert.assertFalse(viewModel.isNotSatisfyPasswordValidation())
		viewModel.setUserPw("asdasdasdasdsad1112323e")
		Assert.assertTrue(viewModel.isNotSatisfyPasswordValidation())
		viewModel.setUserPw("asd123.")
		Assert.assertTrue(viewModel.isNotSatisfyPasswordValidation())
	}

	@Test
	fun isPasswordNotSame() {
		viewModel.setUserPw("asd")
		Assert.assertTrue(viewModel.isPasswordNotSame())
		viewModel.setUserPwCheck("asdf")
		Assert.assertTrue(viewModel.isPasswordNotSame())
		viewModel.setUserPwCheck("asd")
		Assert.assertFalse(viewModel.isPasswordNotSame())
	}
}