package com.hubinsord.caloriesapp.app.datasource.remote.api

import com.hubinsord.caloriesapp.app.datasource.remote.model.ApiProduct
import com.hubinsord.caloriesapp.app.datasource.remote.model.ApiProductInfo
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
    ): ApiProductInfo

    @GET("api/v2/product/5900531007019")
    suspend fun getProduct(
//        @Path("barcode")
//        barcode: String
     ): ApiProduct

    companion object {
        const val BASE_URL = "https://pl.openfoodfacts.org/"
    }

}

