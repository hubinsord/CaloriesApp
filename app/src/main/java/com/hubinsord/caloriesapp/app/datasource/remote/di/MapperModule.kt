package com.hubinsord.caloriesapp.app.datasource.remote.di

import com.hubinsord.caloriesapp.app.datasource.remote.mapper.ApiProductInfoToEntityMapper
import com.hubinsord.caloriesapp.app.datasource.remote.mapper.ApiProductInfoToEntityMapperImpl
import com.hubinsord.caloriesapp.app.datasource.remote.mapper.ApiProductToEntityMapper
import com.hubinsord.caloriesapp.app.datasource.remote.mapper.ApiProductToEntityMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    fun provideApiProductToEntityMapper(): ApiProductToEntityMapper = ApiProductToEntityMapperImpl()

    @Provides
    fun provideApiProductInfoToEntity(apiProductToEntityMapper: ApiProductToEntityMapper): ApiProductInfoToEntityMapper =
        ApiProductInfoToEntityMapperImpl(apiProductToEntityMapper)
}