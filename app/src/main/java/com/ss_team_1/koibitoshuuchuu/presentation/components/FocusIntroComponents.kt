@file:OptIn(
    ExperimentalFoundationApi::class,
    ExperimentalComposeUiApi::class,
    ExperimentalSnapperApi::class
)

package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.domain.model.Scene
import com.ss_team_1.koibitoshuuchuu.presentation.sceneNameList
import com.ss_team_1.koibitoshuuchuu.presentation.utils.OutlinedText
import com.ss_team_1.koibitoshuuchuu.presentation.utils.convertDpToPixel
import com.ss_team_1.koibitoshuuchuu.ui.theme.*
import dev.chrisbanes.snapper.*

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
            .size(width = 280.dp, height = 308.dp)
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
    var openState by remember{ mutableStateOf(false)}
    FocusIntroTimePickerButton(
        lazyListState = rememberLazyListState(),
        layoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState = rememberLazyListState()),
        focusTime = 10,
        setFocusTime = {},
        onClick = {openState = true},
        onDone = {openState = false},
        timePickerOpenState = openState
    )
}

@Composable
fun FocusIntroTimePickerButton(
    timePickerOpenState: Boolean,
    onClick: () -> Unit,
    onDone: () -> Unit,
    lazyListState: LazyListState,
    layoutInfo: LazyListSnapperLayoutInfo,
    focusTime: Int,
    setFocusTime: () -> Unit
) {
    val height by animateDpAsState(targetValue = if (timePickerOpenState) 308.dp else 64.dp)
    var scrollState by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(scrollState, focusTime) {
        if (scrollState) {
            lazyListState.scrollToItem(focusTimeList.indexOf(focusTime))
            scrollState = false
        }
    }
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
            modifier = Modifier.size(width = 280.dp, height = height),
            onClick = {
                if (timePickerOpenState) {
                    onDone()
                } else {
                    scrollState = true
                    onClick()
                }
            },
            shape = RoundedCornerShape(17.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Primary.copy(alpha = 0.7f)
            ),
            border = BorderStroke(width = 3.dp, color = Secondary)
        ) {
            if (!timePickerOpenState) {
                Text(text = "$focusTime:00", fontSize = 36.sp, fontFamily = mamelonFamily)
            } else {
                //FocusIntroTimePicker(lazyListState = lazyListState, layoutInfo = layoutInfo)
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    contentPadding = PaddingValues(vertical = 125.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    state = lazyListState,
                    flingBehavior = rememberSnapperFlingBehavior(
                        lazyListState = lazyListState,
                        endContentPadding = 125.dp,
                        snapOffsetForItem = SnapOffsets.Start
                    )
                ) {
                    itemsIndexed(items = focusTimeList) { index, item ->
                        val color =
                            if (layoutInfo.currentItem?.index == index) Color.Black else Color.Gray
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
//        if (openState) {
//            Popup(
//                alignment = Alignment.Center,
//                onDismissRequest = {
//                    openState = false
//                    setFocusTime()
//                },
//                properties = PopupProperties()
//            ) {
//                FocusIntroTimePicker(lazyListState = lazyListState, layoutInfo = layoutInfo)
//            }
//        }
    }
}

//@Preview
//@Composable
//private fun FocusIntroWorkTextFieldPreview() {
//    FocusIntroWorkTextField(
//        workDesc = "Homework",
//        onValueChange = {},
//        FocusRequester(),
//        LocalFocusManager.current
//    )
//}

@Composable
fun FocusIntroWorkTextField(
    workOpenState: Boolean,
    onPress: () -> Unit,
    onDone: KeyboardActionScope.() -> Unit,
    workDesc: String,
    onValueChange: (String) -> Unit,
    focusRequester: FocusRequester,
    focusManager: FocusManager
) {
    val height by animateDpAsState(targetValue = if (workOpenState) 300.dp else 64.dp)
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed: Boolean by interactionSource.collectIsPressedAsState()
    if (isPressed) {
        onPress()
    }
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
                .size(width = 280.dp, height = height)
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
                    fontFamily = huninnFamily,
                    lineHeight = 40.sp
                ),
                modifier = Modifier
                    .focusRequester(focusRequester),
                keyboardActions = KeyboardActions(onDone = onDone),
                singleLine = !workOpenState,
                maxLines = 6,
                interactionSource = interactionSource
            )

        }
    }
}

//@Preview
@Composable
fun FocusIntroScenePicker(
    scenePickerOpenState: Boolean,
    onClick: () -> Unit,
    onDone: () -> Unit,
    sceneId: Int,
    sceneList: List<Scene>,
    sceneOnClick: (Int) -> Unit
) {
    val height by animateDpAsState(targetValue = if (scenePickerOpenState) 391.dp else 64.dp)

    Column(
        modifier = Modifier
            .padding(12.dp)
        //.animateContentSize()
    ) {
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
            modifier = Modifier.size(width = 280.dp, height = height),
            onClick = {
                if (scenePickerOpenState) {
                    onDone()
                } else {
                    onClick()
                }
            },
            shape = RoundedCornerShape(17.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Primary.copy(
                    alpha = 0.7f
                )
            ),
            border = BorderStroke(width = 3.dp, color = Secondary)
        ) {
            if (!scenePickerOpenState) {
                Text(
                    text = stringResource(id = sceneNameList[sceneId]),
                    fontSize = 36.sp,
                    fontFamily = huninnFamily
                )
            } else {
                LazyVerticalGrid(
                    cells = GridCells.Fixed(3),
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .align(Alignment.Top)
                ) {
                    items(sceneList) { item ->
                        Image(
                            painter = painterResource(id = com.ss_team_1.koibitoshuuchuu.presentation.sceneIdList[item.id]),
                            contentDescription = "scene",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .size(61.dp, 106.dp)
                                .padding(4.dp)
                                .clickable {
                                    sceneOnClick(item.id)
                                    onDone()
                                }
                        )
                    }

                }
            }

        }

        //val offset by animateDpAsState(targetValue = if (openState) (-300).dp else 0.dp)
//        if (false) {
//            Popup(
//                alignment = Alignment.TopCenter,
//                onDismissRequest = { openState = false }
//            ) {
//                Surface(
//                    shape = RoundedCornerShape(15.dp),
//                    color = Primary,
//                    border = BorderStroke(width = 6.dp, color = Secondary),
//                    modifier = Modifier
//                        .width(280.dp)
//                        .height(height)
//                ) {
//
//
//                }
//
//            }
//        }
    }
}
