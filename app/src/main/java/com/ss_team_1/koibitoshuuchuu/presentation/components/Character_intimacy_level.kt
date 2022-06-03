package com.ss_team_1.koibitoshuuchuu.presentation.components

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
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.ui.theme.mamelonFamily

@Composable
fun characterIntimacyLevel(
    intimacyLevel: Int
){
    Box(
        modifier = Modifier.size(40.dp)
    ){
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
fun heartpreview(){
    characterIntimacyLevel(1)
}

@Composable
fun intimacyBar(
    intimacy: Int,
    levelIntimacyNeed: Int
){
    val percentage = intimacy.toFloat()/levelIntimacyNeed.toFloat()
    Box(
        modifier = Modifier.size(248.dp,46.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.intimacy_bar_outerframe),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(16.dp).fillMaxWidth()
        )
        LevelbarRectangle(percentage)
    }
}
@Composable
fun LevelbarRectangle(
    percentage : Float
) {

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        val rectanglePath = Path().apply {
            val height = size.height
            moveTo(92f, height/(2.0f)-8f)//92f為起始點
            lineTo(92f+ (500f*percentage), height/(2.0f)-8f)//592f為終點
            lineTo(92f+ (500f*percentage), height/(2.0f)+8f)
            lineTo(92f, height/(2.0f)+8f)
        }
        drawPath(
            rectanglePath ,
            color =  Color(0xfff8bbd0)
        )
    }
}
@Preview(showBackground = false)
@Composable
fun intimacybarpreview(){
    intimacyBar(600,1314)
}

@Composable
fun ButtonWithBorder(
    lock: Boolean
) {
    Button(
        onClick = {
            /*TODO*/
        },
        border = BorderStroke(3.dp, Color.White),
        modifier = Modifier.size(48.dp),
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff94e7e1))//ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
    ) {
        Image(
            painterResource(id = R.drawable.ic_info_of_figure),
            contentDescription ="figure info button icon",
            modifier = Modifier.size(24.dp)
        )
    }
}
@Preview(showBackground = false)
@Composable
fun charcaterInfopreview(){
    ButtonWithBorder(false)
}