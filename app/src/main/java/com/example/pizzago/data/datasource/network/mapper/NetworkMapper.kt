package com.example.pizzago.data.datasource.network.mapper

import com.example.pizzago.data.datasource.network.models.Categories
import com.example.pizzago.data.datasource.network.models.Meals
import com.example.pizzago.domain.entity.CategoriesEntity
import com.example.pizzago.domain.entity.MealEntity

private const val BASE_PICTURE =
	"https://s3-alpha-sig.figma.com/img/a3ca/116b/17313d5ca7c7a453d04612b427740131?Expires=1712534400&Key-Pair-Id=" +
		"APKAQ4GOSFWCVNEHN3O4&Signature=b1yrxNLW~LwwNC6PSb7gcTeH5dE3~lndUpNDuTB0D7m42~NhEUBpdsFBRFZftm4fWz06hCFe2sWvTi" +
		"sKYcVQpCmmRYxeThUDnkdPMgg4IfZUXT4cB2skqkMOrkvrMbNJw3FRLanja7s7Sm0yNhs6BSxiQvMdPh~FJzwjFOgkqFeLo9d~5CWABhYyVK4wG" +
		"8iK67J3vSBkegBLSDqsm6kjy3F-avJ-2TORKedojc0ZExqOqdJWkrliZ1vfdHL5UOlRcZJb6ALRtztBHgClJ358DZ05C36LKd-6Fl-mNG75fCEnaFRDUY38EW" +
		"csLBvQQgYfkG-31UEYwCLECvd8A-lzCQ__"

fun List<Meals>.toMealEntity(): List<MealEntity> =
	map(Meals::toMealEntity)

fun Meals.toMealEntity(): MealEntity =
	MealEntity(
		idMeal = idMeal,
		strMeal = strMeal,
		strCategory = strCategory,
		strPrice = "от 345 р",
		strInstructions = strInstructions,
		strImageSource = strImageSource ?: BASE_PICTURE
	)

fun List<Categories>.toCategoriesEntity(): List<CategoriesEntity> =
	map { it.toCategoriesEntity() }

fun Categories.toCategoriesEntity(): CategoriesEntity =
	CategoriesEntity(id = idCategory.toInt(), isChecked = false, strCategory = strCategory)