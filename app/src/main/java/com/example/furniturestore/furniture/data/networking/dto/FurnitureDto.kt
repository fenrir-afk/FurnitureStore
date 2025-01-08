package com.example.furniturestore.furniture.data.networking.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FurnitureDto(
    @SerialName("id") val id:String,
    @SerialName("name") val name:String,
    @SerialName("category") val category:String,
    @SerialName("description") val description:String,
    @SerialName("price") val price:Double,
    @SerialName("image_path") val imagePath:String,
    @SerialName("discount_price") val discountPrice:Double,
    @SerialName("created_at") val createDate:String
)
