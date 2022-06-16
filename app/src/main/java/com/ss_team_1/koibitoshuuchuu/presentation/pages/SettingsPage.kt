package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.components.BackButton
import com.ss_team_1.koibitoshuuchuu.presentation.components.RoundButtonTemplate
import com.ss_team_1.koibitoshuuchuu.presentation.components.TopBar
import com.ss_team_1.koibitoshuuchuu.presentation.event.SettingEvent
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.SettingViewModel
import com.ss_team_1.koibitoshuuchuu.ui.theme.AccentColor
import com.ss_team_1.koibitoshuuchuu.ui.theme.mamelonFamily

@Composable
fun SettingsPage(
    navController: NavController,
    viewModel: SettingViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    var sfxVolume by remember { mutableStateOf(state.setting.soundEffectVolume) }
    var bgmVolume by remember { mutableStateOf(state.setting.bgmVolume) }
    if (sfxVolume == 0) sfxVolume = state.setting.soundEffectVolume
    if (bgmVolume == 0) bgmVolume = state.setting.bgmVolume

    Box(
        Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_only_color),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        TopBar(button1 = { BackButton(navController) })
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "",
                    modifier = Modifier.size(144.dp)
                )
                Spacer(modifier = Modifier.width(64.dp))
                Image(
                    painter = painterResource(id = R.drawable.settings_text),
                    contentDescription = "",
                    modifier = Modifier.size(80.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_sfx),
                        contentDescription = "",
                        modifier = Modifier.size((48.dp))
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_bgm),
                        contentDescription = "",
                        modifier = Modifier.size((48.dp))
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_screen),
                        contentDescription = "",
                        modifier = Modifier.size((48.dp))
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_restricted),
                        contentDescription = "",
                        modifier = Modifier.size((48.dp))
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_langauge),
                        contentDescription = "",
                        modifier = Modifier.size((48.dp))
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sfx_text),
                        contentDescription = "",
                        modifier = Modifier
                            .height((48.dp))
                            .width(48.dp)
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.bgm_text),
                        contentDescription = "",
                        modifier = Modifier
                            .height((48.dp))
                            .width(96.dp)
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.screen_on_text),
                        contentDescription = "",
                        modifier = Modifier
                            .height((48.dp))
                            .width(96.dp)
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.restricted_text),
                        contentDescription = "",
                        modifier = Modifier
                            .height((48.dp))
                            .width(96.dp)
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.langauge_text),
                        contentDescription = "",
                        modifier = Modifier.size((48.dp))
                    )

                }
                Spacer(modifier = Modifier.width(64.dp))
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_drag_bar_line),
                            contentDescription = "",
                            modifier = Modifier
                                .width(50.dp)
                                .height(48.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_drag_bar_dot),
                            contentDescription = "",
                            modifier = Modifier
                                .size((16.dp))
                                .offset { IntOffset(sfxVolume, 0) }
                                .draggable(
                                    orientation = Orientation.Horizontal,
                                    state = rememberDraggableState { delta ->
                                        var newVolume = sfxVolume + delta.toInt()
                                        if (newVolume > 50) newVolume = 50
                                        else if (newVolume < -50) newVolume = -50
                                        viewModel.onEvent(
                                            SettingEvent.SetSoundEffectVolume(newVolume)
                                        )
                                        sfxVolume = newVolume
                                    }
                                )
                        )
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Box(contentAlignment = Alignment.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_drag_bar_line),
                            contentDescription = "",
                            modifier = Modifier
                                .width(50.dp)
                                .height(48.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_drag_bar_dot),
                            contentDescription = "",
                            modifier = Modifier
                                .size((16.dp))
                                .offset { IntOffset(bgmVolume, 0) }
                                .draggable(
                                    orientation = Orientation.Horizontal,
                                    state = rememberDraggableState { delta ->
                                        var newVolume = bgmVolume + delta.toInt()
                                        if (newVolume > 50) newVolume = 50
                                        else if (newVolume < -50) newVolume = -50
                                        viewModel.onEvent(
                                            SettingEvent.SetBGMVolume(newVolume)
                                        )
                                        bgmVolume = newVolume
                                    }
                                )
                        )
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = if (state.setting.keepScreenOpen) R.drawable.ic_on_switch else R.drawable.ic_off_switch),
                        contentDescription = "",
                        modifier = Modifier
                            .width(48.dp)
                            .height(48.dp)
                            .clickable { viewModel.onEvent(SettingEvent.SetKeepScreenOpen(!state.setting.keepScreenOpen)) }
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = if (state.setting.restrictedMode) R.drawable.ic_on_switch else R.drawable.ic_off_switch),
                        contentDescription = "",
                        modifier = Modifier
                            .width(48.dp)
                            .height(48.dp)
                            .clickable { viewModel.onEvent(SettingEvent.SetRestrictedMode(!state.setting.restrictedMode)) }
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    DropDown(viewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropDown(viewModel: SettingViewModel) {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("中文", "English", "日本語")
    val disabledValue = listOf("English", "日本語")
    var selectedIndex by remember { mutableStateOf(0) }
    selectedIndex = viewModel.state.value.setting.language

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = Modifier
            .width(96.dp)
            .height(48.dp)
            .border(width = 2.dp, brush = Brush.horizontalGradient(listOf(Color.Black, Color.Black)), shape = RectangleShape)
            .background(AccentColor)
    ) {
        TextField(
            readOnly = true,
            value = items[selectedIndex],
            onValueChange = { },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            textStyle = LocalTextStyle.current.copy(
                fontSize = MaterialTheme.typography.body2.fontSize,
                fontFamily = mamelonFamily,
                color = Color.Black
            ),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
            modifier = Modifier
                .border(width = 2.dp, brush = Brush.horizontalGradient(listOf(Color.Black, Color.Black)), shape = RectangleShape)
                .background(Color.White)
        ) {
            items.forEachIndexed { index, selectionOption ->
                val isDisabled = disabledValue.contains(selectionOption)
                DropdownMenuItem(
                    onClick = {
                        if (!isDisabled) viewModel.onEvent(SettingEvent.SetLanguage(index))
                        selectedIndex = if (isDisabled) selectedIndex else index
                        expanded = isDisabled
                    }
                ) {
                    Text(
                        text = selectionOption,
                        fontSize = MaterialTheme.typography.body2.fontSize,
                        fontFamily = mamelonFamily,
                        color = if (isDisabled)Color.Gray else Color.Black
                    )
                }
            }
        }
    }
}

