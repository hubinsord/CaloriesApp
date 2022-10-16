package com.hubinsord.caloriesapp.app.datasource.remote.mapper

import com.hubinsord.caloriesapp.app.datasource.remote.model.ApiProductInfo
import com.hubinsord.caloriesapp.core.domain.entities.ProductInfo
import com.hubinsord.caloriesapp.core.domain.interfaces.Mapper
import javax.inject.Inject

interface ApiProductInfoToEntityMapper: Mapper<ApiProductInfo, ProductInfo>

class ApiProductInfoToEntityMapperImpl @Inject constructor(
    private val apiProductToEntityMapper: ApiProductToEntityMapper
): ApiProductInfoToEntityMapper {
    override fun map(value: ApiProductInfo): ProductInfo {
        return ProductInfo(
            count = value.count,
            page = value.page,
            pageCount = value.pageCount,
            pageSize = value.pageSize,
            products = value.products.map { apiProduct ->
                    apiProductToEntityMapper.map(apiProduct)
            }
        )
    }
}