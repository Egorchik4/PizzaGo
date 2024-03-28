package com.example.pizzago.presentation.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pizzago.databinding.FragmentMenuBinding
import com.example.pizzago.presentation.menu.categoryadapter.CategoriesAdapter
import com.example.pizzago.presentation.menu.mealadapter.MealAdapter
import com.example.pizzago.presentation.menu.pictureadapter.SuggestionAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment() {

	private lateinit var binding: FragmentMenuBinding
	private val viewModel: MenuViewModel by viewModels()
	private lateinit var adapter: MealAdapter
	private lateinit var pictureAdapter: SuggestionAdapter
	private lateinit var categoriesAdapter: CategoriesAdapter

	companion object {

		const val FRAGMENT_MENU_TAG = "FRAGMENT_MENU_TAG"

		fun newInstance() = MenuFragment()
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		binding = FragmentMenuBinding.inflate(inflater)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		bindAdapter()
		setObservers()
		viewModel.loadPizzas()
	}

	private fun bindAdapter() {
		with(binding) {
			pictureAdapter = SuggestionAdapter()
			rcViewPicture.adapter = pictureAdapter

			categoriesAdapter = CategoriesAdapter(viewModel::filterMeal)
			rcViewCategories.adapter = categoriesAdapter

			adapter = MealAdapter()
			rcView.adapter = adapter
		}
	}

	private fun setObservers() {
		viewModel.suggestionLive.observe(viewLifecycleOwner) {
			pictureAdapter.submitList(it)
		}
		viewModel.categoriesLive.observe(viewLifecycleOwner) {
			categoriesAdapter.submitList(it)
		}
		viewModel.pizzasLive.observe(viewLifecycleOwner) {
			adapter.submitList(it)
		}
		viewModel.loadingLive.observe(viewLifecycleOwner) {
			handleLoad(it)
		}
		viewModel.errorLive.observe(viewLifecycleOwner) {
			handleError(it)
		}
	}

	private fun handleLoad(it: Boolean) {
		with(binding) {
			if (it) {
				progressBar.visibility = View.VISIBLE
				appBar.visibility = View.INVISIBLE
				rcView.visibility = View.INVISIBLE
			} else {
				progressBar.visibility = View.INVISIBLE
				appBar.visibility = View.VISIBLE
				rcView.visibility = View.VISIBLE
			}
		}
	}

	private fun handleError(message: String) {
		with(binding) {
			progressBar.visibility = View.INVISIBLE
			appBar.visibility = View.INVISIBLE
			rcView.visibility = View.INVISIBLE
			Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
		}
	}
}