package com.hubinsord.caloriesapp.app.datasource.local.mapper

import com.hubinsord.caloriesapp.app.datasource.local.model.ProductDbEntity
import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.core.domain.interfaces.Mapper

interface ProductToProductDbEntityMapper : Mapper<Product, ProductDbEntity>

class ProductToProductDbEntityMapperImpl : ProductToProductDbEntityMapper {
    override fun map(value: Product): ProductDbEntity {
        return with(value) {
            ProductDbEntity(
                id = id,
                productName = productName,
                keywords = keywords,
                grade = grade,
                imageUrl = imageUrl
            )
        }
    }
}
