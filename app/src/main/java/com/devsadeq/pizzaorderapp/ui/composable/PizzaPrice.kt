package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PizzaPrice(price: Double) {
    Text(
        text = "$$price",
        style = MaterialTheme.typography.headlineMedium,
    )
}

@Preview(showBackground = true)
@Composable
private fun PizzaPricePreview() {
    PizzaPrice(price = 17.0)
}