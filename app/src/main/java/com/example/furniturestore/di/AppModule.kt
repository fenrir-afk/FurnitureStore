package com.example.furniturestore.di

import com.example.furniturestore.core.data.networking.HttpClientFactory
import com.example.furniturestore.furniture.data.networking.RemoteFurnitureDataSource
import com.example.furniturestore.furniture.domain.dataSource.FurnitureDataSource
import com.example.furniturestore.furniture.presentation.furniture_list.FurnitureListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteFurnitureDataSource).bind<FurnitureDataSource>()

    viewModelOf(::FurnitureListViewModel)
}