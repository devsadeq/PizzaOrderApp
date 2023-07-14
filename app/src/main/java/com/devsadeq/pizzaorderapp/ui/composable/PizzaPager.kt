package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.devsadeq.pizzaorderapp.viewmodel.OrderScreenUiState
import com.devsadeq.pizzaorderapp.viewmodel.PizzaSize

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaPager(
    pagerState: androidx.compose.foundation.pager.PagerState,
    pizzaList: List<OrderScreenUiState.Pizza>,
    pizzaSize: PizzaSize,
) {
    val scale = animateFloatAsState(
        targetValue = when (pizzaSize) {
            PizzaSize.SMALL -> 0.9f
            PizzaSize.MEDIUM -> 1.0f
            PizzaSize.LARGE -> 1.1f
        }, label = "pizzaScale"
    )

    HorizontalPager(
        pageCount = pizzaList.size,
        state = pagerState,
        verticalAlignment = Alignment.CenterVertically,
    ) { page ->
        Box(
            modifier = Modifier
                .size(250.dp)
                .scale(scale.value),
        ) {
            PizzaImage(
                imageRes = pizzaList[page].breadRes,
                modifier = Modifier.align(Alignment.Center)
            )
            pizzaList[page].ingredients.forEach { ingredient ->
                if (ingredient.selected) PizzaToppings(
                    images = ingredient.images,
                    id = ingredient.id,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center),
                )
            }
        }
    }
}
