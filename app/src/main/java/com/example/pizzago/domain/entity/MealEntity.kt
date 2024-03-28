package com.example.pizzago.domain.entity

data class MealEntity(
	val idMeal: String,
	val strMeal: String,
	val strCategory: String,
	val strPrice: String,
	val strInstructions: String,
	val strImageSource: String?
)