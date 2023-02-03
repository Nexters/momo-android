package com.ovn.momo.core.network.dispatcher

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val momoAppDispatchers: MomoAppDispatchers)

enum class MomoAppDispatchers {
	IO
}