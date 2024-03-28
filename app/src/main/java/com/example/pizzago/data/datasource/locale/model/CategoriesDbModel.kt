package com.example.pizzago.data.datasource.locale.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
	tableName = "categories"
)
data class CategoriesDbModel(
	@PrimaryKey(autoGenerate = true) val id: Long,
	val category: String
)