package com.hubinsord.caloriesapp.app.datasource.remote.di

import com.hubinsord.caloriesapp.core.data.interfaces.ProductInfoRemoteDataSource
import com.hubinsord.caloriesapp.core.data.repository.OpenFoodRepositoryImpl
import com.hubinsord.caloriesapp.core.domain.interfaces.OpenFoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOpenFoodRepository(productInfoRemoteDataSource: ProductInfoRemoteDataSource): OpenFoodRepository =
        OpenFoodRepositoryImpl(productInfoRemoteDataSource)
}