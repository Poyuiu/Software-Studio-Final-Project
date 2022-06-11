package com.ss_team_1.koibitoshuuchuu.presentation.utils

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat
import com.ss_team_1.koibitoshuuchuu.R

@Composable
fun OutlinedText(
    text: String,
    fontSize: Int,
    fontResId: Int,
    textColor: Int,
    strokeColor: Int,
    strokeWidth: Int,
    width: Dp = 10.dp
) {

    // Set font as Id
    val customTypeface: android.graphics.Typeface? =
        ResourcesCompat.getFont(LocalContext.current, fontResId)
    val txtSize = fontSize * 2.7f
    // Create a Paint that has black stroke
    val textPaintStroke = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        style = android.graphics.Paint.Style.STROKE
        textSize = txtSize
        color = strokeColor
        //strokeWidth = 12f
        strokeMiter = 10f
        strokeJoin = android.graphics.Paint.Join.ROUND
        typeface = customTypeface
    }
    textPaintStroke.strokeWidth = strokeWidth * 5f

    // Create a Paint that has white fill
    val textPaint = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        style = android.graphics.Paint.Style.FILL
        textSize = txtSize
        color = textColor
        typeface = customTypeface
    }
    Box() {
        // Create a canvas, draw the black stroke and
        // override it with the white fill
        Canvas(
            modifier = Modifier.size(width, (fontSize * 1.3).dp),
            onDraw = {
                drawIntoCanvas {
                    it.nativeCanvas.drawText(
                        text,
                        10f,
                        txtSize,
                        textPaintStroke
                    )

                    it.nativeCanvas.drawText(
                        text,
                        10f,
                        txtSize,
                        textPaint
                    )
                }
            }
        )
    }

}