package com.ahmet.metronome.extension

import android.os.Build
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.ahmet.metronome.R


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun annotatedText(text: String,  @ColorRes color: Color): AnnotatedString {

    val annotatedDescriptionText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = color,
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.outfit_font)),
                fontWeight = FontWeight(600),
                fontStyle = FontStyle.Normal,
            ),

        ) {
            append(text)
        }
    }

    return annotatedDescriptionText
}