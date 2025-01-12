package com.example.furniturestore.furniture.presentation.furniture_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.furniturestore.furniture.domain.model.Furniture
import com.example.furniturestore.furniture.presentation.furniture_list.components.FurnitureListItem
import com.example.furniturestore.ui.theme.FurnitureTheme

@Composable
fun FurnitureScreen(
    state:FurnitureListState,
    modifier: Modifier = Modifier
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
            items(state.furnitureItems) {item ->
                FurnitureListItem(
                    furnitureUi = item,
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .background(
                            MaterialTheme.colorScheme.background
                        )
                )
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
        )
    }
}