package com.example.pizzago.data.repository

import com.example.pizzago.core.CheckInternetConnection
import com.example.pizzago.data.datasource.locale.LocalDataSource
import com.example.pizzago.data.datasource.locale.mapper.toListCategoriesDbModel
import com.example.pizzago.data.datasource.locale.mapper.toListCategoriesEntity
import com.example.pizzago.data.datasource.locale.mapper.toListMealDbModel
import com.example.pizzago.data.datasource.locale.mapper.toListMealEntity
import com.example.pizzago.data.datasource.network.NetworkDataSource
import com.example.pizzago.data.datasource.network.mapper.toCategoriesEntity
import com.example.pizzago.data.datasource.network.mapper.toMealEntity
import com.example.pizzago.domain.entity.CategoriesEntity
import com.example.pizzago.domain.entity.MealEntity
import com.example.pizzago.domain.repository.MealRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
	private val networkDataSource: NetworkDataSource,
	private val localDataSource: LocalDataSource,
	private val checkInternetConnection: CheckInternetConnection
) : MealRepository {

	override suspend fun getMeal(): List<MealEntity> =
		if (checkInternetConnection.internetIsAvailable()) {
			val mealList = networkDataSource.getMeal().meals.toMealEntity()
			saveMealsToDataBase(mealList)
			mealList
		} else {
			getMealsFromDataBase()
		}

	override suspend fun getCategories(): List<CategoriesEntity> =
		if (checkInternetConnection.internetIsAvailable()) {
			val categories = networkDataSource.getCategories().categories.toCategoriesEntity()
			saveCategoriesToDataBase(categories)
			categories
		} else {
			getCategoriesFromDataBase()
		}

	private suspend fun saveMealsToDataBase(mealList: List<MealEntity>) = withContext(Dispatchers.IO) {
		localDataSource.saveMeals(mealList.toListMealDbModel())
	}

	private suspend fun getMealsFromDataBase() = withContext(Dispatchers.IO) {
		return@withContext localDataSource.getMeals().toListMealEntity()
	}

	private suspend fun saveCategoriesToDataBase(categoriesList: List<CategoriesEntity>) = withContext(Dispatchers.IO) {
		localDataSource.saveCategories(categoriesList.toListCategoriesDbModel())
	}

	private suspend fun getCategoriesFromDataBase() = withContext(Dispatchers.IO) {
		return@withContext localDataSource.getCategories().toListCategoriesEntity()
	}
}