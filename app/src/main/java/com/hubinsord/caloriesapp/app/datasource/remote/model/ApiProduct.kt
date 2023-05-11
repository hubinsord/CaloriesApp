package com.hubinsord.caloriesapp.app.datasource.remote.model

import com.squareup.moshi.Json

data class ApiProduct(
    @Json(name = "_id")
    val id: String,

    @Json(name = "product_name")
    val productName: String?,
//
//    @Json(name = "brands")
//    val brand: String,

    @Json(name = "_keywords")
    val keywords: List<String>,

    @Json(name = "ecoscore_grade")
    val grade: String,

    @Json(name = "image_url")
    val imageUrl: String?,

//    @Json(name = "nutriments")
//    val nutriments: ApiNutriments
) {
}