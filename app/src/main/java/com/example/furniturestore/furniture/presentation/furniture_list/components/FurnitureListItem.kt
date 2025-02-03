package com.example.furniturestore.furniture.presentation.furniture_list.components
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.furniturestore.furniture.domain.model.Furniture
import com.example.furniturestore.ui.theme.FurnitureTheme
import com.example.furniturestore.ui.theme.darkGreen
import com.example.gemstore.R


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FurnitureListItem(
    furnitureUi: Furniture,
    onClick: (Furniture) -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 10.dp)
            .clickable { onClick(furnitureUi) }
            .height(330.dp)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth().height(230.dp).clip(RoundedCornerShape(10.dp)),
            model = ImageRequest.Builder(LocalContext.current)
                .data(furnitureUi.imagePath)
                .crossfade(true)
                .build(),
            contentDescription = furnitureUi.name,
            contentScale = ContentScale.Crop
        )
        Spacer(
            modifier = Modifier.size(10.dp)
        )
        Text(
            text = furnitureUi.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(
            modifier = Modifier.size(10.dp)
        )
        Text(
            text = "$ ${furnitureUi.price}",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = darkGreen
        )

    }
}

@PreviewLightDark
@Preview(showSystemUi = true)
@Composable
fun FurnitureItemPreview(modifier: Modifier = Modifier) {
    FurnitureTheme {
        Row{
            FurnitureListItem(
                furnitureUi = furniture,
                onClick = {},
                modifier = Modifier.weight(1f).background(
                    MaterialTheme.colorScheme.background
                )
            )
            FurnitureListItem(
                furnitureUi = furniture,
                onClick = {},
                modifier = Modifier.weight(1f).background(
                    MaterialTheme.colorScheme.background
                )
            )
        }

    }
}
internal val furniture = Furniture(
    id = "4288749d-ae80-4849-be0e-c0f64b4be9f2",
    name = "Luxe Walnut Desk",
    category = "desk",
    description = "A modern desk that combines both functionality and style, perfect for any workspace. Made from high-quality walnut wood, it features a smooth finish, ample surface area for productivity, and sleek design that fits in any environment.",
    price =  "399.99",
    discountPrice = "391",
    imagePath = "https://wvxxlssoccbctxspmtyy.supabase.co/storage/v1/object/public/products/public/1f22ecea-07cc-4c59-9e4f-f85f35b808ea.jpeg",
    createDate = "2024-11-10T13:56:55.975614+00:00"
)