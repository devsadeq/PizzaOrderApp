package com.devsadeq.pizzaorderapp

import com.devsadeq.pizzaorderapp.viewmodel.OrderScreenUiState

val pizzaList = listOf(
    OrderScreenUiState.Pizza(
        1,
        "Pizza 1",
        10.0,
        R.drawable.bread_1
    ),
    OrderScreenUiState.Pizza(
        2,
        "Pizza 2",
        10.0,
        R.drawable.bread_2,
    ),
    OrderScreenUiState.Pizza(
        3,
        "Pizza 3",
        10.0,
        R.drawable.bread_3,
    ),
    OrderScreenUiState.Pizza(
        4,
        "Pizza 4",
        10.0,
        R.drawable.bread_4,
    ),
    OrderScreenUiState.Pizza(
        5,
        "Pizza 5",
        10.0,
        R.drawable.bread_5,
    ),
)

val ingredientsList = listOf(
    OrderScreenUiState.Ingredient(
        1,
        "basil",
        1.0,
        R.drawable.basil_3,
        selected = true,
    ),
    OrderScreenUiState.Ingredient(
        2,
        "broccoli",
        1.0,
        R.drawable.broccoli_3
    ),
    OrderScreenUiState.Ingredient(
        3,
        "mushroom",
        1.0,
        R.drawable.mushroom_3
    ),
    OrderScreenUiState.Ingredient(
        4,
        "onion",
        0.5,
        R.drawable.onion_3
    ),
    OrderScreenUiState.Ingredient(
        5,
        "sausage",
        2.0,
        R.drawable.sausage_3
    ),
)