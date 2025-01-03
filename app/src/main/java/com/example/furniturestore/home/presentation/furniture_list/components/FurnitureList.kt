package com.example.furniturestore.home.presentation.furniture_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.furniturestore.home.domain.model.Furniture


@Composable
fun FurnitureList(
    furnitureItems: List<Furniture>,
    onBookClick: (Furniture) -> Unit,
    modifier: Modifier = Modifier,
    scrollState: LazyStaggeredGridState = rememberLazyStaggeredGridState()
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),  // 2 столбца
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        state = scrollState
    ){
        items(furnitureItems.size) {id ->
            FurnitureListItem(
                furnitureUi = furnitureItems[id],
                onClick = {onBookClick(furnitureItems[id])},
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .background(
                        MaterialTheme.colorScheme.background
                    )
            )
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun FurnitureListPreview(modifier: Modifier = Modifier) {
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
    FurnitureList(
        modifier = Modifier.background(
            MaterialTheme.colorScheme.background
        ),
        furnitureItems = arr.toList(),
        onBookClick = {}
    )
}