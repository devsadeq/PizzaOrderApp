package com.devsadeq.pizzaorderapp.ui.viewmodel

data class OrderScreenUiState(
    val ingredients: List<Ingredient> = emptyList(),
) {
    data class Ingredient(
        val id: Int,
        val name: String,
        val price: Double,
        val imageUrl: String,
        val quantity: Int = 0,
    )
}
