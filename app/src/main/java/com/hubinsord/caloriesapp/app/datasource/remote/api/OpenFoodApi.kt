package com.hubinsord.caloriesapp.app.datasource.remote.api

import com.hubinsord.caloriesapp.app.datasource.remote.model.ApiProductInfo
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface OpenFoodApi {
    @GET("cgi/search.pl")
    suspend fun getApiProductInfo(
        @Query("search_terms") productName: String ,
        @Query("search_simple") searchSimple: Int = 1,
        @Query("action") action: String = "process",
        @Query("json") json: Boolean = true
    ): ApiProductInfo

    companion object {
        const val BASE_URL = "https://pl.openfoodfacts.org/"
    }

}

