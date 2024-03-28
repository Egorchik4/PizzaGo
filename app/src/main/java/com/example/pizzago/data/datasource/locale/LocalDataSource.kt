package com.example.pizzago.data.datasource.locale

import com.example.pizzago.data.datasource.locale.model.CategoriesDbModel
import com.example.pizzago.data.datasource.locale.model.MealDbModel

interface LocalDataSource {

	suspend fun getMeals(): List<MealDbModel>

	suspend fun saveMeals(meals: List<MealDbModel>)

	suspend fun getCategories(): List<CategoriesDbModel>

	suspend fun saveCategories(categories: List<CategoriesDbModel>)
}