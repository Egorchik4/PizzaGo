package com.example.pizzago.domain.usecase

import com.example.pizzago.domain.entity.CategoriesEntity
import com.example.pizzago.domain.repository.MealRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val repository: MealRepository) {

	suspend operator fun invoke(): List<CategoriesEntity> =
		repository.getCategories()
}