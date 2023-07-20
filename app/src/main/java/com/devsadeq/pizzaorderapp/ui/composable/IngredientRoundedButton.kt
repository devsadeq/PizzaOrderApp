package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun IngredientRoundedButton(
    imageRes: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(70.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = if (selected) Color.Green.copy(0.1f) else Color.White),
        contentPadding = PaddingValues(0.dp),
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.clip(CircleShape).padding(12.dp)
        )
    }
}