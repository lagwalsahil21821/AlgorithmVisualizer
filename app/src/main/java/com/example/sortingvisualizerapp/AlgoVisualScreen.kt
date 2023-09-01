package com.example.sortingvisualizerapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.sortingvisualizerapp.algorithms.InsertionSort
import com.example.sortingvisualizerapp.components.VisualBottomBar
import com.example.sortingvisualizerapp.components.VisualizerSection
import com.example.sortingvisualizerapp.ui.theme.DeepBlue
import kotlin.reflect.KProperty


@Composable
fun AlgoVisualizerScreen(viewModel: AlgorithmViewModel){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column {
            VisualizerSection(
                arr = viewModel.arr.value,
                modifier = Modifier.fillMaxWidth()
            )

            val isPlaying = viewModel.isPlaying.value
            val isFinished = viewModel.onSortingFinish.value

            VisualBottomBar(
                playPauseClick = {viewModel.onEvent(AlgorithmEvents.PlayPause)},
                slowDownClick = {viewModel.onEvent(AlgorithmEvents.SlowDown) },
                speedUpClick = { viewModel.onEvent(AlgorithmEvents.SpeedUp) },
                previousClick = { viewModel.onEvent(AlgorithmEvents.Previous) },
                nextClick = { viewModel.onEvent(AlgorithmEvents.Next) },
                modifier = Modifier.fillMaxWidth()
                    .height(75.dp),
                isPlaying = if (isFinished) !isFinished else isPlaying

            )


        }
    }
}