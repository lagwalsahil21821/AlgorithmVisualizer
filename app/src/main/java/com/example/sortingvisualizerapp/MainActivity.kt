package com.example.sortingvisualizerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sortingvisualizerapp.ui.theme.SortingVisualizerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SortingVisualizerAppTheme {
                MainScreen(
                    algos = listOf(
                        Algo(
                            name = "Selection Sort",
                            R.drawable.ic_sort
                        ),
                        Algo(
                            name = "Insertion Sort",
                            R.drawable.ic_heap
                        ),
                        Algo(
                            name = "Bucket Sort",
                            R.drawable.ic_bucket
                        ),
                        Algo(
                            name = "Merge Sort",
                            R.drawable.ic_merge
                        ),
                        Algo(
                            name = "Quick Sort",
                            R.drawable.ic_quick
                        ),
                        Algo(
                            name = "Heap Sort",
                            R.drawable.ic_heap1
                        ),
                        Algo(
                            name = "Count Sort",
                            R.drawable.ic_count
                        )



                    )
                )
            }
        }
    }
}
