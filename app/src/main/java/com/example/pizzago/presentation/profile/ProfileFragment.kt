package com.example.pizzago.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pizzago.R

class ProfileFragment : Fragment() {

	companion object {

		const val FRAGMENT_PROFILE_TAG = "FRAGMENT_PROFILE_TAG"

		fun newInstance() = ProfileFragment()
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		return inflater.inflate(R.layout.fragment_profile, container, false)
	}
}