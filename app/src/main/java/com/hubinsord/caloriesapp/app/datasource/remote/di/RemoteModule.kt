package com.hubinsord.caloriesapp.app.datasource.remote.di

import com.hubinsord.caloriesapp.app.datasource.remote.api.OpenFoodApi
import com.hubinsord.caloriesapp.app.datasource.remote.ProductInfoRemoteDataSourceImpl
import com.hubinsord.caloriesapp.app.datasource.remote.mapper.ApiProductInfoToEntityMapper
import com.hubinsord.caloriesapp.core.data.interfaces.ProductInfoRemoteDataSource
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun provideOpenFoodApi(retrofit: Retrofit): OpenFoodApi =
        retrofit.create(OpenFoodApi::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(moshiConverterFactory: MoshiConverterFactory, client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(OpenFoodApi.BASE_URL)
            .addConverterFactory(moshiConverterFactory.asLenient())
            .client(client)
            .build()

    @Singleton
    @Provides
    fun provideMoshiConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create(
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    )

    @Singleton
    @Provides
    fun provideProductInfoRemoteDataSource(
        openFoodApi: OpenFoodApi,
        apiProductInfoToEntityMapper: ApiProductInfoToEntityMapper
    ): ProductInfoRemoteDataSource = ProductInfoRemoteDataSourceImpl(openFoodApi, apiProductInfoToEntityMapper)

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()
    }
}