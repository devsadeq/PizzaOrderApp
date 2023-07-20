package com.devsadeq.pizzaorderapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devsadeq.pizzaorderapp.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderScreenViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(OrderScreenUiState())
    val state = _state.asStateFlow()

    init {
        getPizzaList()
    }

    private fun getPizzaList() {
        viewModelScope.launch {
            _state.update { it.copy(pizzaList = DataSource.pizzaList) }
        }
    }

    fun onFavoriteClicked() {
        _state.update { it.copy(isFavorite = !state.value.isFavorite) }
    }

    fun onPizzaSizeClicked(size: PizzaSize) {
        _state.update { it.copy(selectedSize = size) }
    }

    fun onIngredientClicked(ingredient: OrderScreenUiState.Ingredient) {
        _state.update { state ->
            val updatedPizzaList = state.pizzaList.map { pizza ->
                if (pizza.id == state.selectedPizza.id) {
                    pizza.copy(
                        ingredients = pizza.ingredients.map { item ->
                            if (item.id == ingredient.id) item.copy(selected = !item.selected) else item
                        }
                    )
                } else pizza
            }
            state.copy(
                pizzaList = updatedPizzaList,
                selectedPizza = updatedPizzaList.first { it.id == state.selectedPizza.id }
            )
        }
    }

    fun setSelectedPizza(page: Int) {
        _state.update { it.copy(selectedPizza = state.value.pizzaList[page]) }
    }
}