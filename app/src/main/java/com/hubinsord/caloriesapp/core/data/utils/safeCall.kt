package com.hubinsord.caloriesapp.core.data.utils

import com.hubinsord.caloriesapp.core.domain.entities.Resource

inline fun <T> safeCall(block: () -> T): Resource<T> =
    try {
        Resource.Success(block.invoke())
    } catch (exception: Throwable) {
        Resource.Error(exception.message)
    }