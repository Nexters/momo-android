package com.ovn.momo.core.network.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

	// TODO 서버 도메인 생성 시 BASE_URL 입력
	private const val BASE_URL = ""

	@Singleton
	@Provides
	fun providesOkHttpClient(): OkHttpClient {
		return OkHttpClient.Builder()
			.addInterceptor(HttpLoggingInterceptor { message: String ->
				Log.d("network_info", message)
			}.setLevel(HttpLoggingInterceptor.Level.BODY))
			.build()
	}

	@Singleton
	@Provides
	fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
		return Retrofit.Builder()
			.baseUrl(BASE_URL)
			.client(okHttpClient)
			.addConverterFactory(MoshiConverterFactory.create())
			.build()
	}
}