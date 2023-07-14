package com.devsadeq.pizzaorderapp

import com.devsadeq.pizzaorderapp.viewmodel.OrderScreenUiState

object DataSource {
    private val basilImages = listOf(
        R.drawable.basil_1,
        R.drawable.basil_2,
        R.drawable.basil_3,
        R.drawable.basil_4,
        R.drawable.basil_5,
        R.drawable.basil_6,
        R.drawable.basil_7,
        R.drawable.basil_8,
        R.drawable.basil_9,
        R.drawable.basil_10,
    )

    private val broccoliImages = listOf(
        R.drawable.broccoli_1,
        R.drawable.broccoli_2,
        R.drawable.broccoli_3,
        R.drawable.broccoli_4,
        R.drawable.broccoli_5,
        R.drawable.broccoli_6,
        R.drawable.broccoli_7,
        R.drawable.broccoli_8,
        R.drawable.broccoli_9,
        R.drawable.broccoli_10,
    )

    private val mushroomImages = listOf(
        R.drawable.mushroom_1,
        R.drawable.mushroom_2,
        R.drawable.mushroom_3,
        R.drawable.mushroom_4,
        R.drawable.mushroom_5,
        R.drawable.mushroom_6,
        R.drawable.mushroom_7,
        R.drawable.mushroom_8,
        R.drawable.mushroom_9,
        R.drawable.mushroom_10,
    )

    private val onionImages = listOf(
        R.drawable.onion_1,
        R.drawable.onion_2,
        R.drawable.onion_3,
        R.drawable.onion_4,
        R.drawable.onion_5,
        R.drawable.onion_6,
        R.drawable.onion_7,
        R.drawable.onion_8,
        R.drawable.onion_9,
        R.drawable.onion_10,
    )

    private val sausageImages = listOf(
        R.drawable.sausage_1,
        R.drawable.sausage_2,
        R.drawable.sausage_3,
        R.drawable.sausage_4,
        R.drawable.sausage_5,
        R.drawable.sausage_6,
        R.drawable.sausage_7,
        R.drawable.sausage_8,
        R.drawable.sausage_9,
        R.drawable.sausage_10,
    )

    private val ingredientsList = listOf(
        OrderScreenUiState.Ingredient(
            1,
            "basil",
            1.0,
            R.drawable.basil_3,
            basilImages,
        ),
        OrderScreenUiState.Ingredient(
            2,
            "broccoli",
            1.0,
            R.drawable.broccoli_3,
            broccoliImages,
        ),
        OrderScreenUiState.Ingredient(
            3,
            "mushroom",
            1.0,
            R.drawable.mushroom_3,
            mushroomImages,
        ),
        OrderScreenUiState.Ingredient(
            4,
            "onion",
            0.5,
            R.drawable.onion_3,
            onionImages,
        ),
        OrderScreenUiState.Ingredient(
            5,
            "sausage",
            2.0,
            R.drawable.sausage_3,
            sausageImages,
        ),
    )

    val pizzaList = listOf(
        OrderScreenUiState.Pizza(
            1,
            "Pizza 1",
            10.0,
            R.drawable.bread_1,
            ingredientsList,
        ),
        OrderScreenUiState.Pizza(
            2,
            "Pizza 2",
            10.0,
            R.drawable.bread_2,
            ingredientsList,
        ),
        OrderScreenUiState.Pizza(
            3,
            "Pizza 3",
            10.0,
            R.drawable.bread_3,
            ingredientsList,
        ),
        OrderScreenUiState.Pizza(
            4,
            "Pizza 4",
            10.0,
            R.drawable.bread_4,
            ingredientsList,
        ),
        OrderScreenUiState.Pizza(
            5,
            "Pizza 5",
            10.0,
            R.drawable.bread_5,
            ingredientsList,
        ),
    )
}