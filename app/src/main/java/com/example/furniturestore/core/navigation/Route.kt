package com.example.furniturestore.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object FurnitureGraph: Route

    @Serializable
    data object FurnitureList: Route

    @Serializable
    data object FurnitureDetail: Route
}