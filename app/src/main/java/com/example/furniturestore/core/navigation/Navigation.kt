package com.example.furniturestore.core.navigation

import android.widget.Toast
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.furniturestore.core.presentation.ObserveAsEvents
import com.example.furniturestore.core.presentation.toString
import com.example.furniturestore.furniture.presentation.furniture_detail.FurnitureDetailScreen
import com.example.furniturestore.furniture.presentation.furniture_list.FurnitureListActions
import com.example.furniturestore.furniture.presentation.furniture_list.FurnitureListEvent
import com.example.furniturestore.furniture.presentation.furniture_list.FurnitureListViewModel
import com.example.furniturestore.furniture.presentation.furniture_list.FurnitureScreen
import com.example.furniturestore.furniture.presentation.furniture_list.components.NavDrawer
import com.example.furniturestore.furniture.presentation.furniture_list.components.ScaffoldFun
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun FurnitureNavigation(
    modifier: Modifier = Modifier,
    viewModel: FurnitureListViewModel = koinViewModel()
) {
    val navController = rememberNavController()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    ObserveAsEvents(events = viewModel.event) {event ->
        when(event){
            is FurnitureListEvent.Error -> {
                Toast.makeText(
                    context,
                    event.error.toString(context),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(navController = navController, startDestination = Route.FurnitureGraph) {
            navigation<Route.FurnitureGraph>(
                startDestination = Route.FurnitureList
            ) {
                composable<Route.FurnitureList>(
                    exitTransition = { slideOutHorizontally() },
                    popEnterTransition = { slideInHorizontally() }
                ) {
                    val drawerState = rememberDrawerState(DrawerValue.Closed)
                    NavDrawer(
                        drawerState = drawerState
                    ){
                        ScaffoldFun(
                            modifier = Modifier,
                            drawerState = drawerState,
                            content = { innerPadding ->
                                FurnitureScreen(
                                    modifier = modifier.padding(innerPadding),
                                    state = state,
                                    onItemClick = { selectedItem ->
                                        viewModel.onAction(FurnitureListActions.OnItemClick(item = selectedItem))
                                        navController.navigate(Route.FurnitureDetail)
                                    },
                                    onContinueClick = {
                                        viewModel.loadFurnitureItems()
                                    }
                                )
                            }
                        )
                    }
                }
                composable<Route.FurnitureDetail>(
                    enterTransition = {
                        slideInHorizontally { initialOffset ->
                            initialOffset
                        }
                    },
                    exitTransition = {
                        slideOutHorizontally { initialOffset ->
                            initialOffset
                        }
                    }
                ) {
                    FurnitureDetailScreen(
                        modifier = Modifier.fillMaxSize(),
                        furniture = state.selectedItem!!,
                        onBackClick = {
                            navController.navigate(Route.FurnitureList)
                        }
                    )
                }
            }
        }
    }
}