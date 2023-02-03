package com.ovn.momo.core.network.di

import com.ovn.momo.core.network.dispatcher.Dispatcher
import com.ovn.momo.core.network.dispatcher.MomoAppDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

	@Provides
	@Dispatcher(MomoAppDispatchers.IO)
	fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}