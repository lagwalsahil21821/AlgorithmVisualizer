package com.example.sortingvisualizerapp

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sortingvisualizerapp.algorithms.InsertionSort
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AlgorithmViewModel(
    private val insertionSort: InsertionSort
): ViewModel() {
    var arr = mutableStateOf(
        intArrayOf(
            50,52, 165,400,244,126,54,65, 2,4,509, 52, 76, 533, 46, 659,
            438, 42, 534, 128, 87, 162, 25, 428, 38, 9, 26
        )
    )

    val isPlaying = mutableStateOf(false)
    val onSortingFinish = mutableStateOf(false)
    private var delay = 150L
    private var pause = false

    private var next = 1
    private var previous = 0

    private var sortedArrayLevels = mutableListOf<List<Int>>()      // at every level which data

    init {      // init block runs every time the class initiated
        viewModelScope.launch {
            insertionSort.sort(
                arr.value.clone(),
                iChange = { i ->

                },
                jChange = { j ->

                }
            ){modifiedArray ->
                sortedArrayLevels.add(modifiedArray.toMutableList())
            }
        }
    }


    fun onEvent(event: AlgorithmEvents){
        when(event){
            is  AlgorithmEvents.SlowDown -> {
                slowDown()
            }
            is AlgorithmEvents.PlayPause -> {
                playPause()
            }
            is AlgorithmEvents.SpeedUp -> {
                speedUp()
            }
            is AlgorithmEvents.Next -> {
                next()
            }
            is AlgorithmEvents.Previous -> {
                previous()
            }

        }
    }

    private fun previous() {
        if(previous >= 0){
            arr.value = sortedArrayLevels[previous].toIntArray()
            next--
            previous--
        }
    }

    private fun next() {
        if(next < sortedArrayLevels.size){
            arr.value = sortedArrayLevels[next].toIntArray()
            next++
            previous++
        }
    }

    private fun speedUp() {
        delay -= 50
    }

    private fun slowDown() {
        if(delay >=150L) delay += 50
    }

    private fun playPause() {
        if(isPlaying.value)
            pause()
        else
            play()
        isPlaying.value = !isPlaying.value
    }

    private var sortingState = 0
    private fun play() = viewModelScope.launch {
        pause = false;
        for(i in sortingState until sortedArrayLevels.size){
            if(!pause){ // means its playing then you need to show next state
                delay(delay)
                arr.value = sortedArrayLevels[i].toIntArray()
            }
            else    // means pause: then you need to remember current state
            {
                sortingState = i
                next = i+1
                previous = i
                return@launch
            }
        }
        onSortingFinish.value = true
    }

    private fun pause() {
        pause = true
    }
}


