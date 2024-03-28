package com.example.pizzago.presentation.menu.mealadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pizzago.R
import com.example.pizzago.databinding.MealItemBinding
import com.example.pizzago.domain.entity.MealEntity

class MealViewHolder(
	private val binding: MealItemBinding
) : RecyclerView.ViewHolder(binding.root) {

	companion object {

		fun from(parent: ViewGroup): MealViewHolder {
			val inflater = LayoutInflater.from(parent.context)
			val binding = MealItemBinding.inflate(inflater, parent, false)
			return MealViewHolder(binding)
		}
	}

	fun bind(
		meal: MealEntity
	) {
		with(binding) {
			Glide.with(icPizza)
				.load(meal.strImageSource)
				.error(R.drawable.ic_no_internet)
				.diskCacheStrategy(DiskCacheStrategy.NONE)
				.into(icPizza)
			pizzaName.text = meal.strMeal
			pizzaDescription.text = meal.strInstructions
			btnPrice.text = meal.strPrice
		}
	}
}