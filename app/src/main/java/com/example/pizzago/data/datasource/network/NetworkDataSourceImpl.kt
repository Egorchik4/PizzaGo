package com.example.pizzago.data.datasource.network

import com.example.pizzago.data.datasource.network.api.MealApi
import com.example.pizzago.data.datasource.network.models.CategoriesModel
import com.example.pizzago.data.datasource.network.models.MealModel
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(private val api: MealApi) : NetworkDataSource {

	override suspend fun getMeal(): MealModel = api.getPizzas()

	override suspend fun getCategories(): CategoriesModel = api.getCategories()
}