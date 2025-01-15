package com.example.furniturestore.furniture.presentation.furniture_detail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@PreviewLightDark
fun BuyButton(modifier: Modifier = Modifier) {
    val contentColor = if(isSystemInDarkTheme()){
        Color.White
    }else{
        Color.Black
    }
    OutlinedButton(
        modifier = modifier.wrapContentHeight(),
        border = BorderStroke(width = 0.4.dp, color = contentColor),
        onClick = {

        },
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = contentColor
        )
    ) {
        Row() {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Buy",
            )
            // adding spacer on below line.
            Spacer(Modifier.height(10.dp))
            // adding text on below line.
            Text(
                modifier = Modifier.padding(start = 12.dp),
                // specifying text as android
                text = "Buy",
                // on below line adding style
                style = TextStyle(fontWeight = FontWeight.Bold),
                // adding text align on below line.
                textAlign = TextAlign.Center,
                // adding font size on below line.
                fontSize = 20.sp
            )
        }
    }
}