package com.example.furniturestore.furniture.presentation.furniture_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.furniturestore.core.domain.util.onError
import com.example.furniturestore.core.domain.util.onSuccess
import com.example.furniturestore.core.presentation.util.FurnitureCategories
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
            loadFurnitureItems(_state.value.category)
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
                _state.update { it.copy(
                    selectedItem = action.item
                ) }
            }
        }
    }
    fun loadFurnitureItems(category: FurnitureCategories){
        viewModelScope.launch {
            if(state.value.category != category){
                _state.update { it.copy(
                    category = category,
                    offset = 0,
                    isLoading = true,
                    furnitureItems = emptyList()
                ) }
            }else if(state.value.offset == 0){
                _state.update { it.copy(
                    isLoading = true
                ) }
            }
            furnitureDataSource.getFurnitureItems(state.value.offset,category.name).onSuccess { items->
                _state.update {
                    it.copy(
                        isLoading = false,
                        furnitureItems = state.value.furnitureItems + items,
                        offset = state.value.offset+1
                    )
                }
            }.onError { error->
                _state.update { it.copy(isLoading = false) }
                _events.send(FurnitureListEvent.Error(error))
            }
        }
    }
}