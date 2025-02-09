package com.example.furniturestore.furniture.presentation.furniture_list

import androidx.compose.runtime.Immutable
import com.example.furniturestore.furniture.domain.model.Furniture

@Immutable
data class FurnitureListState(
    val isLoading:Boolean = false,
    val furnitureItems:List<Furniture> = emptyList(),
    val selectedItem:Furniture? = null,
    val offset:Int = 0
)