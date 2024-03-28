package com.example.pizzago.data.datasource.locale.mapper

import com.example.pizzago.data.datasource.locale.model.CategoriesDbModel
import com.example.pizzago.domain.entity.CategoriesEntity

fun List<CategoriesDbModel>.toListCategoriesEntity() = map(CategoriesDbModel::toCategoriesEntity)

fun CategoriesDbModel.toCategoriesEntity(): CategoriesEntity =
	CategoriesEntity(
		id = id.toInt(),
		isChecked = false,
		strCategory = category
	)

fun List<CategoriesEntity>.toListCategoriesDbModel() = map(CategoriesEntity::toCategoriesDbModel)

fun CategoriesEntity.toCategoriesDbModel(): CategoriesDbModel =
	CategoriesDbModel(
		id = id.toLong(),
		category = strCategory,
	)