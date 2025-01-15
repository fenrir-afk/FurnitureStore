package com.example.furniturestore.furniture.presentation.furniture_detail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.ImageLoader
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
    Row(
        modifier = modifier.height(IntrinsicSize.Min).border(1.dp, contentColor, RoundedCornerShape(10.dp))
    ){
        Icon(
            modifier = Modifier.padding(5.dp).weight(1f),
            painter = painterResource(R.drawable.ic_minus),
            contentDescription = "Plus"
        )
        VerticalDivider(modifier = Modifier.fillMaxHeight(), thickness = 1.dp, color = contentColor)
        Text(
            modifier = Modifier.fillMaxHeight().padding(5.dp).weight(1f),
            text = value.toString(),
            color = contentColor,
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
        VerticalDivider(modifier = Modifier.fillMaxHeight(), thickness = 1.dp, color =contentColor)
        Icon(
            modifier = Modifier.padding(5.dp).weight(1f),
            imageVector = Icons.Default.Add,
            contentDescription = "Plus"
        )
    }

}
@Preview(showBackground = true)
@Composable
fun FurnitureCounterPreview(modifier: Modifier = Modifier) {
    var counter by remember { mutableIntStateOf(1) }
    FurnitureCounter(
        modifier = Modifier
            .fillMaxWidth(),
        value = counter,
        onPlusClick = {
            counter++
        },
        onMinusClick = {
            counter--
        }
    )
}