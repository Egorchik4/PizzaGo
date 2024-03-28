package com.example.pizzago.data.datasource.locale.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
	tableName = "meals"
)
data class MealDbModel(
	@PrimaryKey(autoGenerate = true) val id: Long,
	val meal: String,
	val category: String,
	val price: String,
	val instructions: String,
	@ColumnInfo(name = "image_source") val imageSource: String?,
)