package com.example.furniturestore.furniture.presentation.furniture_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.furniturestore.furniture.domain.model.Furniture
import com.example.furniturestore.furniture.presentation.furniture_list.components.CustomButton
import com.example.furniturestore.furniture.presentation.furniture_list.components.FurnitureListItem
import com.example.furniturestore.furniture.presentation.furniture_list.components.furniture
import com.example.furniturestore.ui.theme.FurnitureTheme

@Composable
fun FurnitureScreen(
    state:FurnitureListState,
    modifier: Modifier = Modifier,
    onItemClick: (Furniture) -> Unit,
    onContinueClick:()->Unit
) {
    if(state.isLoading){
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }else{
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),  // 2 columns
            modifier = modifier,
            contentPadding = PaddingValues(8.dp),
            state = rememberLazyStaggeredGridState()
        ){
            item {
                Column(
                    modifier = Modifier.padding(vertical = 15.dp, horizontal = 5.dp)
                ){
                    Text(
                        modifier = Modifier.padding(bottom = 5.dp),
                        text = "Furniture items",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "All products are made from the best natural materials.",
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.primary,
                        fontStyle = FontStyle.Italic,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 4,
                        fontSize = 16.sp
                    )
                }
            }
            items(state.furnitureItems) {item ->
                FurnitureListItem(
                    furnitureUi = item,
                    onClick = {onItemClick(item)},
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .background(
                            MaterialTheme.colorScheme.background
                        )
                )
            }
            item {
                CustomButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Continue"
                ){
                    onContinueClick()
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
fun FurnitureListPreview(modifier: Modifier = Modifier) {
    FurnitureTheme {
        val arr = mutableListOf<Furniture>()
        repeat(15){
            arr.add(
                Furniture(
                    id = "4288749d-ae80-4849-be0e-c0f64b4be9f2",
                    name = "Luxe Walnut Desk $it",
                    category = "desk",
                    description = "A modern desk that combines both functionality and style, perfect for any workspace. Made from high-quality walnut wood, it features a smooth finish, ample surface area for productivity, and sleek design that fits in any environment.",
                    price =  "399.99",
                    discountPrice = "391",
                    imagePath = "https://wvxxlssoccbctxspmtyy.supabase.co/storage/v1/object/public/products/public/1f22ecea-07cc-4c59-9e4f-f85f35b808ea.jpeg",
                    createDate = "2024-11-10T13:56:55.975614+00:00"
                )
            )
        }
        FurnitureScreen(
            modifier = Modifier.background(
                MaterialTheme.colorScheme.background
            ),
            state = FurnitureListState(
                furnitureItems = arr
            ),
            onItemClick = {furniture},
            onContinueClick = {}
        )
    }
}