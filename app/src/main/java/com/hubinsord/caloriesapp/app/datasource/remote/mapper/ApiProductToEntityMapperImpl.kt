package com.hubinsord.caloriesapp.app.datasource.remote.mapper

import com.hubinsord.caloriesapp.app.datasource.remote.model.ApiProduct
import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.core.domain.interfaces.Mapper
import javax.inject.Inject

interface ApiProductToEntityMapper : Mapper<ApiProduct, Product>

class ApiProductToEntityMapperImpl @Inject constructor() : ApiProductToEntityMapper {
    override fun map(value: ApiProduct): Product {
        return Product(
            id = value.id,
            productName = value.productName,
//            brand = value.brand,
            keywords = value.keywords,
            grade = value.grade,
//            imageUrl = value.imageUrl,
//            nutriments = value.nutriments
        )
    }
}