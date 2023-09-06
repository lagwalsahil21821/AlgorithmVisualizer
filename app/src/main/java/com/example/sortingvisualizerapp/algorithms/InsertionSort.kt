package com.example.sortingvisualizerapp.algorithms

class InsertionSort: SortingAlgoInstance() {
    override suspend fun sort(
        arr: IntArray,
        iChange: (Int) -> Unit,
        jChange: (Int) -> Unit,
        onSwap: (IntArray) -> Unit
    ){
        for(i in 1 until arr.size){
            iChange(i)
            var j = i-1;
            val key = arr[i]
            while(j>=0 && key < arr[j]){
                jChange(j)
                arr[j+1] = arr[j]
                onSwap(arr)
                j--
            }
            arr[j+1] = key
            onSwap(arr)
        }
    }
}