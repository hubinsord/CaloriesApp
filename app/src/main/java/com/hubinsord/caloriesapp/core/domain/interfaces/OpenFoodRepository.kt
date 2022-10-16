package com.hubinsord.caloriesapp.core.domain.interfaces

import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.core.domain.entities.ProductInfo
import com.hubinsord.caloriesapp.core.domain.entities.Resource

interface OpenFoodRepository {

    suspend fun getProductInfo(): Resource<ProductInfo>
    suspend fun getProductsFromProductInfo(): List<Product>
}