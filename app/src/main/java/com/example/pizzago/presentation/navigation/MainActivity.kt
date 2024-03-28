package com.example.pizzago.presentation.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.pizzago.R
import com.example.pizzago.databinding.ActivityMainBinding
import com.example.pizzago.presentation.basket.BasketFragment
import com.example.pizzago.presentation.basket.BasketFragment.Companion.FRAGMENT_BASKET_TAG
import com.example.pizzago.presentation.menu.MenuFragment
import com.example.pizzago.presentation.menu.MenuFragment.Companion.FRAGMENT_MENU_TAG
import com.example.pizzago.presentation.profile.ProfileFragment
import com.example.pizzago.presentation.profile.ProfileFragment.Companion.FRAGMENT_PROFILE_TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), FragmentNavigationListener {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		if (supportFragmentManager.backStackEntryCount == 0) {
			navigateToMenuFragment()
		}

		binding.navView.setOnItemSelectedListener {
			when (it.itemId) {
				R.id.navigation_home    -> {
					navigateToMenuFragment()
					true
				}

				R.id.navigation_profile -> {
					navigateToProfileFragment()
					true
				}

				R.id.navigation_basket  -> {
					navigateToBasketFragment()
					true
				}

				else                    -> {
					false
				}
			}
		}
	}

	override fun navigateToMenuFragment() {
		if (supportFragmentManager.findFragmentByTag(FRAGMENT_MENU_TAG) == null) {
			supportFragmentManager.commit {
				replace(R.id.fragmentContainer, MenuFragment.newInstance(), FRAGMENT_MENU_TAG)
				addToBackStack(FRAGMENT_MENU_TAG)
			}
		} else {
			supportFragmentManager.popBackStack(FRAGMENT_MENU_TAG, 0)
		}
	}

	override fun navigateToProfileFragment() {
		if (supportFragmentManager.findFragmentByTag(FRAGMENT_PROFILE_TAG) == null) {
			supportFragmentManager.commit {
				replace(R.id.fragmentContainer, ProfileFragment.newInstance(), FRAGMENT_PROFILE_TAG)
				addToBackStack(FRAGMENT_PROFILE_TAG)
			}
		} else {
			supportFragmentManager.popBackStack(FRAGMENT_PROFILE_TAG, 0)
		}
	}

	override fun navigateToBasketFragment() {
		if (supportFragmentManager.findFragmentByTag(FRAGMENT_BASKET_TAG) == null) {
			supportFragmentManager.commit {
				replace(R.id.fragmentContainer, BasketFragment.newInstance(), FRAGMENT_BASKET_TAG)
				addToBackStack(FRAGMENT_BASKET_TAG)
			}
		} else {
			supportFragmentManager.popBackStack(FRAGMENT_BASKET_TAG, 0)
		}
	}
}