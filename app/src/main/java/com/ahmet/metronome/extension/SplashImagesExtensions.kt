package com.ahmet.metronome.extension

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

//Splash Screen Background Image Extension
@Composable
fun SplashImages(modifier: Modifier = Modifier, painter: Painter) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(painter = painter, contentDescription = null, modifier = modifier.fillMaxSize(), contentScale = ContentScale.Crop)
    }
}
