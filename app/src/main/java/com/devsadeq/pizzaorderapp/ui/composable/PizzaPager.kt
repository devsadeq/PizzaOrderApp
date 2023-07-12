package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devsadeq.pizzaorderapp.DataSource
import com.devsadeq.pizzaorderapp.DataSource.pizzaList
import com.devsadeq.pizzaorderapp.R
import com.devsadeq.pizzaorderapp.viewmodel.OrderScreenUiState
import com.devsadeq.pizzaorderapp.viewmodel.PizzaSize

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaPager(
    pagerState: PagerState,
    pizzaList: List<OrderScreenUiState.Pizza>,
    pizzaSize: PizzaSize,
    modifier: Modifier = Modifier,
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
        }, label = "Pizza Scale"
    )

    Box(
        modifier = modifier
            .height(300.dp)
            .padding(vertical = 24.dp)
    ) {
        PizzaImage(R.drawable.plate, modifier = Modifier.align(Alignment.Center))
        HorizontalPager(
            pageCount = pizzaList.size,
            state = pagerState,
            verticalAlignment = Alignment.CenterVertically,
        ) { page ->
            Box(modifier = Modifier.scale(scale.value)) {
                PizzaImage(
                    imageRes = pizzaList[page].breadRes,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(250.dp)
                )
                pizzaList[0].ingredients.forEach {
                    if (it.id == 1) PizzaIngredients(
                        images = basilImages,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .rotate(90f)
                    )
                }
            }
        }
    }
}

@Composable
fun IngredientImage(imageRes: Int, modifier: Modifier = Modifier) {
    Image(
        painterResource(imageRes), contentDescription = null,
        modifier = modifier.size(40.dp)
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PizzaIngredients(
    images: List<Int>,
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier,
        maxItemsInEachRow = 3,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        images.forEach {
            IngredientImage(it)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun PizzaPagerPreview() {
    PizzaPager(
        pagerState = rememberPagerState(),
        pizzaList,
        pizzaSize = PizzaSize.SMALL,
        basilImages = DataSource.basilImages,
        broccoliImages = DataSource.broccoliImages,
        mushroomImages = DataSource.mushroomImages,
        onionImages = DataSource.onionImages,
        sausageImages = DataSource.sausageImages,
        selectedPizza = 0
    )
}