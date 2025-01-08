package com.example.furniturestore.furniture.domain.dataSource

import com.example.furniturestore.furniture.domain.model.Furniture
import com.example.furniturestore.core.domain.util.NetworkError
import com.example.furniturestore.core.domain.util.Result

interface FurnitureDataSource {
    suspend fun getFurnitureItems():Result<List<Furniture>,NetworkError>
}