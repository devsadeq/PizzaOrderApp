package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.random.Random


@Composable
fun PizzaToppings(
    images: List<Int>,
    modifier: Modifier = Modifier,
    id: Int,
) {
    Box(modifier = modifier.fillMaxSize()) {
        images.forEach { image ->
            val randomOffsetX = remember { mutableStateOf(Random.nextInt(20, 200)) }
            val randomOffsetY = remember { mutableStateOf(Random.nextInt(20, 200)) }

            ToppingItem(
                imageRes = image,
                modifier = Modifier.offset(randomOffsetX.value.dp, randomOffsetY.value.dp),
            )
        }
    }
}