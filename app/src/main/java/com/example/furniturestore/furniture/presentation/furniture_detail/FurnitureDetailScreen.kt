package com.example.furniturestore.furniture.presentation.furniture_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.furniturestore.furniture.domain.model.Furniture
import com.example.furniturestore.furniture.presentation.furniture_list.components.furniture

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
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ){
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp)),
            model = furniture.imagePath,
            contentDescription = furniture.name,
            contentScale = ContentScale.Crop
        )
        Card(
            modifier = Modifier.fillMaxHeight(0.5f).fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
        ){
            Row(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.35f)
                    .padding(
                        horizontal = 20.dp,
                        vertical = 50.dp
                    )
            ){
                Text(
                    modifier = Modifier.fillMaxHeight().weight(3f),
                    text = furniture.name,
                    fontWeight = FontWeight.Light,
                    fontSize = 29.sp
                )
                Spacer(modifier = Modifier.width(50.dp))
               Column(
                    modifier = Modifier.fillMaxHeight().weight(1f),
                    verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.End
               ){
                   Text(
                       modifier = Modifier.fillMaxHeight(0.5f).fillMaxWidth(),
                       text = furniture.price,
                       fontWeight = FontWeight.Light,
                       fontSize = 15.sp,
                       textDecoration = TextDecoration.LineThrough
                   )
                   Text(
                       modifier = Modifier.fillMaxHeight(0.5f).fillMaxWidth(),
                       text = furniture.discountPrice,
                       fontWeight = FontWeight.Light,
                       fontSize = 20.sp
                   )
               }
            }
        }
    }
}
@Preview
@Composable
fun FurnitureDetailScreenPreview() {
    FurnitureDetailScreen(
        furniture = furniture
    )
}