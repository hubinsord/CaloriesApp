package com.hubinsord.caloriesapp.app.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hubinsord.caloriesapp.app.datasource.local.dao.ProductDAO
import com.hubinsord.caloriesapp.app.datasource.local.model.ProductDbEntity

@TypeConverters(ProductConverter::class)
@Database(
    entities = [ProductDbEntity::class],
    version = 1
)
abstract class ProductsDb: RoomDatabase() {

    abstract fun getProductDao(): ProductDAO
}