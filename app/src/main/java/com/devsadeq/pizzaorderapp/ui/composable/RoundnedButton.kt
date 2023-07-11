package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

@Composable
fun RoundedButton(
    label: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,

        ) {
        Row {
        }
    }

}