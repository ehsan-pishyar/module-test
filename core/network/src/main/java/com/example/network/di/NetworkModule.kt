package com.example.network.di

import com.example.network.ApiService
import com.example.network.utils.NetworkUtils
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun converterFactoryProvider(contentType: MediaType = "application/json".toMediaType()) =
        Json.asConverterFactory(contentType)

    @Provides
    @Singleton
    fun retrofitProvider(converterFactory: Converter.Factory) =
        Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .baseUrl(NetworkUtils.URL)
            .build()

    @Provides
    @Singleton
    fun apiServiceProvider(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}