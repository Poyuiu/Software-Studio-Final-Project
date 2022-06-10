package com.ss_team_1.koibitoshuuchuu.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.R

val mamelonFamily = FontFamily(
    Font(R.font.mamelon, FontWeight.Normal),
    //Font(R.font.mamelon_bold,FontWeight.Bold)
)
val huninnFamily = FontFamily(
    Font(R.font.openhuninn)
)
// Set of Material typography styles to start with
val mainFont = R.font.mamelon

val contextFont = R.font.openhuninn

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = mamelonFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

