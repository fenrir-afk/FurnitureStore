package com.example.furniturestore.furniture.data.networking

import com.example.furniturestore.core.data.networking.constructUrl
import com.example.furniturestore.core.data.networking.safeCall
import com.example.furniturestore.core.domain.util.NetworkError
import com.example.furniturestore.core.domain.util.Result
import com.example.furniturestore.core.domain.util.map
import com.example.furniturestore.furniture.data.mappers.toFurniture
import com.example.furniturestore.furniture.data.networking.dto.FurnitureResponseDto
import com.example.furniturestore.furniture.domain.dataSource.FurnitureDataSource
import com.example.furniturestore.furniture.domain.model.Furniture
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteFurnitureDataSource(
    private val httpClient: HttpClient
):FurnitureDataSource {
    override suspend fun getFurnitureItems(): Result<List<Furniture>, NetworkError> {
        return safeCall<FurnitureResponseDto>{
            httpClient.get(
                urlString = constructUrl("/products")
            )
        }.map { response ->
            response.data.map { it.toFurniture() }
        }
    }
}