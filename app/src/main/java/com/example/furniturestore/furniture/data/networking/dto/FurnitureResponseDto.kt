package com.example.furniturestore.furniture.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class FurnitureResponseDto(
    val data:List<FurnitureDto>
)
