package com.hubinsord.caloriesapp.app.datasource.remote.mapper

import com.hubinsord.caloriesapp.app.datasource.remote.model.ProductEntity
import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.core.domain.interfaces.Mapper
import javax.inject.Inject

interface ProductResponseEntityToProductMapper : Mapper<ProductEntity, Product>

class ApiProductToEntityMapperImpl @Inject constructor() : ProductResponseEntityToProductMapper {
    override fun map(value: ProductEntity): Product {
        return Product(
            id = value.id,
            productName = value.productName ?: "",
//            brand = value.brand,
            keywords = value.keywords,
            grade = value.grade,
            imageUrl = value.imageUrl ?: "",
//            nutriments = value.nutriments
        )
    }
}