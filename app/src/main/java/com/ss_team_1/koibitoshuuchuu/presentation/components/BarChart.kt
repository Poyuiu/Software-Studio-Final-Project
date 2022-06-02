package com.ss_team_1.koibitoshuuchuu.presentation.components


import android.graphics.Paint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.ui.theme.mainFont
import com.ss_team_1.koibitoshuuchuu.ui.theme.secUn

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun BarChartPreview() {
    BarChart(
        data = mapOf(
            Pair("Jan", 6f),
            Pair("Feb", 4f),
            Pair("Mar", 3f),
            Pair("Apr", 7f),
            Pair("May", 1f),
            Pair("Jun", 2f),
            Pair("Jul", 1f),
        )
    )
}

@Composable
fun BarChart(
    title: String = "FOCUS ANALYSIS",
    data: Map<String, Float>,
    barColor: Color = Color.Black,
    barWidth: Float = 50f,
    labelColor: Color = Color.Black,
    backgroundColor: Color = Color.White
) {

    Box(
        modifier = Modifier
            .padding(8.dp)
            .height(180.dp)
            .width(344.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(5.dp)
            )
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                modifier = Modifier,
                fontStyle = FontStyle(mainFont),
                fontSize = 16.sp,
                color = secUn,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row() {
                Column() {
                    Canvas(modifier = Modifier
                        .width(16.dp)
                        .height(120.dp),
                        onDraw = {
                            val maxBarHeight = data.values.maxOf { it }
                            val barScale = size.height / (maxBarHeight + 1)
                            val paint = Paint().apply {
                                this.color = labelColor.toArgb()
                                textAlign = Paint.Align.CENTER
                                textSize = 25f
                            }

                            var i: Int = 2
                            while (size.height - i * barScale > 0) {
                                drawContext.canvas.nativeCanvas.drawText(
                                    i.toString()+" HR",
                                    0f,
                                    size.height - i * barScale + 12f,
                                    paint
                                )
                                i += 2
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
                Column(
                    modifier = Modifier
                ) {
                    Canvas(modifier = Modifier
                        .height(120.dp)
                        .width(280.dp)
                        .alpha(9f)
                        .padding(0.dp)
                        .border(
                            BorderStroke(2.dp, secUn)
                        ),
                        onDraw = {
                            val spaceBetweenBars =
                                (size.width - (data.size * barWidth)) / (data.size + 1)
                            val maxBarHeight = data.values.maxOf { it }
                            val barScale = size.height / (maxBarHeight + 1)

                            var spaceStep = spaceBetweenBars
                            var i: Int = 2
                            while (size.height - i * barScale > 0) {
                                drawLine(
                                    start = Offset(
                                        x = 0f,
                                        y = size.height - i * barScale
                                    ),
                                    end = Offset(
                                        x = size.width,
                                        y = size.height - i * barScale
                                    ),
                                    strokeWidth = 1.dp.toPx(),
                                    color = secUn,
                                    alpha = 0.5f
                                )

                                i += 2
                            }

                            for (item in data) {
                                val topLeft = Offset(
                                    x = spaceStep,
                                    y = size.height - item.value * barScale
                                )
                                //--------------------(draw bars)--------------------//
                                drawRoundRect(
                                    color = barColor,
                                    topLeft = topLeft,
                                    size = Size(
                                        width = barWidth,
                                        height = size.height - topLeft.y
                                    ),
                                    alpha = 0.85f
                                )


                                spaceStep += spaceBetweenBars + barWidth
                            }
                        }
                    )
                    Canvas(modifier = Modifier
                        .height(12.dp)
                        .width(280.dp)
                        .padding(0.dp),
                        onDraw = {
                            val spaceBetweenBars =
                                (size.width - (data.size * barWidth)) / (data.size + 1)
                            val paint = Paint().apply {
                                this.color = labelColor.toArgb()
                                textAlign = Paint.Align.CENTER
                                textSize = 30f
                            }

                            var spaceStep = spaceBetweenBars

                            for (item in data) {
                                //--------------------(showing the x axis labels)--------------------//
                                drawContext.canvas.nativeCanvas.drawText(
                                    item.key.toString(),
                                    spaceStep + barWidth / 2,
                                    size.height,
                                    paint
                                )
                                spaceStep += spaceBetweenBars + barWidth
                            }
                        }
                    )
                }
            }
        }
    }
}