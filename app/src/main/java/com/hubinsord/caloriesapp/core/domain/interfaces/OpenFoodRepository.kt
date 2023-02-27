package com.hubinsord.caloriesapp.core.domain.interfaces

import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.core.domain.entities.ProductInfo
import com.hubinsord.caloriesapp.core.domain.entities.Result

interface OpenFoodRepository {

    suspend fun getProductInfoByName(productName: String): Result<ProductInfo>
    suspend fun getProductsByName(productName: String): List<Product>
}