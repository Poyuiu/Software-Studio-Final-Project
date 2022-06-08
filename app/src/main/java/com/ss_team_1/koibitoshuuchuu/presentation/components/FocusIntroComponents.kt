@file:OptIn(
    ExperimentalFoundationApi::class,
    ExperimentalComposeUiApi::class,
    ExperimentalSnapperApi::class
)

package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.ss_team_1.koibitoshuuchuu.ui.theme.Primary
import com.ss_team_1.koibitoshuuchuu.ui.theme.Secondary
import com.ss_team_1.koibitoshuuchuu.ui.theme.huninnFamily
import com.ss_team_1.koibitoshuuchuu.ui.theme.mamelonFamily
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior


@Preview(showBackground = false)
@Composable
private fun FocusIntroTimePickerPreview() {
    FocusIntroTimePicker()
}

@Composable
fun FocusIntroTimePicker(
) {
    //TODO: Should be input
    val focusTimeList = (50 downTo 10 step 5).toList()
    val lazyListState = rememberLazyListState()

    Surface(
        shape = RoundedCornerShape(17.dp),
        color = Primary,
        border = BorderStroke(width = 3.dp, color = Secondary),
        modifier = Modifier.size(width = 279.dp, height = 308.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            flingBehavior = rememberSnapperFlingBehavior(lazyListState)
        ) {
            items(items = focusTimeList) { item ->
                Text(text = "$item:00", fontSize = 36.sp, fontFamily = mamelonFamily)
            }
        }
    }

}

@Preview
@Composable
private fun FocusIntroTimePickerButtonPreview() {
    FocusIntroTimePickerButton()
}

@Composable
fun FocusIntroTimePickerButton(
) {
    var openState by remember { mutableStateOf(false) }
    var focusTime by remember { mutableStateOf(10) }
    Column(modifier = Modifier.padding(12.dp)) {
        Text(text = "Focus Time")
        Button(
            modifier = Modifier.size(width = 280.dp, height = 64.dp),
            onClick = { openState = true },
            shape = RoundedCornerShape(17.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Primary.copy(alpha = 0.7f)
            ),
            border = BorderStroke(width = 3.dp, color = Secondary)
        ) {
            Text(text = "$focusTime:00", fontSize = 36.sp, fontFamily = mamelonFamily)
        }
        if (openState) {
            Popup(
                alignment = Alignment.Center,
                onDismissRequest = { openState = false },
                properties = PopupProperties()
            ) {
                FocusIntroTimePicker()
            }
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
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 36.sp,
                    fontFamily = huninnFamily
                )
            )

        }
    }
}

@Preview
@Composable
fun FocusIntroScenePicker(
) {
    var openState by remember { mutableStateOf(false)}
    var sceneName by remember { mutableStateOf("咖啡廳") }
    Column(modifier = Modifier.padding(12.dp)) {
        Text(text = "Scene")
        Button(
            modifier = Modifier.size(width = 280.dp, height = 64.dp),
            onClick = { openState = true},
            shape = RoundedCornerShape(17.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Primary.copy(alpha = 0.7f)
            ),
            border = BorderStroke(width = 3.dp, color = Secondary)
        ) {
            Text(text = sceneName, fontSize = 36.sp, fontFamily = huninnFamily)
        }
        if (openState){
            Popup(
                alignment = Alignment.BottomCenter,
                onDismissRequest = {openState = false}
            ) {
                Surface(
                    shape = RoundedCornerShape(15.dp),
                    color = Primary,
                    border = BorderStroke(width = 6.dp, color = Secondary),
                    modifier = Modifier.size(width = 275.dp, height = 391.dp)
                ) {

                }
            }
        }
    }
}
