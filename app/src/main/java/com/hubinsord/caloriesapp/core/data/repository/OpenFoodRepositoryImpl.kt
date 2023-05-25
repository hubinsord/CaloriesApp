package com.hubinsord.caloriesapp.core.data.repository

import com.hubinsord.caloriesapp.app.datasource.local.ProductLocalDataSource
import com.hubinsord.caloriesapp.core.data.interfaces.ProductInfoRemoteDataSource
import com.hubinsord.caloriesapp.core.data.utils.safeCall
import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.core.domain.entities.Resource
import com.hubinsord.caloriesapp.core.domain.interfaces.OpenFoodRepository
import javax.inject.Inject

class OpenFoodRepositoryImpl @Inject constructor(
    private val productInfoRemoteDataSource: ProductInfoRemoteDataSource,
    private val productLocalDataSource: ProductLocalDataSource
) : OpenFoodRepository {


    override suspend fun getProductsByName(productName: String, shouldFetchFromRemote: Boolean): Resource<List<Product>> {
        return safeCall {
            productInfoRemoteDataSource.getProductInfo(productName).products
        }
    }

    override suspend fun insertProducts(products: List<Product>) {
        products.forEach { productLocalDataSource.insertProduct(it) }
    }

    override suspend fun getProduct(barcode: String): Resource<Product> {
        return safeCall {
            productInfoRemoteDataSource.getProduct(barcode)
        }
    }
}

//    override suspend fun getProductInfoByName(productName: String): Resource<ProductInfo> {
//        return safeCall {
//            productInfoRemoteDataSource.getProductInfo(productName)
//        }
//    }

//    override suspend fun getProductsByName(productName: String, shouldFetchFromRemote: Boolean): Resource<List<Product>> {
//        return safeCall {
//            val localProduct = productLocalDataSource.getProducts(productName)
//            if (localProduct == null || shouldFetchFromRemote) {
//                productInfoRemoteDataSource.getProductInfo(productName).products
//            } else
//                localProduct
//        }
//    }

