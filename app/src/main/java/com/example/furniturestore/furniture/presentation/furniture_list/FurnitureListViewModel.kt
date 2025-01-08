package com.example.furniturestore.furniture.presentation.furniture_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.furniturestore.core.domain.util.onError
import com.example.furniturestore.core.domain.util.onSuccess
import com.example.furniturestore.furniture.domain.dataSource.FurnitureDataSource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FurnitureListViewModel(
    private val furnitureDataSource: FurnitureDataSource
):ViewModel() {
    private val _state = MutableStateFlow(FurnitureListState())
    val state = _state.
        onStart {
            loadFurnitureItems()
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            FurnitureListState()
        )

    private val _events = Channel<FurnitureListEvent>()
    val event = _events.receiveAsFlow()

    fun onAction(action: FurnitureListActions){
        when(action){
            is FurnitureListActions.OnItemClick -> {

            }
        }
    }
    private fun loadFurnitureItems(){
        viewModelScope.launch {
            _state.update { it.copy(
                isLoading = true
            ) }

            furnitureDataSource.getFurnitureItems().onSuccess { items->
                _state.update {
                    it.copy(
                        isLoading = false,
                        furnitureItems = items
                    )
                }
            }.onError { error->
                _state.update { it.copy(isLoading = false) }
                _events.send(FurnitureListEvent.Error(error))
            }
        }
    }
}