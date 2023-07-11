package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devsadeq.pizzaorderapp.viewmodel.PizzaSize

@Composable
fun PizzaImage(
    imageRes: Int,
    modifier: Modifier = Modifier,
    pizzaSize: PizzaSize = PizzaSize.MEDIUM,
) {
    val scale = animateFloatAsState(
        targetValue = when (pizzaSize) {
            PizzaSize.SMALL -> 0.9f
            PizzaSize.MEDIUM -> 1.0f
            PizzaSize.LARGE -> 1.1f
        }, label = "Pizza Scale"
    )
    Image(
        painter = painterResource(imageRes),
        contentDescription = null,
        modifier = modifier
            .size(300.dp)
            .scale(scale.value)
    )
}