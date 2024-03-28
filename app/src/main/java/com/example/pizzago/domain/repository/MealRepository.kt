package com.example.pizzago.domain.repository

import com.example.pizzago.domain.entity.CategoriesEntity
import com.example.pizzago.domain.entity.MealEntity

interface MealRepository {

	suspend fun getMeal(): List<MealEntity>

	suspend fun getCategories(): List<CategoriesEntity>
}