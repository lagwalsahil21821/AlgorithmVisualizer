package com.example.sortingvisualizerapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sortingvisualizerapp.AlgorithmEvents
import com.example.sortingvisualizerapp.R
import com.example.sortingvisualizerapp.ui.theme.DeepBlue

@Composable
fun VisualBottomBar(
    modifier: Modifier = Modifier,
    playPauseClick: () -> Unit,
    slowDownClick: () -> Unit,
    speedUpClick: () -> Unit,
    previousClick: () -> Unit,
    nextClick: () -> Unit,
    isPlaying: Boolean = false,
) {
    BottomAppBar(
        modifier = modifier,
        backgroundColor = DeepBlue
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = slowDownClick) {
                androidx.compose.material.Icon(
                    painter = painterResource(id = R.drawable.ic_minus),
                    contentDescription ="Slow Down",
                    tint = Color.White,
                    modifier = Modifier.size(14.dp)
                )
            }

            IconButton(onClick = playPauseClick) {

                androidx.compose.material.Icon(
                    painter = painterResource(
                        id = if(isPlaying) R.drawable.ic_pause else R.drawable.ic_play
                    ),
                    contentDescription ="Pause Button",
                    tint = Color.White
                )
            }

            IconButton(onClick = speedUpClick) {
                androidx.compose.material.Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription ="Speed Up",
                    tint = Color.White
                )
            }

            IconButton(onClick = previousClick) {
                androidx.compose.material.Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription ="Previous",
                    tint = Color.White
                )
            }

            IconButton(onClick = nextClick) {
                androidx.compose.material.Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription ="Next",
                    tint = Color.White
                )
            }
        }

    }
}

