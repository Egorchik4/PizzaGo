package com.example.pizzago.presentation.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzago.domain.entity.CategoriesEntity
import com.example.pizzago.domain.entity.MealEntity
import com.example.pizzago.domain.entity.SuggestionPictureEntity
import com.example.pizzago.domain.usecase.GetCategoriesUseCase
import com.example.pizzago.domain.usecase.GetMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
	private val getMealsUseCase: GetMealsUseCase,
	private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

	private val _suggestionMut = MutableLiveData<List<SuggestionPictureEntity>>()
	val suggestionLive: LiveData<List<SuggestionPictureEntity>> = _suggestionMut

	private val _categoriesMut = MutableLiveData<List<CategoriesEntity>>()
	val categoriesLive: LiveData<List<CategoriesEntity>> = _categoriesMut

	private val _pizzasMut = MutableLiveData<List<MealEntity>>()
	val pizzasLive: LiveData<List<MealEntity>> = _pizzasMut

	private val _loadingMut = MutableLiveData<Boolean>()
	val loadingLive: LiveData<Boolean> = _loadingMut

	private val _errorMut = MutableLiveData<String>()
	val errorLive: LiveData<String> = _errorMut

	fun loadPizzas() {
		_loadingMut.value = true
		viewModelScope.launch {
			try {
				_pizzasMut.value = getMealsUseCase()
				_categoriesMut.value = getCategoriesUseCase()
			} catch (e: Exception) {
				_errorMut.value = e.toString()
			} finally {
				_loadingMut.value = false
			}
		}
	}

	fun filterMeal(entity: CategoriesEntity) {
		val categoriesMeal = _categoriesMut.value as List<CategoriesEntity>
		viewModelScope.launch {
			val indexOfActual = categoriesMeal.indexOfFirst { it.id == entity.id }
			val newListCategories = ArrayList(categoriesMeal)
			newListCategories[indexOfActual] = entity.copy(isChecked = !entity.isChecked)
			_categoriesMut.postValue(newListCategories)

			val listCategories = newListCategories.filter { it.isChecked }.toListCategories()
			val list = getMealsUseCase()
			if (listCategories.isEmpty()) {
				_pizzasMut.postValue(list)
			} else {
				val newListMeal = ArrayList(list)
				val newList = newListMeal.filter { it.strCategory in listCategories }
				_pizzasMut.postValue(newList)
			}
		}
	}

	private fun List<CategoriesEntity>.toListCategories(): List<String> {
		val list: MutableList<String> = mutableListOf()
		this.forEach {
			list.add(it.strCategory)
		}
		return list
	}

	init {
		_suggestionMut.value = listOf(
			SuggestionPictureEntity(
				"https://mykaleidoscope.ru/x/uploads/posts/2023-12/1703248385_mykaleidoscope-ru-p-portsionnaya-pitstsa-oboi-1.jpg"
			),
			SuggestionPictureEntity(
				"https://mykaleidoscope.ru/x/uploads/posts/2022-09/1663807760_10-mykaleidoscope-ru-p-pitstsa-i-sushi-na-stole-yeda-oboi-10.png"
			)
		)
	}
}