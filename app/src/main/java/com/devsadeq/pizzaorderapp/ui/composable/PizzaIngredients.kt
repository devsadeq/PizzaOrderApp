package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devsadeq.pizzaorderapp.R
import com.devsadeq.pizzaorderapp.ingredientsList
import com.devsadeq.pizzaorderapp.viewmodel.OrderScreenUiState

@Composable
fun PizzaIngredients(
    ingredients: List<OrderScreenUiState.Ingredient>,
    onIngredientClicked: (OrderScreenUiState.Ingredient) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            stringResource(R.string.customize_your_pizza),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(ingredients.size) { index ->
                IngredientRoundedButton(
                    imageRes = ingredients[index].imageRes,
                    onClick = { onIngredientClicked(ingredients[index]) },
                    selected = ingredients[index].selected,
                )
            }
        }
    }
}

@Preview
@Composable
private fun PizzaIngredientsPreview() {
    PizzaIngredients(ingredients = ingredientsList, onIngredientClicked = {})
}