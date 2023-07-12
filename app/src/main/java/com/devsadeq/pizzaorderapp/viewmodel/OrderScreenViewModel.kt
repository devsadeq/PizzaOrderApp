package com.devsadeq.pizzaorderapp.viewmodel

import androidx.lifecycle.ViewModel
import com.devsadeq.pizzaorderapp.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class OrderScreenViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(OrderScreenUiState())
    val state = _state.asStateFlow()

    init {
        getPizzaList()
        getIngredientsList()
    }

    private fun getPizzaList() {
        _state.value = _state.value.copy(pizzaList = DataSource.pizzaList)
    }

    private fun getIngredientsList() {
        _state.value = _state.value.copy(ingredients = DataSource.ingredientsList)
    }

    fun onFavoriteClicked() {
        _state.value = _state.value.copy(isFavorite = !_state.value.isFavorite)
    }

    fun onPizzaSizeClicked(size: PizzaSize) {
        _state.value = _state.value.copy(selectedSize = size)
    }

    fun onIngredientClicked(ingredient: OrderScreenUiState.Ingredient) {
        _state.update { state ->
            val updatedIngredients = state.ingredients.map { item ->
                if (item.id == ingredient.id) item.copy(selected = !item.selected) else item
            }
            val selectedIngredients = updatedIngredients.filter { it.selected }
            updatePizzaIngredients(selectedIngredients)
            state.copy(ingredients = updatedIngredients, selectedIngredients = selectedIngredients)
        }
    }

    private fun updatePizzaIngredients(selectedIngredients: List<OrderScreenUiState.Ingredient>) {
        _state.update { state ->
            val updatedPizzaList = state.pizzaList.map { pizza ->
                if (pizza.id == state.selectedPizza) pizza.copy(ingredients = selectedIngredients) else pizza
            }
            state.copy(pizzaList = updatedPizzaList)
        }
    }

    fun setSelectedPizza(page: Int) {
        _state.value = _state.value.copy(selectedPizza = page)
    }
}