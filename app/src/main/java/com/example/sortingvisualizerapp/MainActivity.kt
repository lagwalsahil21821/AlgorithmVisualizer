package com.example.sortingvisualizerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.sortingvisualizerapp.algorithms.InsertionSort
import com.example.sortingvisualizerapp.navigation.Navigation
import com.example.sortingvisualizerapp.ui.theme.SortingVisualizerAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel: AlgorithmViewModel by lazy {
        val viewModelProviderFactory = AlgorithmViewModelProvider(InsertionSort())
        ViewModelProvider(this, viewModelProviderFactory)[AlgorithmViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SortingVisualizerAppTheme {
//                MainScreen(
//                    algos = listOf(
//                        Algo(
//                            name = "Selection Sort",
//                            R.drawable.ic_sort
//                        ),
//                        Algo(
//                            name = "Insertion Sort",
//                            R.drawable.ic_heap
//                        ),
//                        Algo(
//                            name = "Bucket Sort",
//                            R.drawable.ic_bucket
//                        ),
//                        Algo(
//                            name = "Merge Sort",
//                            R.drawable.ic_merge
//                        ),
//                        Algo(
//                            name = "Quick Sort",
//                            R.drawable.ic_quick
//                        ),
//                        Algo(
//                            name = "Heap Sort",
//                            R.drawable.ic_heap1
//                        ),
//                        Algo(
//                            name = "Count Sort",
//                            R.drawable.ic_count
//                        )
//
//
//
//                    )
//                )
                AlgoVisualizerScreen(viewModel)


            }
        }
    }

}
