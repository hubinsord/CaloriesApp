package com.hubinsord.caloriesapp.app.datasource.local

import com.hubinsord.caloriesapp.app.datasource.local.db.ProductsDb
import com.hubinsord.caloriesapp.app.datasource.local.mapper.ProductDbEntityToEntityMapper
import com.hubinsord.caloriesapp.app.datasource.local.mapper.ProductDbEntityToEntityMapperImpl
import com.hubinsord.caloriesapp.app.datasource.local.mapper.ProductToProductDbEntityMapper
import com.hubinsord.caloriesapp.core.domain.entities.Product
import javax.inject.Inject

interface ProductLocalDataSource {
    suspend fun insertProduct(product: Product)
    suspend fun getProducts(name: String): List<Product>
    suspend fun deleteAllProducts()
}

class ProductLocalDataSourceImpl @Inject constructor(
    private val productsDb: ProductsDb,
    private val entityToProductDbEntity: ProductToProductDbEntityMapper,
    private val productDbEntityToEntity: ProductDbEntityToEntityMapper
) : ProductLocalDataSource {

    private val productDao = productsDb.getProductDao()

    override suspend fun insertProduct(product: Product) {
        productDao.insertProduct(
            entityToProductDbEntity.map(product)
        )
    }

    override suspend fun getProducts(name: String): List<Product> {
        return productDao.getAllProducts().map {
            productDbEntityToEntity.map(it)
        }
    }

    override suspend fun deleteAllProducts() {
        productDao.deleteAllProducts()
    }
}