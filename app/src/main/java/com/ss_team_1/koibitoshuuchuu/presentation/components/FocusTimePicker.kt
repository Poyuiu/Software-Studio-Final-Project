package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import com.chargemap.compose.numberpicker.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.ss_team_1.koibitoshuuchuu.ui.theme.Primary

@Preview(showBackground = false)
@Composable
fun FocusTimePicker() {
    var state by remember { mutableStateOf<Hours>(FullHours(11, 36)) }
    val possibleValues = (50 downTo 5 step 5).toList()
    var value by remember { mutableStateOf(possibleValues.last()) }
        Box(
            modifier = Modifier
                .background(color = Primary)
                .size(width = 280.dp, height = 310.dp)

            ) {


            ListItemPicker(
                label = { it.toString() },
                value = value,
                onValueChange = { value = it },
                list = possibleValues,
                textStyle = TextStyle(Color.Black)
            )
        }

}