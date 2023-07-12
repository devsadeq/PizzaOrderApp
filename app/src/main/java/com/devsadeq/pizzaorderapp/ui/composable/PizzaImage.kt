package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun PizzaImage(
    imageRes: Int,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(imageRes),
        contentDescription = null,
        modifier = modifier
    )
}