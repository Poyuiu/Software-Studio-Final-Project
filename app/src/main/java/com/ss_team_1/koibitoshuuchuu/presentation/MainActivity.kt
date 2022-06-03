package com.ss_team_1.koibitoshuuchuu.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.components.BackButton
import com.ss_team_1.koibitoshuuchuu.presentation.components.CharacterInfo
import com.ss_team_1.koibitoshuuchuu.presentation.components.PlotList
import com.ss_team_1.koibitoshuuchuu.presentation.components.TopBar
import com.ss_team_1.koibitoshuuchuu.ui.theme.KoiBitoShuuChuuTheme
import com.ss_team_1.koibitoshuuchuu.ui.theme.mamelonFamily


class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoiBitoShuuChuuTheme {
                WelcomePage(this)
            }
        }
    }
}



@Composable
fun WelcomePage(context: Context){
    Box(
        Modifier
            .fillMaxSize()
            .clickable (
                enabled = true,
                onClickLabel = "Welcomepage click",
                onClick = {
                    /*TODO*/
                }
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_only_color),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        //這個式子只能用手算的 phone: x=1080f y=904
        StrokeText(LocalContext.current,"戀人專注", 204f,180,168f)//每個字的寬度=size
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Image(
                painter = painterResource(id = R.drawable.welcomepage_photo),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        StrokeText(LocalContext.current,"點擊開始", 372f,800,84f)
    }
}

@Preview
@Composable
fun WelcomepagePreview() {
    KoiBitoShuuChuuTheme {
        WelcomePage(LocalContext.current)
    }
}

@SuppressLint("NewApi")
@Composable
fun StrokeText(context: Context,string: String, x: Float, y: Int, size: Float){
    val customTypeface = context.resources.getFont(R.font.mamelon)

    val textPaintStroke = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        style = android.graphics.Paint.Style.STROKE
        textSize = size
        color = android.graphics.Color.BLACK
        strokeWidth = size/6f
        strokeMiter= size/8f
        strokeJoin = android.graphics.Paint.Join.ROUND
        typeface = customTypeface
    }

    val textPaint = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        style = android.graphics.Paint.Style.FILL
        textSize = size
        color = android.graphics.Color.WHITE
        typeface = customTypeface
    }
    Canvas(
        modifier = Modifier.fillMaxSize(),
        onDraw = {
            drawIntoCanvas {
                it.nativeCanvas.drawText(
                    string,
                    x,
                    y.dp.toPx(),
                    textPaintStroke
                )
                it.nativeCanvas.drawText(
                    string,
                    x,
                    y.dp.toPx(),
                    textPaint
                )
            }
        }
    )
}

/*@Composable
fun LoverFocusApp(context: Context){

    Surface(
        color = MaterialTheme.colors.primary
    ) {
        Text(text = "Welcome，你好", modifier = Modifier.padding(24.dp),fontFamily = mamelonFamily, fontWeight = FontWeight.Normal)
        StrokeText(LocalContext.current,"戀人專注Welcome，你好", 30f,100,64f)

    }
}

@Preview
@Composable
fun DefaultPreview() {
    KoiBitoShuuChuuTheme {
        LoverFocusApp(LocalContext.current)
    }
}*/