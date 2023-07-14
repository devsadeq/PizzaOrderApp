package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devsadeq.pizzaorderapp.DataSource
import com.devsadeq.pizzaorderapp.viewmodel.OrderScreenUiState
import com.devsadeq.pizzaorderapp.viewmodel.PizzaSize

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaPager(
    pagerState: androidx.compose.foundation.pager.PagerState,
    pizzaList: List<OrderScreenUiState.Pizza>,
    pizzaSize: PizzaSize,
    basilImages: List<Int>,
    broccoliImages: List<Int>,
    mushroomImages: List<Int>,
    onionImages: List<Int>,
    sausageImages: List<Int>,
    selectedPizza: Int,
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
            pizzaList[selectedPizza].ingredients.forEach { ingredient ->
                when (ingredient.id) {
                    1 -> PizzaToppings(
                        images = basilImages,
                        id = 1,
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                    )

                    2 -> PizzaToppings(
                        images = broccoliImages,
                        id = 2,
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                    )

                    3 -> PizzaToppings(
                        images = mushroomImages,
                        id = 3,
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                    )

                    4 -> PizzaToppings(
                        images = onionImages,
                        id = 4,
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                    )

                    5 -> PizzaToppings(
                        images = sausageImages,
                        id = 5,
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun PizzaPagerPreview() {
    PizzaPager(
        pagerState = rememberPagerState(),
        pizzaList = DataSource.pizzaList,
        pizzaSize = PizzaSize.MEDIUM,
        basilImages = DataSource.basilImages,
        broccoliImages = emptyList(),
        mushroomImages = emptyList(),
        onionImages = emptyList(),
        sausageImages = emptyList(),
        selectedPizza = 0,
    )
}
