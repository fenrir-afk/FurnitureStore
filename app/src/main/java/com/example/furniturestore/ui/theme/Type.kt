package com.example.furniturestore.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.gemstore.R

val Coats = FontFamily(
    Font(
        resId = R.font.coats_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.coats_light_italic,
        weight = FontWeight.Normal,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.coats_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.coats_black_italic,
        weight = FontWeight.Bold,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.thin,
        weight = FontWeight.Thin,
    ),
)
val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = Coats,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = Coats,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Coats,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Coats,
        fontWeight = FontWeight.Normal,
    ),
    headlineMedium = TextStyle(
        fontFamily = Coats,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
)