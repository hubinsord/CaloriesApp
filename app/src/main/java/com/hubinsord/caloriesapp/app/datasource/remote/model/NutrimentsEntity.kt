package com.hubinsord.caloriesapp.app.datasource.remote.model

import com.squareup.moshi.Json

data class NutrimentsEntity(
    @Json(name = "carbohydrates") val carbohydrates: Double,
    @Json(name = "carbohydrates_100g") val carbohydrates100g: Double,
    @Json(name = "carbohydrates_unit") val carbohydratesUnit: String,
    @Json(name = "carbohydrates_value") val carbohydratesValue: Double,
)