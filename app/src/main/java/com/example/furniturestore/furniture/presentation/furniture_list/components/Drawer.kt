package com.example.furniturestore.furniture.presentation.furniture_list.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
enum class DrawerItems(val value:String,val icon:ImageVector){
    SETTINGS("Settings",Icons.Default.Settings),
    BASKET("Basket",Icons.Default.Delete),
    PROFILE("Profile",Icons.Default.Info)
}

@Composable
fun NavDrawer(
    modifier: Modifier = Modifier,
    drawerState: DrawerState,
    content: @Composable () -> Unit
    ) {
    val scope = rememberCoroutineScope()
    val selectedItem = remember{ mutableStateOf(DrawerItems.SETTINGS) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerState){
                Column(
                    modifier = Modifier.padding(top = 20.dp).verticalScroll(rememberScrollState()),
                ) {
                    Spacer(Modifier. height(12.dp))
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp).align(Alignment.CenterHorizontally),
                        text = "Main menu",
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    DrawerItems.entries.forEach { item ->
                        NavigationDrawerItem(
                            icon = { Icon(imageVector = item.icon, contentDescription = item.value) },
                            label = { Text(item.value. substringAfterLast(".")) },
                            selected = item == selectedItem.value,
                            onClick = {
                                scope. launch {
                                    drawerState. close()
                                }
                                selectedItem.value = item
                            },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults. ItemPadding)
                        )
                    }
                }
            }
        }){
        content()
    }
}