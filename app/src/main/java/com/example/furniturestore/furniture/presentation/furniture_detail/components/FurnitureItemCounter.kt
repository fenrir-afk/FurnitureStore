package com.example.furniturestore.furniture.presentation.furniture_detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun FurnitureCounter(
    modifier: Modifier = Modifier,
    value: Int,
    onPlusClick:(Int) -> Unit,
    onMinusClick:(Int) -> Unit
) {
    Box(
        modifier = modifier.clip(
            RoundedCornerShape(20.dp)
        )
    ){
        Row(
            modifier = Modifier.fillMaxSize()
        ){


        }
    }

}
@Preview
@Composable
fun FurnitureCounterPreview(modifier: Modifier = Modifier) {
    var counter by remember { mutableIntStateOf(1) }
    FurnitureCounter(
        modifier = Modifier
            .fillMaxSize(),
        value = counter,
        onPlusClick = {
            counter++
        },
        onMinusClick = {
            counter--
        }
    )
}