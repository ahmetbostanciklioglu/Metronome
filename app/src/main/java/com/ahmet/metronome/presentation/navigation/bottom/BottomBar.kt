package com.ahmet.metronome.presentation.navigation.bottom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ahmet.metronome.R


@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Metronome,
        BottomBarScreen.Settings,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    BottomNavigation(
        backgroundColor = colorResource(id = R.color.background_color),
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                navController = navController,
                selected = screen.route == currentDestination?.route
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    selected: Boolean
) {

    var selected = selected
    BottomNavigationItem(

        label = {
            if (selected)
                Text(text = screen.title, color = colorResource(id = R.color.button_border_color))
            else
                Text(
                    text = screen.title,
                    color = colorResource(id = R.color.settings_section_color)
                )
        },
        icon = {

            if (selected)

                Image(
                    painter = painterResource(id = screen.icon),
                    contentDescription = "Navigation Icon",
                    modifier = modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(color = colorResource(id = R.color.button_border_color))
                )
            else
                Image(
                    painter = painterResource(id = screen.icon),
                    contentDescription = "Navigation Icon",
                    modifier = modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(color = colorResource(id = R.color.settings_section_color))
                )


        },
        selected = selected,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        selectedContentColor = colorResource(id = R.color.button_border_color),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },

    )
}