package com.devsadeq.pizzaorderapp.ui.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devsadeq.pizzaorderapp.viewmodel.PizzaSize

@Composable
fun PizzaSizeSelection(
    selectedSize: PizzaSize,
    onClick: (PizzaSize) -> Unit,
    modifier: Modifier = Modifier,
    pizzaSizes: List<PizzaSize> = PizzaSize.values().toList(),
) {
    val alignment by animateAlignmentAsState(
        targetAlignment = when (selectedSize) {
            PizzaSize.SMALL -> Alignment.CenterStart
            PizzaSize.MEDIUM -> Alignment.Center
            PizzaSize.LARGE -> Alignment.CenterEnd
        }
    )

    Box(modifier = Modifier.padding(vertical = 16.dp)) {
        Box(
            modifier = modifier
                .shadow(8.dp, CircleShape)
                .align(alignment)
                .size(50.dp)
                .background(Color.White, CircleShape)
        )
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .wrapContentWidth()
                .padding(horizontal = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(50.dp),
        ) {
            pizzaSizes.forEach { size ->
                Text(
                    text = size.name.first().toString(),
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black,
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }) {
                            onClick(size)
                        }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PizzaSizeSelectionPreview() {
    PizzaSizeSelection(
        PizzaSize.SMALL,
        {}
    )
}

@Composable
fun animateAlignmentAsState(
    targetAlignment: Alignment,
): State<Alignment> {
    val biased = targetAlignment as BiasAlignment
    val horizontal by animateFloatAsState(biased.horizontalBias, label = "")
    return remember {
        derivedStateOf {
            BiasAlignment(
                horizontalBias = horizontal,
                verticalBias = 0f
            )
        }
    }
}