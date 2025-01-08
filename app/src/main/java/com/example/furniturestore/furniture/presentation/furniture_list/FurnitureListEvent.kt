package com.example.furniturestore.furniture.presentation.furniture_list

import com.example.furniturestore.core.domain.util.NetworkError

sealed interface FurnitureListEvent {
    data class Error(val error:NetworkError):FurnitureListEvent
}