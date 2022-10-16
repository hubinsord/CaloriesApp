package com.hubinsord.caloriesapp.core.data.interfaces

import com.hubinsord.caloriesapp.core.domain.entities.ProductInfo

interface ProductInfoRemoteDataSource {

    suspend fun getProductInfo(productName: String): ProductInfo
}