package com.hubinsord.caloriesapp.app.datasource.remote.di

import com.hubinsord.caloriesapp.app.datasource.remote.mapper.ApiProductInfoToEntityMapper
import com.hubinsord.caloriesapp.app.datasource.remote.mapper.ProductResponseEntityToProductMapperImpl
import com.hubinsord.caloriesapp.app.datasource.remote.mapper.ProductResponseEntityToProductMapper
import com.hubinsord.caloriesapp.app.datasource.remote.mapper.ApiProductToEntityMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    fun provideApiProductToEntityMapper(): ProductResponseEntityToProductMapper = ApiProductToEntityMapperImpl()

    @Provides
    fun provideApiProductInfoToEntity(apiProductToEntityMapper: ProductResponseEntityToProductMapper): ApiProductInfoToEntityMapper =
        ProductResponseEntityToProductMapperImpl(apiProductToEntityMapper)
}