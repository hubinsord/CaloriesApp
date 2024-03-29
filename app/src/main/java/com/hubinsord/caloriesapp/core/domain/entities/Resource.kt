package com.hubinsord.caloriesapp.core.domain.entities

sealed class Resource<T>(
    val data: T? = null,
    val error: String? = null,
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(error: String?, data: T? = null) : Resource<T>(data, error)
}