package com.ahmet.metronome.presentation.navigation.bottom

import com.ahmet.metronome.R


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Metronome : BottomBarScreen(
        route = "metronome",
        title = "Metronome",
        icon = R.drawable.metronome_icon
    )


    object Settings : BottomBarScreen(
        route = "settings",
        title = "Settings",
        icon = R.drawable.settings_icon
    )
}
