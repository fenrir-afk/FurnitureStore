package com.example.furniturestore

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.furniturestore.core.presentation.ObserveAsEvents
import com.example.furniturestore.core.presentation.toString
import com.example.furniturestore.furniture.presentation.furniture_list.FurnitureListEvent
import com.example.furniturestore.furniture.presentation.furniture_list.FurnitureListViewModel
import com.example.furniturestore.furniture.presentation.furniture_list.FurnitureScreen
import com.example.furniturestore.ui.theme.FurnitureTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FurnitureTheme {
                Scaffold(modifier = Modifier.fillMaxSize()){innerPadding ->
                    val viewModel = koinViewModel<FurnitureListViewModel>()
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
                    FurnitureScreen(
                        state = state,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
