package com.example.furniturestore.furniture.presentation.furniture_list

import com.example.furniturestore.furniture.domain.model.Furniture

sealed interface FurnitureListActions {
    data class OnItemClick(val item: Furniture):FurnitureListActions
}