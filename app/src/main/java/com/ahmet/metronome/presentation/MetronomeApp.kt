package com.ahmet.metronome.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ahmet.metronome.presentation.navigation.bottom.BottomBar
import com.ahmet.metronome.presentation.navigation.bottom.BottomNavGraph


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MetronomeApp(modifier: Modifier = Modifier) {


    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        BottomNavGraph(navController = navController, modifier = modifier.padding(it))
    }

}