package com.example.sortingvisualizerapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
    h1 = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        color = SortingVisualizerColor.charcoal
    ),

    h2 = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = SortingVisualizerColor.charcoal
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Bold,
        color = SortingVisualizerColor.green
    ),

    button = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )
)