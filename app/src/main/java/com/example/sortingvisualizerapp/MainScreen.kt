package com.example.sortingvisualizerapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sortingvisualizerapp.navigation.Routes
import com.example.sortingvisualizerapp.ui.theme.DeepBlue
import com.example.sortingvisualizerapp.ui.theme.LightGreen1
import com.example.sortingvisualizerapp.ui.theme.TextWhite

@Composable
fun MainScreen(
    navController: NavController
) {
    MainScreenUI(
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


        ),
        onClick = {
            //navController.navigate(Routes.AlgoVisualScreen.rout + "/${it.algorithmId}")
        }
    )
}


@Composable
fun MainScreenUI(
    algos: List<Algo>,
    onClick: (Algo) -> Unit,
) {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Sorting Algorithms",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(color = TextWhite),
                modifier = Modifier.padding(15.dp)
            )
            Divider(
                thickness = 4.dp, color = LightGreen1
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(7.5.dp),
                modifier = Modifier.fillMaxHeight()
            ) {
                items(algos.size) {
                    AlgoItem(
                        algo = algos[it],
                        onClick = onClick
                    )

                }
            }
        }
    }
}

//every box on main screen
@Composable
fun AlgoItem(
    algo: Algo,
    onClick: (Algo) -> Unit
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(7.5.dp)
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(Color.LightGray)
            .clickable {
                onClick(algo)
            }
    ) {


        Icon(
            painter = painterResource(id = algo.iconId),
            contentDescription = algo.name,
            tint = Color.Unspecified,
            modifier = Modifier.padding(25.dp)
        )
        Text(
            text = algo.name,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(8.dp)
        )


    }
}