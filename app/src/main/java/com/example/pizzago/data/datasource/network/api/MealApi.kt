package com.example.pizzago.data.datasource.network.api

import com.example.pizzago.data.datasource.network.models.CategoriesModel
import com.example.pizzago.data.datasource.network.models.MealModel
import retrofit2.http.GET
import retrofit2.http.POST

interface MealApi {

	@POST("search.php?s")
	suspend fun getPizzas(): MealModel

	@GET("categories.php")
	suspend fun getCategories(): CategoriesModel
}