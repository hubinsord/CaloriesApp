package com.hubinsord.caloriesapp.app.datasource.local.di

import android.content.Context
import androidx.room.Room
import com.hubinsord.caloriesapp.app.datasource.local.LocalDataSourceConstants
import com.hubinsord.caloriesapp.app.datasource.local.ProductLocalDataSource
import com.hubinsord.caloriesapp.app.datasource.local.ProductLocalDataSourceImpl
import com.hubinsord.caloriesapp.app.datasource.local.db.ProductsDb
import com.hubinsord.caloriesapp.app.datasource.local.mapper.ProductDbEntityToEntityMapper
import com.hubinsord.caloriesapp.app.datasource.local.mapper.ProductDbEntityToEntityMapperImpl
import com.hubinsord.caloriesapp.app.datasource.local.mapper.ProductToProductDbEntityMapper
import com.hubinsord.caloriesapp.app.datasource.local.mapper.ProductToProductDbEntityMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideProductLocalDataSource(
        productsDb: ProductsDb,
        entityToProductDbEntityMapper: ProductToProductDbEntityMapper,
        productDbEntityToEntity: ProductDbEntityToEntityMapper
    ): ProductLocalDataSource =
        ProductLocalDataSourceImpl(
            productsDb = productsDb,
            entityToProductDbEntity = entityToProductDbEntityMapper,
            productDbEntityToEntity = productDbEntityToEntity
        )


    @Provides
    @Singleton
    fun provideProductsDatabase(@ApplicationContext context: Context): ProductsDb {
        return Room.databaseBuilder(
            context,
            ProductsDb::class.java,
            LocalDataSourceConstants.TABLE_PRODUCTS
        )
            .build()
    }

    @Provides
    fun provideProductToProductDbEntityMapper(): ProductToProductDbEntityMapper = ProductToProductDbEntityMapperImpl()

    @Provides
    fun provideProductDbEntityToEntityMapper(): ProductDbEntityToEntityMapper = ProductDbEntityToEntityMapperImpl()
}