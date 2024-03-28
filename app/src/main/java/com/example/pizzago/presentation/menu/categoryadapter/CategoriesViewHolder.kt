package com.example.pizzago.presentation.menu.categoryadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzago.R
import com.example.pizzago.databinding.CategoriesItemBinding
import com.example.pizzago.domain.entity.CategoriesEntity

class CategoriesViewHolder(
	private val binding: CategoriesItemBinding
) : RecyclerView.ViewHolder(binding.root) {

	companion object {

		fun from(parent: ViewGroup): CategoriesViewHolder {
			val inflater = LayoutInflater.from(parent.context)
			val binding = CategoriesItemBinding.inflate(inflater, parent, false)
			return CategoriesViewHolder(binding)
		}
	}

	fun bind(
		categories: CategoriesEntity,
		onItemClick: (entity: CategoriesEntity) -> Unit,
		context: Context,
	) {
		with(binding) {
			categoriesBtn.text = categories.strCategory
			if (categories.isChecked) {
				categoriesBtn.setTextColor(context.getColor(R.color.red))
				categoriesBtn.setBackgroundColor(context.getColor(R.color.red_100))
			} else {
				categoriesBtn.setTextColor(context.getColor(R.color.grey_text))
				categoriesBtn.setBackgroundColor(context.getColor(R.color.grey_background))
			}
			root.setOnClickListener { onItemClick(categories) }
		}
	}
}