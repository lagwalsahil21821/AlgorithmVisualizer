package com.example.sortingvisualizerapp.navigation

sealed class Routes(val route: String){
    object MainScreen: Routes("ms")
    object AlgoVisualScreen: Routes("avs")
}
