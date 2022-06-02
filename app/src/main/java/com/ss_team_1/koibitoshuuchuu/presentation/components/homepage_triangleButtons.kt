package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun TrianglebuttonPreview() {
    RoundedTriangle()

}

@Composable
fun RoundedTriangle() {

    Canvas(modifier = Modifier.size(60.dp)) {
        val trianglePath = Path().apply {
            val height = size.height
            val width = size.width
            moveTo(3f, 3f)
            lineTo((width/3.0f)-1.0f, height/(2.0f))
            lineTo(2f, height-1.0f)
        }
        drawPath(
            trianglePath ,
            color =  Color(0xfff8bbd0)

        )
        val trianglePathStroke = Path().apply {
            val height = size.height
            val width = size.width
            moveTo(2f, 2f)
            lineTo(width/3.0f, height/(2.0f))
            lineTo(2f, height)
            lineTo(2f, 2f)
        }
        drawPath(
            trianglePathStroke ,
            color =  Color.White,
            style = Stroke(
                width = 2.dp.toPx(),
                pathEffect = PathEffect.cornerPathEffect(4.dp.toPx())
            )
        )
    }
}

