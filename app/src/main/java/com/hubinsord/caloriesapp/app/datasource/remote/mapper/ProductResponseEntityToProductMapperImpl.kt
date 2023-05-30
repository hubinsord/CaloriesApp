package com.hubinsord.caloriesapp.app.datasource.remote.mapper

import com.hubinsord.caloriesapp.app.datasource.remote.model.ProductSearchResponseEntity
import com.hubinsord.caloriesapp.core.domain.entities.ProductInfo
import com.hubinsord.caloriesapp.core.domain.interfaces.Mapper
import javax.inject.Inject

interface ApiProductInfoToEntityMapper: Mapper<ProductSearchResponseEntity, ProductInfo>

class ProductResponseEntityToProductMapperImpl @Inject constructor(
    private val apiProductToEntityMapper: ProductResponseEntityToProductMapper
): ApiProductInfoToEntityMapper {
    override fun map(value: ProductSearchResponseEntity): ProductInfo {
        return ProductInfo(
            count = value.count,
            page = value.page,
            pageCount = value.pageCount,
            pageSize = value.pageSize,
            products = value.products.map { productEntity ->
                    apiProductToEntityMapper.map(productEntity)
            }
        )
    }
}