package com.hubinsord.caloriesapp.app.datasource.remote.di

import com.hubinsord.caloriesapp.app.datasource.remote.api.OpenFoodApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun provideOpenFoodService(retrofit: Retrofit): OpenFoodApi =
        retrofit.create(OpenFoodApi::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(moshiConverterFactory: MoshiConverterFactory): Retrofit =
        Retrofit.Builder()
            .baseUrl(OpenFoodApi.BASE_URL)
            .addConverterFactory(moshiConverterFactory)
            .build()

    @Singleton
    @Provides
    fun provideMoshiConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create()
}