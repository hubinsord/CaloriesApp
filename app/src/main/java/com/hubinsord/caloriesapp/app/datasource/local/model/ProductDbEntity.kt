package com.hubinsord.caloriesapp.app.datasource.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.hubinsord.caloriesapp.app.datasource.local.LocalDataSourceConstants
import com.hubinsord.caloriesapp.app.datasource.local.db.ProductConverter

@Entity(tableName = LocalDataSourceConstants.TABLE_PRODUCTS )
data class ProductDbEntity(
   @PrimaryKey
    val id: String,
    val productName: String,
//    val brand: String,
    val keywords: List<String>,
    val grade: String,
    val imageUrl: String,
//    val nutriments: ApiNutriments
)
