package com.hubinsord.caloriesapp.app.datasource.local.db

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class ProductConverter {

    @TypeConverter
    fun fromJson(json: String): List<String> {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter = moshi.adapter<List<String>>(type)
        return adapter.fromJson(json).orEmpty()
    }

    @TypeConverter
    fun toJson(value: List<String>): String {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter = moshi.adapter<List<String>>(type)
        return  adapter.toJson(value)
    }

}