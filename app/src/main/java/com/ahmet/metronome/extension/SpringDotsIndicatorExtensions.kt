package com.ahmet.metronome.extension

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.ahmet.metronome.R
import com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic
import com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SpringDotIndicators(pageCount: Int, pagerState: PagerState, modifier: Modifier) {

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        DotsIndicator(
            dotCount = pageCount,
            type = SpringIndicatorType(
                dotsGraphic = DotGraphic(
                    16.dp,
                    color = Color.White
                ),
                selectorDotGraphic = DotGraphic(
                    16.dp,
                    borderColor = colorResource(id = R.color.button_border_color),
                    color = colorResource(id = R.color.button_border_color)
                )
            ),
            pagerState = pagerState
        )
    }
}