package com.example.pizzago.domain.usecase

import com.example.pizzago.domain.entity.MealEntity
import com.example.pizzago.domain.repository.MealRepository
import javax.inject.Inject

class GetMealsUseCase @Inject constructor(private val repository: MealRepository) {

	suspend operator fun invoke(): List<MealEntity> =
		repository.getMeal()
}