package com.ss_team_1.koibitoshuuchuu.presentation.experiment

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.content.res.ResourcesCompat.getFont
import com.ss_team_1.koibitoshuuchuu.R

@Preview(showBackground = true)
@Composable
private fun OutlinedTextEXP() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        // Creating a Column Layout
        Column(
            Modifier.fillMaxSize(0.7f),
            verticalArrangement = Arrangement.Center
        ) {
            val customTypeface: android.graphics.Typeface? =
                getFont(LocalContext.current, R.font.mamelon)

            // Create a Paint that has black stroke
            val textPaintStroke = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                style = android.graphics.Paint.Style.STROKE
                textSize = 100f
                color = android.graphics.Color.BLACK
                strokeWidth = 20f
                strokeMiter = 10f
                strokeJoin = android.graphics.Paint.Join.ROUND
                typeface = customTypeface
            }

            // Create a Paint that has white fill
            val textPaint = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                style = android.graphics.Paint.Style.FILL
                textSize = 100f
                color = android.graphics.Color.WHITE
                typeface = customTypeface
            }

            // Create a canvas, draw the black stroke and
            // override it with the white fill
            Canvas(
                modifier = Modifier.fillMaxSize(),
                onDraw = {
                    drawIntoCanvas {
                        it.nativeCanvas.drawText(
                            "GeeksforGeeks",
                            0f,
                            100f,
                            textPaintStroke
                        )

                        it.nativeCanvas.drawText(
                            "GeeksforGeeks",
                            0f,
                            100f,
                            textPaint
                        )
                    }
                }
            )
            Text(text = "GeeksforGeeks", fontSize = 37.sp, modifier = Modifier.zIndex(4f))
        }
    }

}
