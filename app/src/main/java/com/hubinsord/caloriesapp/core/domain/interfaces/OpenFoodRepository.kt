package com.hubinsord.caloriesapp.core.domain.interfaces

import com.hubinsord.caloriesapp.app.datasource.remote.model.ApiResponse
import kotlinx.coroutines.flow.Flow

interface OpenFoodRepository {
    suspend fun getProductInfo(): Flow<ApiResponse>
}