package com.ahmet.metronome

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ahmet.metronome.presentation.MetronomeApp
import com.ahmet.metronome.ui.theme.MetronomeTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MetronomeTheme {
                // A surface container using the 'background' color from the theme

                Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
                    //SplashScreen(onClick = { })

                    MetronomeApp()

                }
            }
        }
    }
}

