package com.hubinsord.caloriesapp.app.datasource.remote.model

import com.squareup.moshi.Json

data class Product(
    @Json(name = "_id")val id: Long,
    @Json(name = "product_name_pl")val productNamePl: String,
    @Json(name = "brands")val brands: String,
    @Json(name = "_keywords")val keywords: List<String>,
    @Json(name = "grade")val grade: Char,
    @Json(name = "image_url")val imageUrl: String,
    @Json(name = "nutriments")val nutriments: Map<String, String>
) {
}