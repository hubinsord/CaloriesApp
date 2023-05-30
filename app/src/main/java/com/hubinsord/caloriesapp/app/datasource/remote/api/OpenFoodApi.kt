package com.hubinsord.caloriesapp.app.datasource.remote.api

import com.hubinsord.caloriesapp.app.datasource.remote.model.ProductByBarcodeResponseEntity
import com.hubinsord.caloriesapp.app.datasource.remote.model.ProductSearchResponseEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OpenFoodApi {
    @GET("cgi/search.pl")
    suspend fun getApiProductInfo(
        @Query("search_terms") productName: String,
        @Query("search_simple") searchSimple: Int = 1,
        @Query("action") action: String = "process",
        @Query("json") json: Boolean = true
    ): ProductSearchResponseEntity

    @GET("api/v2/product/{barcode}")
    suspend fun getProduct(
        @Path("barcode")
        barcode: String
     ): ProductByBarcodeResponseEntity

    companion object {
        const val BASE_URL = "https://pl.openfoodfacts.org/"
    }

}

