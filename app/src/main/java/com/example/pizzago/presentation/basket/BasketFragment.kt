package com.example.pizzago.presentation.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pizzago.R

class BasketFragment : Fragment() {

	companion object {

		const val FRAGMENT_BASKET_TAG = "FRAGMENT_BASKET_TAG"

		fun newInstance() = BasketFragment()
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_basket, container, false)
	}
}