package com.example.sortingvisualizerapp.algorithms

class HeapSort : SortingAlgoInstance() {
    override suspend fun sort(
        arr: IntArray,
        iChange: (Int) -> Unit,
        jChange: (Int) -> Unit,
        onSwap: (IntArray) -> Unit,
    ) {
        val n = arr.size
        //build heap
        for (i in n / 2 - 1 downTo 0) {
            heapify(arr, n, i)
            iChange(i)
            onSwap(arr)
        }

        //extract element from heap -> one by one
        for (i in n - 1 downTo 1) {
            val temp = arr[0]
            arr[0] = arr[i]
            arr[i] = temp
            iChange(i)

            // calling max heapify on the reduced heap
            heapify(arr, i, 0)
            onSwap(arr)
        }

    }

    fun heapify(
        arr: IntArray,
        n: Int,
        i: Int
    ) {
        var largest = i // Initialize largest as root
        val l = 2 * i + 1 // left = 2*i + 1
        val r = 2 * i + 2 // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) largest = l

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]) largest = r

        // If largest is not root
        if (largest != i) {
            val swap = arr[i]
            arr[i] = arr[largest]
            arr[largest] = swap

            heapify(arr, n, largest)
        }
    }


}