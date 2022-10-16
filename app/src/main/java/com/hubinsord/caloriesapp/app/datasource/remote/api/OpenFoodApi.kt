package com.hubinsord.caloriesapp.app.datasource.remote.api

import com.hubinsord.caloriesapp.app.datasource.remote.model.ApiProductInfo
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Headers

interface OpenFoodApi {
    @GET("cgi/search.pl?search_terms=serek+wiejski&search_simple=1&action=process&json=true")
    suspend fun getApiProductInfo(): ApiProductInfo

    companion object{
        const val BASE_URL = "https://pl.openfoodfacts.org/"
    }

}

