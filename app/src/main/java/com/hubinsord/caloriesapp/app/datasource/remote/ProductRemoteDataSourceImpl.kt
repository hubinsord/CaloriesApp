package com.hubinsord.caloriesapp.app.datasource.remote

import com.hubinsord.caloriesapp.app.datasource.remote.api.OpenFoodApi
import com.hubinsord.caloriesapp.app.datasource.remote.mapper.ProductResponseEntityToProductMapperImpl
import com.hubinsord.caloriesapp.app.datasource.remote.mapper.ApiProductToEntityMapperImpl
import com.hubinsord.caloriesapp.core.data.interfaces.ProductRemoteDataSource
import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.core.domain.entities.ProductInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRemoteDataSourceImpl @Inject constructor(
    private val openFoodApi: OpenFoodApi,
    private val apiProductInfoToEntityMapper: ProductResponseEntityToProductMapperImpl,
    private val apiProductToEntityMapper: ApiProductToEntityMapperImpl
) : ProductRemoteDataSource {

    override suspend fun getProductInfo(productName: String): ProductInfo {
        return withContext(Dispatchers.IO) {
            apiProductInfoToEntityMapper.map(openFoodApi.getApiProductInfo(productName))
        }
    }

    override suspend fun getProduct(barcode: String): Product {
        return withContext(Dispatchers.IO){
            apiProductToEntityMapper.map(openFoodApi.getProduct(barcode).product)
        }

    }
}