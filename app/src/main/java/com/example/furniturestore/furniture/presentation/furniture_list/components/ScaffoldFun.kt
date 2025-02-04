package com.example.furniturestore.furniture.presentation.furniture_list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldFun(
    modifier: Modifier = Modifier,
    drawerState: DrawerState,
    content: @Composable (innerPadding: PaddingValues) -> Unit,
) {
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = modifier,
                title= { Text(
                    text = "Furniture app",
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.primary,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 4,
                    fontSize = 22.sp
                ) },
                navigationIcon={ IconButton(onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                }) { Icon(Icons.Filled.Menu, contentDescription = "Menu") }
                },
                actions={
                    IconButton({ }) { Icon(Icons.Filled.Info, contentDescription = "About app") }
                    IconButton({ }) { Icon(Icons.Filled.Search, contentDescription = "Search") }
                },
                colors= TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.primary,
                    actionIconContentColor = MaterialTheme.colorScheme.primary)
            )
        },
    ){innerPadding ->
        content(innerPadding)
    }
}