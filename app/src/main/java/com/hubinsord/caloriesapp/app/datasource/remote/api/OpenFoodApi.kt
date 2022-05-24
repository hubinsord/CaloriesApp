package com.hubinsord.caloriesapp.app.datasource.remote.api

import com.hubinsord.caloriesapp.app.datasource.remote.model.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface OpenFoodApi {

    @GET("search_terms=serek+wiejski&search_simple=1&action=process&json=true")
    fun getApiResponse(): Flow<ApiResponse>

    companion object{
        const val BASE_URL = "https://pl.openfoodfacts.org/cgi/search.pl"
    }
}

