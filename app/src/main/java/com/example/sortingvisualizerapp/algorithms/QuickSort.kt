package com.example.sortingvisualizerapp.algorithms

class QuickSort : SortingAlgoInstance() {
    override suspend fun sort(
        arr: IntArray,
        iChange: (Int) -> Unit,
        jChange: (Int) -> Unit,
        onSwap: (IntArray) -> Unit,
    ) {
        sort(arr, 0, arr.size - 1, onSwap = onSwap)
    }

    suspend fun sort(
        arr: IntArray,
        low: Int,
        high: Int,
        onSwap: (IntArray) -> Unit,
    ) {
        if (low < high) {
            val pi: Int = partition(arr, low, high, onSwap = { onSwap(arr) })

            sort(arr, low, pi - 1, onSwap = { onSwap(arr) })
            sort(arr, pi + 1, high, onSwap = { onSwap(arr) })
        }
    }

    suspend fun partition(
        arr: IntArray,
        low: Int,
        high: Int,
        onSwap: () -> Unit,
    ): Int {
        val pivot = arr[high]

        var i = low - 1
        for (j in low until high) {

            if (arr[j] < pivot) {
                i++
                swap(arr, i, j)
                onSwap()
            }
        }
        swap(arr, i + 1, high)
        onSwap()
        return i + 1
    }

    // A utility function to swap two elements
    suspend fun swap(
        arr: IntArray,
        i: Int,
        j: Int,
    ) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}