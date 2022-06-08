package com.ss_team_1.koibitoshuuchuu.presentation.experiment

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import kotlin.math.exp

@Preview
@Composable
fun PopUpTest() {
    val expandState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        Column() {
            Button(
                onClick = {
                    expandState.value = true
                }) {
                Text(text = "打开 DropdownMenu")
            }
            if(expandState.value){
                Popup(
                    alignment = Alignment.TopStart,
                    onDismissRequest = {
                        Log.e("ccm", "执行了onDismissRequest")
                        expandState.value = false
                    },
                    offset = IntOffset(10, 140),
                ) {
                    Column(
                        modifier = Modifier
                            .width(IntrinsicSize.Min)
                            .shadow(
                                elevation = 2.dp, shape = RoundedCornerShape(3.dp)
                            )
                            .background(Color.White, shape = RoundedCornerShape(3.dp))
                    ) {
                        dropdownMenuItemTest(expandState, Icons.Filled.Favorite, "收藏")
                        dropdownMenuItemTest(expandState, Icons.Filled.Edit, "编辑")
                        dropdownMenuItemTest(expandState, Icons.Filled.Delete, "删除")
                    }
                }
            }

        }
    }
}

@Composable
fun dropdownMenuItemTest(state: MutableState<Boolean>, icon: ImageVector, text: String) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressState = interactionSource.collectIsPressedAsState()
    val focusState = interactionSource.collectIsFocusedAsState()
    DropdownMenuItem(
        onClick = {
            state.value = false
        },
        enabled = true,
        interactionSource = interactionSource
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = if (pressState.value || focusState.value) Color.Red else Color.Black
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 10.dp),
            color = if (pressState.value || focusState.value) Color.Red else Color.Black
        )
    }
}
