package com.example.furniturestore.home.presentation.furniture_list.components

import android.graphics.pdf.models.ListItem
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.furniturestore.home.domain.model.Furniture

@Composable
fun ListItem(
    books: List<Furniture>,
    onBookClick: (Furniture) -> Unit,
    modifier: Modifier = Modifier,
    scrollState: LazyStaggeredGridState = rememberLazyStaggeredGridState()
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(3),  // 3 столбца
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalItemSpacing = 8.dp
    ){
        items(50) {_ ->
            Box(Modifier
                .fillMaxWidth()
                .height(Random.nextInt(50, 200).dp)
                .background(Color(
                    Random.nextInt(255),
                    Random.nextInt(255),
                    Random.nextInt(255),
                    255
                ))
            )
        }
    }
}
}