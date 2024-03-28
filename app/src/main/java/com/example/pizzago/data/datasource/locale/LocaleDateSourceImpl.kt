package com.example.pizzago.data.datasource.locale

import com.example.pizzago.data.datasource.locale.model.CategoriesDbModel
import com.example.pizzago.data.datasource.locale.model.MealDbModel
import com.example.pizzago.data.datasource.locale.room.dao.CategoriesDao
import com.example.pizzago.data.datasource.locale.room.dao.MealDao
import javax.inject.Inject

class LocaleDateSourceImpl @Inject constructor(
	private val mealDao: MealDao,
	private val categoriesDao: CategoriesDao
) : LocalDataSource {

	override suspend fun getMeals(): List<MealDbModel> =
		mealDao.getMealsDb()

	override suspend fun saveMeals(meals: List<MealDbModel>) =
		mealDao.saveMealsDb(meals)

	override suspend fun getCategories(): List<CategoriesDbModel> =
		categoriesDao.getCategoriesDb()

	override suspend fun saveCategories(categories: List<CategoriesDbModel>) =
		categoriesDao.saveCategoriesDb(categories)
}