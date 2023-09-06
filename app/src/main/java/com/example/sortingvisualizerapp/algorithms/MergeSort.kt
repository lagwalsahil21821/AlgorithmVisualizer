package com.example.sortingvisualizerapp.algorithms

import androidx.compose.ui.input.key.Key.Companion.Copy

class MergeSort : SortingAlgoInstance(){
    override suspend fun sort(
        arr: IntArray,
        iChange : (Int) -> Unit,
        jChange : (Int) -> Unit,
        onSwap : (IntArray) -> Unit
    ){
        sort(arr, 0, arr.size-1, onSwap = onSwap)
    }

    suspend fun sort(
        arr: IntArray,
        l: Int,
        r: Int,
        onSwap: (IntArray) -> Unit,
    ) {
        if (l < r) {
            val mid = l + (r - l) / 2
            sort(arr, l, mid, onSwap = { onSwap(arr) })
            sort(arr, mid + 1, r, onSwap = { onSwap(arr) })
            merge(arr, l, mid, r, onSwap = { onSwap(arr) })
        }
    }

    private suspend fun merge(
        arr: IntArray,
        l: Int, m: Int,
        r: Int,
        onSwap: () -> Unit,
    ) {
        // Find sizes of two subarrays to be merged
        val n1 = m - l + 1
        val n2 = r - m

        /* Create temp arrays */
        val L = IntArray(n1) { 0 }
        val R = IntArray(n2) { 0 }


        for (i in 0 until n1)
            L[i] = arr[l + i]
        for (i in 0 until n2)
            R[i] = arr[m + 1 + i]

        // merge
        var i = 0
        var j = 0

        // Initial index of merged subarray array
        var k = l
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i]
                onSwap()
                i++
            } else {
                arr[k] = R[j]
                onSwap()
                j++
            }
            k++
        }

        // Copy remaining
        while (i < n1) {
            arr[k] = L[i]
            onSwap()
            i++
            k++
        }

        // Copy remaining
        while (j < n2) {
            arr[k] = R[j]
            onSwap()
            j++
            k++
        }
    }
}