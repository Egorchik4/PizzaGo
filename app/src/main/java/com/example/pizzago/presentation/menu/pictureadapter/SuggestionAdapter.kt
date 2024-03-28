package com.example.pizzago.presentation.menu.pictureadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.pizzago.domain.entity.SuggestionPictureEntity

class SuggestionAdapter : ListAdapter<SuggestionPictureEntity, SuggestionViewHolder>(SuggestionDiffCallback()) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
		SuggestionViewHolder.from(parent)

	override fun onBindViewHolder(holder: SuggestionViewHolder, position: Int) {
		holder.bind(getItem(position))
	}
}

class SuggestionDiffCallback : DiffUtil.ItemCallback<SuggestionPictureEntity>() {

	override fun areItemsTheSame(oldItem: SuggestionPictureEntity, newItem: SuggestionPictureEntity): Boolean {
		return oldItem.pictureUrl == newItem.pictureUrl
	}

	override fun areContentsTheSame(oldItem: SuggestionPictureEntity, newItem: SuggestionPictureEntity): Boolean {
		return oldItem == newItem
	}
}