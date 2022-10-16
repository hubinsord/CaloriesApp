package com.hubinsord.caloriesapp.core.data.repository

import com.hubinsord.caloriesapp.core.data.interfaces.ProductInfoRemoteDataSource
import com.hubinsord.caloriesapp.core.data.utils.safeCall
import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.core.domain.entities.ProductInfo
import com.hubinsord.caloriesapp.core.domain.entities.Resource
import com.hubinsord.caloriesapp.core.domain.interfaces.OpenFoodRepository
import javax.inject.Inject

class OpenFoodRepositoryImpl @Inject constructor(
    private val productInfoRemoteDataSource: ProductInfoRemoteDataSource
) : OpenFoodRepository {

    override suspend fun getProductInfo(): Resource<ProductInfo> {
        return safeCall {
            productInfoRemoteDataSource.getProductInfo()
        }
    }

    override suspend fun getProductsFromProductInfo(): List<Product> {
        var products: List<Product>
        val productInfoResource = getProductInfo()
        if (productInfoResource is Resource.Success) {
            products = productInfoResource.data?.products ?: mutableListOf()
        } else {
            throw Exception(productInfoResource.error)
        }
        return products
    }
}