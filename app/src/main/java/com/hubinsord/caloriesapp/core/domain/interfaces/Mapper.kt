package com.hubinsord.caloriesapp.core.domain.interfaces

interface Mapper<in T, out R> {
    fun map(value: T): R
}