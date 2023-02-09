package com.ovn.momo.core.usecase

import com.ovn.momo.core.data.repository.TempRepository
import javax.inject.Inject

class TempUseCase @Inject constructor(
	private val tempRepository: TempRepository
) {

	operator fun invoke() {

	}
}