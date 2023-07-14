package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devsadeq.pizzaorderapp.R
import com.devsadeq.pizzaorderapp.viewmodel.OrderScreenUiState
import com.devsadeq.pizzaorderapp.viewmodel.PizzaSize

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pizza(
    pagerState: PagerState,
    pizzaList: List<OrderScreenUiState.Pizza>,
    pizzaSize: PizzaSize,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .height(300.dp)
            .padding(vertical = 24.dp)
    ) {
        PizzaImage(R.drawable.plate, modifier = Modifier.align(Alignment.Center))
        PizzaPager(
            pagerState = pagerState,
            pizzaList = pizzaList,
            pizzaSize = pizzaSize,
        )
    }
}