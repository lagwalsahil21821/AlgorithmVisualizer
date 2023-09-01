package com.example.sortingvisualizerapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sortingvisualizerapp.ui.theme.LightGreen1

@Composable
fun VisualizerSection(
    modifier: Modifier = Modifier,
    arr: IntArray,
) {
    BoxWithConstraints(
        modifier = Modifier
    ) {
        val maxHeight = maxHeight - 75.dp
        val itemWidth = remember {          // for every bar
            (maxWidth / arr.size) - 8.dp
        }

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            arr.forEach {
                Box(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .height(if(it.dp > maxHeight) maxHeight else it.dp)
                        .width(itemWidth)
                        .background(LightGreen1)
                )
            }
        }
    }
}
