package com.example.furniturestore.furniture.presentation.furniture_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.furniturestore.core.presentation.util.FurnitureCategories


@Composable
fun CustomDropDownMenu(modifier: Modifier = Modifier,onItemClick:(FurnitureCategories) -> Unit) {
    Box(
        modifier = modifier
    ){
        val expanded: MutableState<Boolean> = remember { mutableStateOf(false) }
        Icon(
            modifier = Modifier.clickable {
                expanded.value = true
            },
            imageVector = Icons.Filled.Search,
            contentDescription = "Search"
        )
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            FurnitureCategories.entries.forEach{ item ->
                if(item == FurnitureCategories.entries.last()){
                    HorizontalDivider()
                }
                DropdownMenuItem(
                    onClick = {
                        onItemClick(FurnitureCategories.valueOf(item.name))
                        expanded.value = false
                    },
                    text = { Text(item.name) }
                )
            }
        }
    }
}