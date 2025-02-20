package com.example.furniturestore.furniture.presentation.furniture_detail

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.furniturestore.furniture.domain.model.Furniture
import com.example.furniturestore.furniture.presentation.furniture_detail.components.BuyButton
import com.example.furniturestore.furniture.presentation.furniture_detail.components.FurnitureCounter
import com.example.furniturestore.furniture.presentation.furniture_list.components.furniture
import com.example.furniturestore.ui.theme.FurnitureTheme
import com.example.furniturestore.ui.theme.darkGreen

@Composable
fun FurnitureDetailScreen(
    modifier: Modifier = Modifier,
    furniture: Furniture,
    onBackClick:()->Unit
) {
    var counterState by remember { mutableIntStateOf(1)}
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
        IconButton(
            modifier = Modifier.padding(start = 20.dp, top = 65.dp),
            onClick = {
            onBackClick()
        }){
            Icon(
                modifier = Modifier.height(60.dp).width(60.dp),
                tint = Color.White,
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .clip(RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp
                )).background(MaterialTheme.colorScheme.background)
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
                    color = MaterialTheme.colorScheme.primary,
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
                        color = MaterialTheme.colorScheme.primary,
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
                color = MaterialTheme.colorScheme.primary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 7,
                fontSize = 18.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                FurnitureCounter(
                    modifier = Modifier.weight(1f),
                    onMinusClick = { if(counterState > 0) --counterState },
                    onPlusClick = {++counterState},
                    value = counterState
                )
                BuyButton(
                    modifier = Modifier.padding(5.dp).weight(1f)
                )
            }
        }
    }
}
@PreviewLightDark
@Composable
fun FurnitureDetailScreenPreview() {
    FurnitureTheme {
        FurnitureDetailScreen(
            furniture = furniture
        ){}
    }
}