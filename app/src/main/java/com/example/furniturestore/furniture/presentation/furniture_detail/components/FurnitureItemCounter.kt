package com.example.furniturestore.furniture.presentation.furniture_detail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gemstore.R


@Composable
fun FurnitureCounter(
    modifier: Modifier = Modifier,
    value: Int,
    onPlusClick:(Int) -> Unit,
    onMinusClick:(Int) -> Unit
) {
    val contentColor = if(isSystemInDarkTheme()){
        Color.White
    }else{
        Color.Black
    }
    Box(
        modifier = modifier.clip(
            RoundedCornerShape(20.dp)
        )
    ){
        Row(
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min).border(2.dp, contentColor, RoundedCornerShape(10.dp))
        ){
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Plus"
            )
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