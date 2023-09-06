package com.example.sortingvisualizerapp.algorithms

abstract class SortingAlgoInstance() {

    abstract suspend fun sort(
        arr: IntArray,
        iChange: (Int) -> Unit,
        jChange: (Int) -> Unit,
        onSwap: (IntArray) -> Unit
    )
}