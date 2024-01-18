package com.ahmet.metronome.presentation.ui.splash

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import com.ahmet.metronome.R
import com.ahmet.metronome.presentation.ui.splash.pagers.FirstAndSecondHorizontalPagerScreen
import com.ahmet.metronome.presentation.ui.splash.pagers.ThirdHorizontalPagerScreen


//All Splash Screens(First, Second and Third)
@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun SplashScreen(onClick: () -> Unit) {

    val pageCount by remember { mutableIntStateOf(3) }

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        // provide pageCount
        pageCount
    }

    val firstSplashScreenText = stringArrayResource(id = R.array.first_page_description_text)
    val secondSplashScreenText = stringArrayResource(id = R.array.second_page_description_text)
    val thirdSplashScreenText = stringArrayResource(id = R.array.third_page_description_text)


    val firstAndSecondSplashTextColorArray = listOf(
        R.color.custom_white_color,
        R.color.button_border_color,
        R.color.custom_white_color
    )
    val thirdColorSplashTextColorArray = listOf(
        R.color.custom_white_color,
        R.color.custom_white_color,
        R.color.button_border_color,
    )


    //Splash Screen Box
    Box {

        //Splash Screen Column
        Column {

            //Horizontal Pager//Third Splash Page
            //Second Splash Page
            //item: 0, 1 and 2
            HorizontalPager(
                modifier = Modifier,
                state = pagerState,
                pageSpacing = 0.dp,

                userScrollEnabled = true,
                reverseLayout = false,
                contentPadding = PaddingValues(0.dp),
                beyondBoundsPageCount = 0,
                pageSize = PageSize.Fill,
                flingBehavior = PagerDefaults.flingBehavior(state = pagerState),
                key = null,
                pageNestedScrollConnection = PagerDefaults.pageNestedScrollConnection(
                    Orientation.Horizontal
                ),
                pageContent = { index ->
                    when (index) {
                        0 -> {
                            for (item in firstSplashScreenText.indices) { //item: 0, 1 and 2
                                FirstAndSecondHorizontalPagerScreen(
                                    pageCount = pageCount,
                                    pagerState = pagerState,
                                    onClick = {
                                        onClick
                                    },
                                    painter = painterResource(id = R.drawable.first_image),
                                    text = firstSplashScreenText[item],
                                    color = colorResource(id = firstAndSecondSplashTextColorArray[item])

                                )
                            }

                        }

                        1 -> {
                            //Second Splash Page
                            for (item in secondSplashScreenText.indices - 1) {
                                FirstAndSecondHorizontalPagerScreen(
                                    pageCount = pageCount,
                                    pagerState = pagerState,
                                    onClick = {
                                        onClick
                                    },
                                    painter = painterResource(id = R.drawable.second_image),
                                    text = secondSplashScreenText[item],
                                    color = colorResource(id = firstAndSecondSplashTextColorArray[item])
                                )
                            }
                        }

                        2 -> {
                            //Third Splash Page
                            for (item in thirdSplashScreenText.indices - 1) {
                                ThirdHorizontalPagerScreen(
                                    pageCount = pageCount,
                                    pagerState = pagerState,
                                    painter = painterResource(id = R.drawable.third_image),
                                    text = thirdSplashScreenText[item],
                                    color = colorResource(id = thirdColorSplashTextColorArray[item])
                                )
                            }
                        }
                    }
                }
            )
        }
    }

}









