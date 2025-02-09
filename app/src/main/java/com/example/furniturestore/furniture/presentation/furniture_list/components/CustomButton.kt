package com.example.furniturestore.furniture.presentation.furniture_list.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(modifier: Modifier = Modifier,text:String,onClick: () -> Unit) {
    OutlinedButton(
        modifier = modifier,
        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
        shape = CircleShape,
        onClick = {
            onClick()
        }
    ) {
        Icon(Icons.Default.Add,"", tint = MaterialTheme.colorScheme.primary)
        Text(
            color = MaterialTheme.colorScheme.primary,
            text = text,
            fontSize = 20.sp
        )
    }
}