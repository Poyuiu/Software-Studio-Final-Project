package com.ss_team_1.koibitoshuuchuu.presentation.components

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.Page
import com.ss_team_1.koibitoshuuchuu.ui.theme.GreenBlue
import com.ss_team_1.koibitoshuuchuu.ui.theme.black
import com.ss_team_1.koibitoshuuchuu.ui.theme.gray
//import com.ss_team_1.koibitoshuuchuu.presentation.StrokeText
import com.ss_team_1.koibitoshuuchuu.ui.theme.mamelonFamily

@Composable
fun characterIntimacyLevel(
    intimacyLevel: Int
) {
    Box(
        modifier = Modifier.size(40.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.heart_intimacy),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Text(
            text = "$intimacyLevel",
            modifier = Modifier.align(Center),
            fontSize = 20.sp,
            fontFamily = mamelonFamily,
            fontWeight = FontWeight.Normal,
            color = Color(0xFFFFFFFF)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun heartpreview() {
    characterIntimacyLevel(1)
}

@Composable
fun intimacyBar(
    intimacy: Int,
    levelIntimacyNeed: Int
) {
    val percentage = intimacy.toFloat() / levelIntimacyNeed.toFloat()
    val showPercentage: MutableState<Boolean> =
        remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .size(248.dp, 46.dp)
            .clickable(
                enabled = true,
                onClickLabel = "check percentage",
                onClick = {
                    showPercentage.value = !showPercentage.value
                }
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.intimacy_bar_outerframe),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
        LevelbarRectangle(percentage)
        if (showPercentage.value) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                percentageLabel(
                    percentage
                )
            }
        }
    }
}

@Composable
fun percentageLabel(
    percentage: Float,
    modifier: Modifier = Modifier
) {
    val percent = (percentage * 100).toInt()
    Box(
        modifier = modifier
            .size(56.dp, 32.dp)
            .absoluteOffset(((percentage * 190).toInt()).dp, 0.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.label_shape),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Text(
            text = "$percent%",
            modifier = Modifier.align(Center),
            fontSize = 20.sp,
            fontFamily = mamelonFamily,
            fontWeight = FontWeight.Normal,
            color = Color(0xFFFFFFFF)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun labelpreview() {
    percentageLabel(0.444f)
}

@Composable
fun LevelbarRectangle(
    percentage: Float
) {

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        val rectanglePath = Path().apply {
            val height = size.height
            moveTo(92f, height / (2.0f) - 8f)//92f????????????
            lineTo(92f + (500f * percentage), height / (2.0f) - 8f)//592f?????????
            lineTo(92f + (500f * percentage), height / (2.0f) + 8f)
            lineTo(92f, height / (2.0f) + 8f)
        }
        drawPath(
            rectanglePath,
            color = Color(0xfff8bbd0)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun intimacybarpreview() {
    intimacyBar(900, 1314)
}

@Composable
fun ButtonWithBorder(
    lock: Boolean,
    onClickToCharacterInfo: () -> Unit = {}
) {
    if (lock) {
        Button(
            onClick = {},
            border = BorderStroke(3.dp, Color.White),
            modifier = Modifier.size(48.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffC4C4C4))//?????????
        ) {
            Image(
                painterResource(id = R.drawable.ic_info_of_figure),
                contentDescription = "figure info button icon",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color(0xff979797))//?????????
            )
        }
    } else {
        Button(
            onClick = onClickToCharacterInfo,
            border = BorderStroke(3.dp, Color.White),
            modifier = Modifier.size(48.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff94e7e1))
        ) {
            Image(
                painterResource(id = R.drawable.ic_info_of_figure),
                contentDescription = "figure info button icon",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun charcaterInfopreview() {
    ButtonWithBorder(true)
}

@Composable
fun FocusButton(
    context: Context,
    lock: Boolean,
    navController: NavController = NavController(LocalContext.current)
) {
    Box(
        Modifier
            .size(216.dp, 66.dp)

    ) {
        if (lock) {
            Image(
                painter = painterResource(id = R.drawable.focus_button_unlock),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        enabled = false,
                        onClickLabel = "unlock click",
                        onClick = {
                            /*TODO*/
                            navController.navigate(Page.FocusIntro.route)
                        }
                    )
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.focus_button),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        enabled = true,
                        onClickLabel = "focus click",
                        onClick = {
                            navController.navigate(Page.FocusIntro.route)
                        }
                    )
            )
        }

    }

}

@Preview
@Composable
fun FocusButtonPreview() {
    FocusButton(LocalContext.current, true)
}
/*@SuppressLint("NewApi")
@Composable
fun ButtonStrokeText(context: Context, string: String, x: Float, y: Int, size: Float){
val customTypeface = context.resources.getFont(R.font.mamelon)

val textPaintStroke = Paint().asFrameworkPaint().apply {
    isAntiAlias = true
    style = android.graphics.Paint.Style.STROKE
    textSize = size
    color = (0xff09756D).toInt()
    strokeWidth = size/20f
    strokeMiter= size/20f
    strokeJoin = android.graphics.Paint.Join.ROUND
    typeface = customTypeface
}

val textPaint = Paint().asFrameworkPaint().apply {
    isAntiAlias = true
    style = android.graphics.Paint.Style.FILL
    textSize = size
    color = (0xff09756D).toInt()
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
}*/
