package com.hubinsord.caloriesapp.app.datasource.remote

import com.hubinsord.caloriesapp.app.datasource.remote.api.OpenFoodApi
import com.hubinsord.caloriesapp.app.datasource.remote.mapper.ApiProductInfoToEntityMapper
import com.hubinsord.caloriesapp.core.data.interfaces.ProductInfoRemoteDataSource
import com.hubinsord.caloriesapp.core.domain.entities.ProductInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductInfoRemoteDataSourceImpl @Inject constructor(
    private val openFoodApi: OpenFoodApi,
    private val apiProductInfoToEntityMapper: ApiProductInfoToEntityMapper
) : ProductInfoRemoteDataSource {

    override suspend fun getProductInfo(productName: String): ProductInfo {
        return withContext(Dispatchers.IO) {
            apiProductInfoToEntityMapper.map(openFoodApi.getApiProductInfo(productName))
        }
    }
}