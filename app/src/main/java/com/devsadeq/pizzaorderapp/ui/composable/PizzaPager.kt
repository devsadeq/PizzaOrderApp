package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devsadeq.pizzaorderapp.R
import com.devsadeq.pizzaorderapp.pizzaList
import com.devsadeq.pizzaorderapp.viewmodel.OrderScreenUiState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaPager(
    pizzaList: List<OrderScreenUiState.Pizza>,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.padding(vertical = 24.dp)) {
        PizzaImage(R.drawable.plate, modifier = Modifier.align(Alignment.Center))
        HorizontalPager(
            pageCount = pizzaList.size,
            contentPadding = PaddingValues(24.dp)
        ) {
            PizzaImage(
                imageRes = pizzaList[it].breadRes,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(260.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PizzaPagerPreview() {
    PizzaPager(pizzaList = pizzaList)
}