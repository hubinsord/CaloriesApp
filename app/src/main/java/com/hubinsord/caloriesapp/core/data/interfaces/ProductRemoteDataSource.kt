package com.hubinsord.caloriesapp.core.data.interfaces

import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.core.domain.entities.ProductInfo

interface ProductRemoteDataSource {

    suspend fun getProductInfo(productName: String): ProductInfo

    suspend fun getProduct(barcode: String): Product
}