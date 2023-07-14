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
    }

    private fun getPizzaList() {
        _state.value = _state.value.copy(pizzaList = DataSource.pizzaList)
    }

    fun onFavoriteClicked() {
        _state.value = _state.value.copy(isFavorite = !_state.value.isFavorite)
    }

    fun onPizzaSizeClicked(size: PizzaSize) {
        _state.value = _state.value.copy(selectedSize = size)
    }

    fun onIngredientClicked(ingredient: OrderScreenUiState.Ingredient) {
        _state.update { state ->
            state.copy(
                pizzaList = state.pizzaList.map { pizza ->
                    if (pizza.id == state.selectedPizza.id) {
                        pizza.copy(
                            ingredients = pizza.ingredients.map { item ->
                                if (item.id == ingredient.id) item.copy(selected = !item.selected) else item
                            }
                        )
                    } else pizza
                }
            )
        }
    }

    fun setSelectedPizza(page: Int) {
        _state.value = _state.value.copy(selectedPizza = _state.value.pizzaList[page])
    }
}