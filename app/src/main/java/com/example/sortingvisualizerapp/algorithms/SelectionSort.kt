package com.example.sortingvisualizerapp.algorithms

class SelectionSortSort: SortingAlgoInstance(){
    override suspend fun sort(
        arr: IntArray,
        iChange: (Int) -> Unit,
        jChange: (Int) -> Unit,
        onSwap: (IntArray) -> Unit
    ){
        val n = arr.size
        for( i in 0 until n-1){
            var miniInd = i
            iChange(i)
            for(j in i+1 until n){
                if(arr[j] < arr[miniInd]){
                    miniInd = j
                }
                jChange(j)

            }
            val temp = arr[miniInd]
            arr[miniInd] = arr[i]
            arr[i] = temp
            onSwap(arr)
        }
    }
}