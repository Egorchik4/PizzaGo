package com.example.pizzago.data.datasource.locale.mapper

import com.example.pizzago.data.datasource.locale.model.MealDbModel
import com.example.pizzago.domain.entity.MealEntity

fun List<MealDbModel>.toListMealEntity() = map(MealDbModel::toMealEntity)

fun MealDbModel.toMealEntity(): MealEntity =
	MealEntity(
		idMeal = id.toString(),
		strMeal = meal,
		strCategory = category,
		strPrice = price,
		strInstructions = instructions,
		strImageSource = imageSource
	)

fun List<MealEntity>.toListMealDbModel() = map(MealEntity::toMealDbModel)

fun MealEntity.toMealDbModel(): MealDbModel =
	MealDbModel(
		id = idMeal.toLong(),
		meal = strMeal,
		category = strCategory,
		price = strPrice,
		instructions = strInstructions,
		imageSource = strImageSource ?: "",
	)