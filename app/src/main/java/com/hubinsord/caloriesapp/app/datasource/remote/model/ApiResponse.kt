package com.hubinsord.caloriesapp.app.datasource.remote.model

data class ApiResponse(
    val count: Int,
    val page: Int,
    val pageCount: Int,
    val pageSize: Int,
    val products: List<Product>
) {
}