package com.example.furniturestore.furniture.presentation.furniture_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.furniturestore.furniture.domain.model.Furniture
import com.example.furniturestore.furniture.presentation.furniture_list.components.furniture
import com.example.furniturestore.ui.theme.FurnitureTheme
import com.example.furniturestore.ui.theme.darkGreen

@Composable
fun FurnitureDetailScreen(
    modifier: Modifier = Modifier,
    furniture: Furniture
) {
    val contentColor = if(isSystemInDarkTheme()){
        Color.White
    }else{
        Color.Black
    }
    Box(
        modifier = modifier.fillMaxSize()
    ){
        AsyncImage(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.6f)
                .clip(RoundedCornerShape(10.dp)),
            model = furniture.imagePath,
            contentDescription = furniture.name,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .clip(RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp
                )).background(if(isSystemInDarkTheme()){
                    Color.Black
                }else{
                    Color.White
                })
        ){
            Row(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(
                        horizontal = 20.dp,
                        vertical = 30.dp
                    ).height(IntrinsicSize.Min)
            ){
                Text(
                    modifier = Modifier.fillMaxHeight().weight(3f),
                    text = furniture.name,
                    color = contentColor,
                    fontWeight = FontWeight.Light,
                    fontSize = 29.sp
                )
                Spacer(modifier = Modifier.width(50.dp))
                Column(
                    modifier = Modifier.fillMaxHeight().weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "$" + furniture.price,
                        fontWeight = FontWeight.Light,
                        color = contentColor,
                        fontSize = 13.sp,
                        textDecoration = TextDecoration.LineThrough
                    )
                    Spacer(modifier = Modifier.padding(top = 5.dp))
                    Text(
                        text = "$" + furniture.discountPrice,
                        fontWeight = FontWeight.Light,
                        color = darkGreen,
                        fontSize = 19.sp
                    )
                }
            }
            Text(
                modifier = Modifier.padding(
                    start = 20.dp,
                    end =20.dp
                ),
                text = furniture.description,
                fontWeight = FontWeight.Thin,
                color = contentColor,
                fontSize = 18.sp
            )
        }
    }
}
@PreviewLightDark
@Composable
fun FurnitureDetailScreenPreview() {
    FurnitureTheme {
        FurnitureDetailScreen(
            furniture = furniture
        )
    }
}