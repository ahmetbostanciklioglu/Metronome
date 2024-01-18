package com.ahmet.metronome.presentation.ui.splash.pagers

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.ahmet.metronome.R
import com.ahmet.metronome.extension.SplashImages
import com.ahmet.metronome.extension.SpringDotIndicators
import com.ahmet.metronome.extension.annotatedText


//Third Splash Page
@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ThirdHorizontalPagerScreen(
    modifier: Modifier = Modifier,
    pageCount: Int,
    pagerState: PagerState,
    painter: Painter,
    text: String,
    color: Color
) {

    //Background Image
    SplashImages(painter = painter, modifier = modifier.fillMaxSize())


    Column(
        modifier = modifier.fillMaxSize()
    ) {

        //Annotated Text Column
        Column(
            modifier = modifier.fillMaxHeight(0.80f),
            verticalArrangement = Arrangement.Center,

            //Column content
            content = {

                //Annotated Text
                Text(
                    text = annotatedText(
                        text = text,
                        color = color
                    ),
                    modifier = modifier
                        .align(Alignment.Start)
                        .padding(start = 16.dp),


                )
            }
        )


        //Horizontal Dots Pager Indicators  and  Button Column
        Column(
            modifier = modifier
                .padding(horizontal = 16.dp)
        ) {

            //Horizontal Dots Pager Indicators
            SpringDotIndicators(
                pageCount,
                pagerState,
                Modifier.padding(top = 16.dp)
            )

            //Adding space between Dots Indicator and Button
            Spacer(modifier = Modifier.height(16.dp))

            //Filled "Go Button"
            FilledTonalButton(
                onClick = { },

                content = {
                    //Button content
                    Text(text = "GO", modifier = modifier.scale(1.2f))
                },
                modifier = modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),

                //Button container(button background color) and content(Text color)
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = colorResource(
                        id = R.color.button_border_color
                    ), contentColor = Color.Black
                )
            )
        }
    }
}