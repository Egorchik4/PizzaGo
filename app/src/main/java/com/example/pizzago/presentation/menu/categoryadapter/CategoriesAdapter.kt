package com.example.pizzago.presentation.menu.categoryadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.pizzago.domain.entity.CategoriesEntity

class CategoriesAdapter(
	private val onItemClick: (categoriesEntity: CategoriesEntity) -> Unit
) : ListAdapter<CategoriesEntity, CategoriesViewHolder>(CategoriesDiffCallback()) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder =
		CategoriesViewHolder.from(parent)

	override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
		holder.bind(getItem(position), onItemClick, holder.itemView.context)
	}
}

class CategoriesDiffCallback : DiffUtil.ItemCallback<CategoriesEntity>() {

	override fun areItemsTheSame(oldItem: CategoriesEntity, newItem: CategoriesEntity): Boolean {
		return oldItem.strCategory == newItem.strCategory
	}

	override fun areContentsTheSame(oldItem: CategoriesEntity, newItem: CategoriesEntity): Boolean {
		return oldItem == newItem
	}
}