@Deprecated("old preview")
@Preview
@Composable
fun SettingsPagePreview() {
    var offsetX by remember { mutableStateOf(0f) }
    Box(
        Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_only_color),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        TopBar(button1 = {
            RoundButtonTemplate(
                icon = Icons.Default.ArrowBack,
                iconSize = 36.dp,
                onClick = {}
            )
        })
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "",
                    modifier = Modifier.size(144.dp)
                )
                Spacer(modifier = Modifier.width(64.dp))
                Image(
                    painter = painterResource(id = R.drawable.settings_text),
                    contentDescription = "",
                    modifier = Modifier.size(80.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_sfx),
                        contentDescription = "",
                        modifier = Modifier.size((48.dp))
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_bgm),
                        contentDescription = "",
                        modifier = Modifier.size((48.dp))
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_screen),
                        contentDescription = "",
                        modifier = Modifier.size((48.dp))
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_langauge),
                        contentDescription = "",
                        modifier = Modifier.size((48.dp))
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_restricted),
                        contentDescription = "",
                        modifier = Modifier.size((48.dp))
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sfx_text),
                        contentDescription = "",
                        modifier = Modifier
                            .height((48.dp))
                            .width(48.dp)
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.bgm_text),
                        contentDescription = "",
                        modifier = Modifier
                            .height((48.dp))
                            .width(96.dp)
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.screen_on_text),
                        contentDescription = "",
                        modifier = Modifier
                            .height((48.dp))
                            .width(96.dp)
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.langauge_text),
                        contentDescription = "",
                        modifier = Modifier.size((48.dp))
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.restricted_text),
                        contentDescription = "",
                        modifier = Modifier
                            .height((48.dp))
                            .width(96.dp)
                    )
                }
                Spacer(modifier = Modifier.width(64.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_drag_bar_line),
                            contentDescription = "",
                            modifier = Modifier
                                .width(48.dp)
                                .height(48.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_drag_bar_dot),
                            contentDescription = "",
                            modifier = Modifier
                                .size((16.dp))
                                .offset { IntOffset(-50, 0) }
                                .draggable(
                                    orientation = Orientation.Horizontal,
                                    state = rememberDraggableState { delta ->
                                        offsetX += delta
                                    }
                                )
                        )
                    }
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//
//                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_drag_bar_line),
                            contentDescription = "",
                            modifier = Modifier
                                .width(48.dp)
                                .height(48.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_drag_bar_dot),
                            contentDescription = "",
                            modifier = Modifier.size((16.dp))
                        )
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_drag_bar_line),
                            contentDescription = "",
                            modifier = Modifier
                                .width(48.dp)
                                .height(48.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_drag_bar_dot),
                            contentDescription = "",
                            modifier = Modifier.size((16.dp))
                        )
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_drag_bar_line),
                            contentDescription = "",
                            modifier = Modifier
                                .width(48.dp)
                                .height(48.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_drag_bar_dot),
                            contentDescription = "",
                            modifier = Modifier.size((16.dp))
                        )
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_drag_bar_line),
                            contentDescription = "",
                            modifier = Modifier
                                .width(48.dp)
                                .height(48.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_drag_bar_dot),
                            contentDescription = "",
                            modifier = Modifier.size((16.dp))
                        )
                    }
                }
            }
        }
    }
}
