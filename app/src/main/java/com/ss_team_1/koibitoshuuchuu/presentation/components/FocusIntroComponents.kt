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
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.utils.OutlinedText
import com.ss_team_1.koibitoshuuchuu.ui.theme.*
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.LazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberLazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

//TODO: Should be input
val focusTimeList = (50 downTo 10 step 5).toList()

@Preview(showBackground = false)
@Composable
private fun FocusIntroTimePickerPreview() {
    FocusIntroTimePicker(
        lazyListState = rememberLazyListState(),
        rememberLazyListSnapperLayoutInfo(lazyListState = rememberLazyListState())
    )
}


@Composable
fun FocusIntroTimePicker(
    lazyListState: LazyListState,
    layoutInfo: LazyListSnapperLayoutInfo
) {
    Surface(
        shape = RoundedCornerShape(17.dp),
        color = Primary,
        border = BorderStroke(width = 3.dp, color = Secondary),
        modifier = Modifier
            .size(width = 279.dp, height = 308.dp)
    ) {
        //Text(text = "${layoutInfo.currentItem?.index}", modifier = Modifier.padding(10.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            contentPadding = PaddingValues(vertical = 108.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            state = lazyListState,
            flingBehavior = rememberSnapperFlingBehavior(
                lazyListState = lazyListState,
                endContentPadding = 108.dp
            )
        ) {
            itemsIndexed(items = focusTimeList) { index, item ->
                val color = if (layoutInfo.currentItem?.index == index) Color.Black else Color.Gray
                Text(
                    text = "$item:00",
                    fontSize = 36.sp,
                    fontFamily = mamelonFamily,
                    color = color
                )
            }
        }
    }

}

@Preview
@Composable
private fun FocusIntroTimePickerButtonPreview() {
    FocusIntroTimePickerButton(
        lazyListState = rememberLazyListState(),
        layoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState = rememberLazyListState()),
        focusTime = 10,
        setFocusTime = {}
    )
}

@Composable
fun FocusIntroTimePickerButton(
    lazyListState: LazyListState,
    layoutInfo: LazyListSnapperLayoutInfo,
    focusTime: Int,
    setFocusTime: () -> Unit
) {
    var openState by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(12.dp)) {
        //Text(text = "Focus Time", fontSize = 20.sp, color = Primary, fontFamily = mamelonFamily)
        OutlinedText(
            text = "Focus Time",
            fontSize = 20,
            fontResId = R.font.mamelon,
            textColor = PrimaryValue,
            strokeColor = SecondaryValue,
            strokeWidth = 2
        )
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
                onDismissRequest = {
                    openState = false
                    setFocusTime()
                },
                properties = PopupProperties()
            ) {
                FocusIntroTimePicker(lazyListState = lazyListState, layoutInfo = layoutInfo)
            }
        }
    }
}

@Preview
@Composable
private fun FocusIntroWorkTextFieldPreview()
{
    FocusIntroWorkTextField(workDesc = "Homework", onValueChange = {})
}
@Composable
fun FocusIntroWorkTextField(
    workDesc: String,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = Modifier.padding(12.dp)) {
        //Text(text = "Work(optional)", fontSize = 20.sp, color = Primary, fontFamily = mamelonFamily)
        OutlinedText(
            text = "Work(optional)",
            fontSize = 20,
            fontResId = R.font.mamelon,
            textColor = PrimaryValue,
            strokeColor = SecondaryValue,
            strokeWidth = 2
        )
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
                onValueChange = { onValueChange(it) },
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 36.sp,
                    fontFamily = huninnFamily
                ),
                singleLine = true
            )

        }
    }
}

@Preview
@Composable
fun FocusIntroScenePicker(
) {
    var openState by remember { mutableStateOf(false) }
    var sceneName by remember { mutableStateOf("咖啡廳") }
    Column(modifier = Modifier.padding(12.dp)) {
        OutlinedText(
            text = "Scene",
            fontSize = 20,
            fontResId = R.font.mamelon,
            textColor = PrimaryValue,
            strokeColor = SecondaryValue,
            strokeWidth = 2
        )
        //Text(text = "Scene", fontSize = 20.sp, color = Primary, fontFamily = mamelonFamily)
        Button(
            modifier = Modifier.size(width = 280.dp, height = 64.dp),
            onClick = { openState = true },
            shape = RoundedCornerShape(17.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Primary.copy(alpha = 0.7f)
            ),
            border = BorderStroke(width = 3.dp, color = Secondary)
        ) {
            Text(text = sceneName, fontSize = 36.sp, fontFamily = huninnFamily)
        }
        if (openState) {
            Popup(
                alignment = Alignment.BottomCenter,
                onDismissRequest = { openState = false }
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
