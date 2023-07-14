package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun ToppingItem(
    imageRes: Int,
    modifier: Modifier = Modifier,
) {
    Image(
        painterResource(imageRes), contentDescription = null,
        modifier = modifier.size(25.dp)
    )
}