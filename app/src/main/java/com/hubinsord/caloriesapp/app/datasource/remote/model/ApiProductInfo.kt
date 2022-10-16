package com.hubinsord.caloriesapp.app.datasource.remote.model

import com.squareup.moshi.Json

data class ApiProductInfo(
    @Json(name = "count")
    val count: Int,

    @Json(name = "page")
    val page: Int,

    @Json(name = "page_count")
    val pageCount: Int,

    @Json(name = "page_size")
    val pageSize: Int,

    @Json(name = "products")
    val products: List<ApiProduct>
) {
}