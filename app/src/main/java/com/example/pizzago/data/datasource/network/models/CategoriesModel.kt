package com.example.pizzago.data.datasource.network.models

data class CategoriesModel(
	val categories: List<Categories>
)

data class Categories(
	val idCategory: String,
	val strCategory: String
)