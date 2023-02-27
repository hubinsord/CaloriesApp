package com.hubinsord.caloriesapp.core.data.utils

import com.hubinsord.caloriesapp.core.domain.entities.Result

inline fun <T> safeCall(block: () -> T): Result<T> =
    try {
        Result.Success(block.invoke())
    } catch (exception: Throwable) {
        Result.Error(exception.message)
    }