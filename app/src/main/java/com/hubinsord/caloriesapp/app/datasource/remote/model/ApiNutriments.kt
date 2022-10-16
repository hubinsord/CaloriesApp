package com.hubinsord.caloriesapp.app.datasource.remote.model

import com.squareup.moshi.Json

data class ApiNutriments(
    @Json(name = "carbohydrates")
    val carbohydrates: Double,
    @Json(name = "carbohydrates_100g")
    val carbohydrates_100g: Double,
    @Json(name = "carbohydrates_unit")
    val carbohydrates_unit: String,
    @Json(name = "carbohydrates_value")
    val carbohydrates_value: Double,

)