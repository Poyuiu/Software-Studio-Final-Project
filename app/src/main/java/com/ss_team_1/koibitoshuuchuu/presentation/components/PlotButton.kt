package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.ui.theme.black
import com.ss_team_1.koibitoshuuchuu.ui.theme.gray
import com.ss_team_1.koibitoshuuchuu.ui.theme.grayLine
import com.ss_team_1.koibitoshuuchuu.ui.theme.secUn
import com.ss_team_1.koibitoshuuchuu.R

@Composable
fun PlotButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    lock: Boolean,
    haveRead: Boolean,
    id: Int,
    title: String
) {
    Box {
        Button(
            modifier = modifier
                .width(245.dp)
                .height(47.dp)
                .padding(4.dp),
            onClick = onClick,
            enabled = !lock,
            colors = buttonColors(
                backgroundColor = secUn,
                contentColor = black,
                disabledBackgroundColor = gray,
                disabledContentColor = black
            ),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(
                width = 2.dp,
                brush = Brush.horizontalGradient(
                    listOf(grayLine, grayLine, grayLine),
                    startX = 10.0f,
                    endX = 20.0f
                )
            )
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                if (lock) {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        modifier = modifier
                            .size(25.dp)
                            .align(Alignment.Center)
                    )
                }else{
                    Text(
                        text = "$id. $title",
                        modifier = modifier
                            .width(158.dp)
                            .size(24.dp),
                        textAlign = TextAlign.Start,
                        fontStyle = FontStyle(R.font.mamelon)
                    )
                }
            }
        }
        if(!lock && !haveRead) {
            Image(
                painter = painterResource(R.drawable.new_plot),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .rotate(20.0F)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun PlotButtonPreview() {
    PlotButton(
        onClick = {},
        lock = false,
        //lock = false,
        haveRead = false,
        id = 7,
        title = "標題範例"
    )
}