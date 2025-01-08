package com.example.furniturestore.furniture.data.mappers

import com.example.furniturestore.furniture.data.networking.dto.FurnitureDto
import com.example.furniturestore.furniture.domain.model.Furniture

fun FurnitureDto.toFurniture():Furniture{
    return Furniture(
        id = id,
        name = name,
        category = category,
        description = description,
        price = price.toString(),
        imagePath = imagePath,
        discountPrice = discountPrice.toString(),
        createDate = createDate
    )
}