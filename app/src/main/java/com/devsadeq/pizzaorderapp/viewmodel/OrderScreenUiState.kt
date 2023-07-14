package com.devsadeq.pizzaorderapp.viewmodel

import com.devsadeq.pizzaorderapp.DataSource

data class OrderScreenUiState(
    val pizzaList: List<Pizza> = emptyList(),
    val selectedSize: PizzaSize = PizzaSize.MEDIUM,
    val totalPrice: Double = 10.0,
    val isFavorite: Boolean = false,
    val selectedPizza: Pizza = DataSource.pizzaList.first(),
) {
    data class Ingredient(
        val id: Int,
        val name: String,
        val price: Double,
        val imageRes: Int,
        val images: List<Int> = emptyList(),
        val selected: Boolean = false,
    )

    data class Pizza(
        val id: Int,
        val name: String,
        val price: Double,
        val breadRes: Int,
        val ingredients: List<Ingredient> = emptyList(),
    )
}

enum class PizzaSize(val price: Double) {
    SMALL(10.0),
    MEDIUM(15.0),
    LARGE(20.0),
}