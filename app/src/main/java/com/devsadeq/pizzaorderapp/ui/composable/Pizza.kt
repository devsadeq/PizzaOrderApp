package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.devsadeq.pizzaorderapp.R
import com.devsadeq.pizzaorderapp.viewmodel.OrderScreenUiState
import com.devsadeq.pizzaorderapp.viewmodel.OrderScreenViewModel
import com.devsadeq.pizzaorderapp.viewmodel.PizzaSize

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pizza(
    pagerState: PagerState,
    pizzaList: List<OrderScreenUiState.Pizza>,
    pizzaSize: PizzaSize,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.padding(vertical = 24.dp)) {
        PizzaImage(
            R.drawable.plate, modifier = Modifier
                .align(Alignment.Center)
                .size(300.dp)
        )
        PizzaPager(
            pagerState = pagerState,
            pizzaList = pizzaList,
            pizzaSize = pizzaSize,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PizzaPreview(viewModel: OrderScreenViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    Pizza(
        pagerState = rememberPagerState(),
        pizzaList = state.pizzaList,
        pizzaSize = PizzaSize.MEDIUM,
    )
}