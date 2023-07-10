package com.devsadeq.pizzaorderapp.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OrderScreen() {
    OrderScreenContent()
}

@Composable
private fun OrderScreenContent() {
    Text(text = "Order Screen")
}

@Preview
@Composable
private fun OrderScreenPreview() {
    OrderScreen()
}
