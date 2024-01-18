package com.ahmet.metronome.presentation.navigation.bottom


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ahmet.metronome.presentation.ui.metronome.MetronomeScreen
import com.ahmet.metronome.presentation.ui.settings.SettingsScreen

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Metronome.route
    ) {
        composable(route = BottomBarScreen.Metronome.route) {
            MetronomeScreen(modifier = modifier)
        }

        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }
    }
}




