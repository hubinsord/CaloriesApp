package com.hubinsord.caloriesapp.core.domain.entities


data class ProductInfo(
    val count: Int,
    val page: Int,
    val pageCount: Int,
    val pageSize: Int,
    val products: List<Product>
) {
}