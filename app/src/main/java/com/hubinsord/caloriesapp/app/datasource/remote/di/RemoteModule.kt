package com.hubinsord.caloriesapp.app.datasource.remote.di

import com.hubinsord.caloriesapp.app.datasource.remote.services.OpenFoodService
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
    fun provideOpenFoodService(retrofit: Retrofit): OpenFoodService =
        retrofit.create(OpenFoodService::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(moshiConverterFactory: MoshiConverterFactory): Retrofit =
        Retrofit.Builder()
            .baseUrl(OpenFoodService.BASE_URL)
            .addConverterFactory(moshiConverterFactory)
            .build()

    @Singleton
    @Provides
    fun provideMoshiConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create()
}