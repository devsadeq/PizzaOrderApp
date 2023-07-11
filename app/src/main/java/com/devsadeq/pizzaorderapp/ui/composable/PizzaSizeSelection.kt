package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.devsadeq.pizzaorderapp.R
import com.devsadeq.pizzaorderapp.viewmodel.PizzaSize

@Composable
fun PizzaSizeSelection(
    selectedSize: PizzaSize,
    onClick: (PizzaSize) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.padding(24.dp),
    ) {
        RoundedButton(
            label = stringResource(R.string.s),
            onClick = { onClick(PizzaSize.SMALL) },
            selected = selectedSize == PizzaSize.SMALL
        )
        RoundedButton(
            label = stringResource(R.string.m),
            onClick = { onClick(PizzaSize.MEDIUM) },
            selected = selectedSize == PizzaSize.MEDIUM
        )
        RoundedButton(
            label = stringResource(R.string.l),
            onClick = { onClick(PizzaSize.LARGE) },
            selected = selectedSize == PizzaSize.LARGE
        )
    }
}