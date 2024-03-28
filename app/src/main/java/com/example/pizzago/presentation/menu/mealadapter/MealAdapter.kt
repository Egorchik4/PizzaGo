package com.example.pizzago.presentation.menu.mealadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.pizzago.domain.entity.MealEntity

class MealAdapter : ListAdapter<MealEntity, MealViewHolder>(MealDiffCallback()) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
		MealViewHolder.from(parent)

	override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
		holder.bind(getItem(position))
	}
}

class MealDiffCallback : DiffUtil.ItemCallback<MealEntity>() {

	override fun areItemsTheSame(oldItem: MealEntity, newItem: MealEntity): Boolean {
		return oldItem.idMeal == newItem.idMeal
	}

	override fun areContentsTheSame(oldItem: MealEntity, newItem: MealEntity): Boolean {
		return oldItem == newItem
	}
}