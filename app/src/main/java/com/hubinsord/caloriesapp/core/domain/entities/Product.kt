package com.hubinsord.caloriesapp.core.domain.entities

data class Product(
    val id: String,
    val productName: String,
//    val brand: String,
    val keywords: List<String>,
    val grade: String,
    val imageUrl: String,
//    val nutriments: ApiNutriments
) {
}