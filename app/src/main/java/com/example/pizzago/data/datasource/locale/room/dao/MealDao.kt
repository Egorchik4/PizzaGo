package com.example.pizzago.data.datasource.locale.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pizzago.data.datasource.locale.model.MealDbModel

@Dao
interface MealDao {

	@Query("SELECT * FROM meals")
	fun getMealsDb(): List<MealDbModel>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun saveMealsDb(news: List<MealDbModel>)
}