package com.example.furniturestore.home.domain.model

data class Furniture(
    val id:String,
    val name:String,
    val category:String,
    val description:String,
    val price:String,
    val imagePath:String,
    val discountPrice:String,
    val createDate:String
)
