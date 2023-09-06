package com.example.sortingvisualizerapp.navigation

sealed class Routes(val rout: String){
    object MainScreen: Routes("ms")
    object AlgoVisualScreen: Routes("avs")
}
