package com.ovn.momo.core.data.di

import com.ovn.momo.core.data.repository.TempRepository
import com.ovn.momo.core.data.repository.TempRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

	@Binds
	fun bindsTempRepository(
		tempRepository: TempRepositoryImpl
	): TempRepository
}