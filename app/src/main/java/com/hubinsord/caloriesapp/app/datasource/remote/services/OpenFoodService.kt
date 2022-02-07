package com.hubinsord.caloriesapp.app.datasource.remote.services

import com.hubinsord.caloriesapp.app.datasource.remote.model.ApiResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface OpenFoodService {

    @GET("search_terms=serek+wiejski&search_simple=1&action=process&json=true")
    fun getApiResponse(): Observable<ApiResponse>

    companion object{
        const val BASE_URL = "https://pl.openfoodfacts.org/cgi/search.pl"
    }
}

