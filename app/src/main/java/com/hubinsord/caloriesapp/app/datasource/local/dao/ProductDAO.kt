package com.hubinsord.caloriesapp.app.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hubinsord.caloriesapp.app.datasource.local.LocalDataSourceConstants.TABLE_PRODUCTS
import com.hubinsord.caloriesapp.app.datasource.local.model.ProductDbEntity

@Dao
interface ProductDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: ProductDbEntity)

    @Query("DELETE FROM $TABLE_PRODUCTS")
    suspend fun deleteAllProducts()

    @Query("SELECT * FROM $TABLE_PRODUCTS ")
    fun getAllProducts(): List<ProductDbEntity>

}