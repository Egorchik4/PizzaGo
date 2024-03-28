package com.example.pizzago.presentation.menu.pictureadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pizzago.R
import com.example.pizzago.databinding.MealPictureItemBinding
import com.example.pizzago.domain.entity.SuggestionPictureEntity

class SuggestionViewHolder(
	private val binding: MealPictureItemBinding
) : RecyclerView.ViewHolder(binding.root) {

	companion object {

		fun from(parent: ViewGroup): SuggestionViewHolder {
			val inflater = LayoutInflater.from(parent.context)
			val binding = MealPictureItemBinding.inflate(inflater, parent, false)
			return SuggestionViewHolder(binding)
		}
	}

	fun bind(
		picture: SuggestionPictureEntity
	) {
		with(binding) {
			Glide.with(suggestionPicture)
				.load(picture.pictureUrl)
				.error(R.drawable.ic_no_internet)
				.diskCacheStrategy(DiskCacheStrategy.NONE)
				.into(suggestionPicture)
		}
	}
}