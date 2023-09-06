package com.example.sortingvisualizerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
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
                //MainScreen()
                //AlgoVisualizerScreen(viewModel)
                val navController = rememberNavController()
                Navigation(
                    navController = navController,
                    modifier = Modifier
                        .fillMaxSize()
                )

            }
        }
    }

}
