package com.example.pizzago.data.datasource.locale.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pizzago.data.datasource.locale.model.CategoriesDbModel
import com.example.pizzago.data.datasource.locale.model.MealDbModel
import com.example.pizzago.data.datasource.locale.room.dao.CategoriesDao
import com.example.pizzago.data.datasource.locale.room.dao.MealDao

@Database(
	version = 1,
	entities = [
		MealDbModel::class,
		CategoriesDbModel::class
	]
)
abstract class LocalDatabase : RoomDatabase() {

	abstract fun getMealDao(): MealDao

	abstract fun getCategoriesDao(): CategoriesDao
}