package com.hubinsord.caloriesapp.app.datasource.local.mapper

import com.hubinsord.caloriesapp.app.datasource.local.model.ProductDbEntity
import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.core.domain.interfaces.Mapper

interface ProductDbEntityToEntityMapper : Mapper<ProductDbEntity, Product>

class ProductDbEntityToEntityMapperImpl : ProductDbEntityToEntityMapper {
    override fun map(value: ProductDbEntity): Product {
        return with(value) {
            Product(
                id = id,
                productName = productName,
                keywords = keywords,
                grade = grade,
                imageUrl = imageUrl
            )
        }
    }
}