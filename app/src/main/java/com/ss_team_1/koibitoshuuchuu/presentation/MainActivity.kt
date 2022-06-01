package com.ss_team_1.koibitoshuuchuu.presentation

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.ui.theme.KoiBitoShuuChuuTheme
import com.ss_team_1.koibitoshuuchuu.ui.theme.mamelonFamily


class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoiBitoShuuChuuTheme {
                LoverFocusApp(this)
            }
        }
    }
}

@Composable
fun LoverFocusApp(context: Context){
    val customTypeface = context.resources.getFont(R.font.mamelon)

    val textPaintStroke = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        style = android.graphics.Paint.Style.STROKE
        textSize = 64f
        color = android.graphics.Color.BLACK
        strokeWidth = 12f
        strokeMiter= 10f
        strokeJoin = android.graphics.Paint.Join.ROUND
        typeface = customTypeface
    }

    val textPaint = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        style = android.graphics.Paint.Style.FILL
        textSize = 64f
        color = android.graphics.Color.WHITE
        typeface = customTypeface
    }
    Surface(color = MaterialTheme.colors.primary) {
        Text(text = "Welcome，你好", modifier = Modifier.padding(24.dp),fontFamily = mamelonFamily, fontWeight = FontWeight.Normal)
        Canvas(
            modifier = Modifier.fillMaxSize(),
            onDraw = {
                drawIntoCanvas {
                    it.nativeCanvas.drawText(
                        "戀人專注Welcome，你好",
                        0f,
                        120.dp.toPx(),
                        textPaintStroke
                    )
                    it.nativeCanvas.drawText(
                        "戀人專注Welcome，你好",
                        0f,
                        120.dp.toPx(),
                        textPaint
                    )
                }
            }
        )

    }
}


@Preview
@Composable
fun DefaultPreview() {
    KoiBitoShuuChuuTheme {
        LoverFocusApp(LocalContext.current)
    }
}