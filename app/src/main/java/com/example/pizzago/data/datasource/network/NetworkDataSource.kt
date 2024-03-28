package com.example.pizzago.data.datasource.network

import com.example.pizzago.data.datasource.network.models.CategoriesModel
import com.example.pizzago.data.datasource.network.models.MealModel

interface NetworkDataSource {

	suspend fun getMeal(): MealModel

	suspend fun getCategories(): CategoriesModel
}