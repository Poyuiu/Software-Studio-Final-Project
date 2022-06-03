package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.ui.theme.Primary
import com.ss_team_1.koibitoshuuchuu.ui.theme.Secondary


@Composable
private fun FocusIntroComponents() {

}

@Preview
@Composable
fun FocusIntroTimepickerButton(
) {
    var focusTime by remember { mutableStateOf(10) }
    Column(modifier = Modifier.padding(12.dp)) {
        Text(text = "Focus Time")
        Button(
            modifier = Modifier.size(width = 280.dp, height = 64.dp),
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(17.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Primary.copy(alpha = 0.7f)
            ),
            border = BorderStroke(width = 3.dp, color = Secondary)
        ) {
            Text(text = "$focusTime:00")
        }
    }
}

@Preview
@Composable
fun FocusIntroWorkTextField(
) {
    var workDesc by remember { mutableStateOf("homework") }
    Column(modifier = Modifier.padding(12.dp)) {
        Text(text = "Work(optional)")
        Box(
            modifier = Modifier
                .size(width = 280.dp, height = 64.dp)
                //.clip(RoundedCornerShape(17.dp))
                .background(color = Primary.copy(alpha = 0.7f), shape = RoundedCornerShape(17.dp))
                .border(width = 3.dp, color = Secondary, shape = RoundedCornerShape(17.dp)),
            contentAlignment = Alignment.Center
        ) {
            BasicTextField(
                value = workDesc,
                onValueChange = { workDesc = it },
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
            )

        }
    }
}

@Preview
@Composable
fun FocusIntroSceneButton(
) {
    var sceneName by remember { mutableStateOf("咖啡廳") }
    Column(modifier = Modifier.padding(12.dp)) {
        Text(text = "Scene")
        Button(
            modifier = Modifier.size(width = 280.dp, height = 64.dp),
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(17.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Primary.copy(alpha = 0.7f)
            ),
            border = BorderStroke(width = 3.dp, color = Secondary)
        ) {
            Text(text = sceneName)
        }
    }
}
