package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devsadeq.pizzaorderapp.viewmodel.OrderScreenUiState
import com.devsadeq.pizzaorderapp.viewmodel.PizzaSize

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaPager(
    pagerState: androidx.compose.foundation.pager.PagerState,
    pizzaList: List<OrderScreenUiState.Pizza>,
    pizzaSize: PizzaSize,
    modifier: Modifier = Modifier,
) {
    val scale = animateFloatAsState(
        targetValue = when (pizzaSize) {
            PizzaSize.SMALL -> 0.7f
            PizzaSize.MEDIUM -> 0.8f
            PizzaSize.LARGE -> 0.9f
        }, label = "pizzaScale"
    )

    HorizontalPager(
        pageCount = pizzaList.size,
        state = pagerState,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) { page ->
        Box(
            modifier = Modifier
                .size(300.dp)
                .scale(scale.value),
        ) {
            Image(
                painter = painterResource(pizzaList[page].breadRes),
                contentDescription = null,
                modifier = Modifier.align(Alignment.Center)
            )
            pizzaList[page].ingredients
                .filter { it.selected }
                .forEach { ingredient ->
                    when (ingredient.id) {
                        1 -> PizzaToppings(images = ingredient.images)
                        2 -> PizzaToppings(images = ingredient.images)
                        3 -> PizzaToppings(images = ingredient.images)
                        4 -> PizzaToppings(images = ingredient.images)
                        5 -> PizzaToppings(images = ingredient.images)
                    }
                }
        }
    }
}