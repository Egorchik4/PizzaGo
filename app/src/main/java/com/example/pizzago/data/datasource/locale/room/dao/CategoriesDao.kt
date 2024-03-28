package com.example.pizzago.data.datasource.locale.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pizzago.data.datasource.locale.model.CategoriesDbModel

@Dao
interface CategoriesDao {

	@Query("SELECT * FROM categories")
	fun getCategoriesDb(): List<CategoriesDbModel>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun saveCategoriesDb(news: List<CategoriesDbModel>)
}