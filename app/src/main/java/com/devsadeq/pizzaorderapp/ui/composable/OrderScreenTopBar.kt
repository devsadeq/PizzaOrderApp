package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.devsadeq.pizzaorderapp.R

@Composable
fun OrderScreenTopBar(isFavorite: Boolean, onFavoriteClicked: () -> Unit) {
    TopBar(
        title = stringResource(R.string.order_screen_title),
        navigationIcon = Icons.Filled.ArrowBack,
        actions = { OrderScreenTopBarActions(isFavorite, onFavoriteClicked) },
    )
}

@Composable
private fun OrderScreenTopBarActions(isFavorite: Boolean, onFavoriteClicked: () -> Unit) {
    IconButton(onClick = onFavoriteClicked) {
        Icon(
            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
            contentDescription = stringResource(R.string.favorite),
        )
    }
}