package com.hubinsord.caloriesapp.app.datasource.remote.model

import com.squareup.moshi.Json

data class ProductByBarcodeResponseEntity(
    @Json(name = "code")
    val barcode: String,

    @Json(name = "product")
    val product: ProductEntity,
)
