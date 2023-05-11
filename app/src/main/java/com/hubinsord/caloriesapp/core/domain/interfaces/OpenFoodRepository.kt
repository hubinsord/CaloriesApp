package com.hubinsord.caloriesapp.core.domain.interfaces

import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.core.domain.entities.ProductInfo
import com.hubinsord.caloriesapp.core.domain.entities.Resource

interface OpenFoodRepository {

    suspend fun getProductInfoByName(productName: String): Resource<ProductInfo>
    suspend fun getProductsByName(productName: String, shouldFetchFromRemote: Boolean): Resource<List<Product>>
    suspend fun insertProducts(products: List<Product>)
}