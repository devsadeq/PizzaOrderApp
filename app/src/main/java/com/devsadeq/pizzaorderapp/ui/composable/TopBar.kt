package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.devsadeq.pizzaorderapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    navigationIcon: ImageVector,
    actions: @Composable RowScope.() -> Unit,
    onNavigationIconClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = { TopBarTitle(title) },
        navigationIcon = { TopBarNavigationIcon(navigationIcon, onNavigationIconClick) },
        actions = actions,
    )
}

@Composable
private fun TopBarTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall,
        color = Color.Black,
    )
}

@Composable
private fun TopBarNavigationIcon(
    icon: ImageVector,
    onNavigationIconClick: () -> Unit
) {
    IconButton(onClick = onNavigationIconClick) {
        Icon(
            imageVector = icon,
            contentDescription = stringResource(R.string.back),
        )
    }
}

@Preview
@Composable
private fun TopBarPreview() {
    TopBar(
        title = "Pizza",
        navigationIcon = Icons.Filled.ArrowBack,
        actions = {},
    )
}