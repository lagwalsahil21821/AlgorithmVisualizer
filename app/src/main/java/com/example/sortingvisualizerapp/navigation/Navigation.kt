package com.example.sortingvisualizerapp.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navArgument
import com.example.sortingvisualizerapp.AlgoVisualizerScreen
import com.example.sortingvisualizerapp.MainScreen
import com.example.sortingvisualizerapp.ui.theme.DeepBlue

@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.MainScreen.rout,
        modifier = Modifier
            .background(DeepBlue)
            .then(modifier)
    ){
        composable(
            route = Routes.MainScreen.rout
        ){

            MainScreen(navController = navController)
        }

        composable(
            route = Routes.AlgoVisualScreen.rout + "/{algorithmId}",
            arguments = listOf(
                navArgument("algorithmId"){
                    nullable = false
                    type = NavType.IntType
                }
            )
        ){
            val algorithmId = remember{
                it.arguments?.getInt("algorithmId")
            }

//            AlgoVisualizerScreen(
//                algorithmId = algorithmId!!,
//                navController = navController
//            )
        }

    }

}

