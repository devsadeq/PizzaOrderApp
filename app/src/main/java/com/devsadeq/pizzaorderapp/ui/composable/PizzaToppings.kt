package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import kotlin.random.Random


@Composable
fun PizzaToppings(
    images: List<Int>,
    modifier: Modifier = Modifier,
) {
    val scale = remember { Animatable(3f) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .scale(scale.value)
    ) {
        images.forEach { image ->
            val randomOffsetX = remember { mutableStateOf(Random.nextInt(30, 230)) }
            val randomOffsetY = remember { mutableStateOf(Random.nextInt(30, 230)) }

            ToppingItem(
                imageRes = image,
                modifier = Modifier.offset(randomOffsetX.value.dp, randomOffsetY.value.dp),
            )
        }
    }

    LaunchedEffect(key1 = Unit) {
        scale.animateTo(targetValue = 1.0f)
    }
}