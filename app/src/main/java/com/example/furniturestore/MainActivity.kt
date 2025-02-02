package com.example.furniturestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.IconButton
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.furniturestore.core.navigation.FurnitureNavigation
import com.example.furniturestore.ui.theme.FurnitureTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FurnitureTheme {
                val topBarState = rememberSaveable { (mutableFloatStateOf(1f)) }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            modifier = Modifier.alpha(topBarState.floatValue),
                            title= { Text(
                                text = "Furniture app",
                                fontWeight = FontWeight.Normal,
                                color = MaterialTheme.colorScheme.primary,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 4,
                                fontSize = 22.sp
                            ) },
                            navigationIcon={ IconButton({ }) { Icon(Icons.Filled.Menu, contentDescription = "Меню")}},
                            actions={
                                IconButton({ }) { Icon(Icons.Filled.Info, contentDescription = "О приложении")}
                                IconButton({ }) {Icon(Icons.Filled.Search, contentDescription = "Поиск")}
                            },
                            colors= TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.background,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                                navigationIconContentColor = MaterialTheme.colorScheme.primary,
                                actionIconContentColor = MaterialTheme.colorScheme.primary)
                        )
                    },
                ){innerPadding ->
                    FurnitureNavigation(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        topBarState = topBarState //alpha
                    )
                }
            }
        }
    }
}
