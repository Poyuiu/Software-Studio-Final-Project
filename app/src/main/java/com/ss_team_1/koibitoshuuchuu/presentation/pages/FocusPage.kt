package com.ss_team_1.koibitoshuuchuu.presentation.pages

import android.media.MediaPlayer
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.Page
import com.ss_team_1.koibitoshuuchuu.presentation.components.*
import com.ss_team_1.koibitoshuuchuu.presentation.utils.focusTimeFormatter
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.CharacterViewModel
import com.ss_team_1.koibitoshuuchuu.ui.theme.*
import kotlinx.coroutines.delay
import androidx.hilt.navigation.compose.hiltViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.characterphotolist
import com.ss_team_1.koibitoshuuchuu.presentation.event.CharacterEvent
import com.ss_team_1.koibitoshuuchuu.presentation.event.UserEvent
import com.ss_team_1.koibitoshuuchuu.presentation.sceneIdList
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.LastFocusSettingViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.UserViewModel

//@Preview
//@Composable
//private fun FocusPagePreview() {
//    FocusPage(navController = NavController(LocalContext.current), focusTime = 15, characterId = 0)
//}

@Composable
fun FocusPage(
    navController: NavController,
    focusTime: Int?,
    characterId: Int?,
    mediaPlayer: MediaPlayer,
    viewModel: CharacterViewModel = hiltViewModel(),
    userViewModel: UserViewModel = hiltViewModel(),
    focusSettingViewModel: LastFocusSettingViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val sceneId = focusSettingViewModel.state.value.lastFocusSetting.sceneId

    var pauseState by remember { mutableStateOf(false) }
    var focusSuccess by remember {
        mutableStateOf(true)
    }
    var focusEnd by remember {
        mutableStateOf(false)
    }
    var remainTime by remember {
        mutableStateOf(focusTime?.times(60000L) ?: 0L)
    }
    var intimacyChange by remember {
        mutableStateOf(0)
    }
    var moneyChange by remember {
        mutableStateOf(0)
    }

    val dialogText = if (!focusEnd) {
        "快點專心！我可沒法整天在這裡看著你"
    } else if (focusSuccess) {
        "還不錯嘛！接下來也繼續加油哦！"
    } else {
        "不專心可是有罪的哦..."
    }
    // Countdown Timer
    LaunchedEffect(remainTime, pauseState) {
        if (remainTime > 0 && !pauseState && !focusEnd) {
            // TODO: set back to 100/100
            delay(10L)
            remainTime -= 6000L
            if (remainTime <= 0) {
                focusEnd = true
                intimacyChange = 9872
                viewModel.onEvent(CharacterEvent.UpdateIntimacy(characterId!!, intimacyChange))
                moneyChange = 674
                userViewModel.onEvent(UserEvent.UpdateMoney(moneyChange))
                mediaPlayer.pause()
            }
        }
    }
    // Back Handlers
    BackHandler(!focusEnd && !pauseState) {
        pauseState = true
    }


    KBSCScaffold(
        navController = navController,
        backgroundResourceId = sceneIdList[sceneId],
        navbarEnable = false,
        topBarEnable = false
    ) {
        // Character Image
        Image(
            painter = painterResource(id = characterphotolist[characterId!!]),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize(0.84f)
                .align(Alignment.Center)
                .padding(top = 10.dp),
            contentScale = ContentScale.Fit
        )

        if (!focusEnd) {
            PauseButton(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp),
                onClick = { pauseState = true }
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Heart_initamcybar(
                modifier = Modifier.offset(y = 40.dp),
                intimacyLevel = state.characters[characterId].level,
                intimacy = state.characters[characterId].intimacy,
                levelIntimacyNeed = state.characters[characterId].intimacyNeeded(),
            )
            DialogBox(
                text = dialogText,
                showTriangle = false,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .offset(y = 58.dp)
            )

            if (!focusEnd) {
                FocusTimer(
                    modifier = Modifier.offset(y = (-137).dp),
                    text = focusTimeFormatter(remainTime)
                )
            } else {
                Column(
                    modifier = Modifier
                        .offset(y = (-48).dp)
                        .width(323.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ResourceBox(intimacyChange, moneyChange)
                    Spacer(modifier = Modifier.height(27.dp))
                    if (focusSuccess) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            SquareHomeButton(onClick = {
                                navController.navigate(Page.Home.route) {
                                    popUpTo(Page.Home.route) { inclusive = true }
                                }
                            })
                            // Next Round Button
                            AccentButtonTemplate(
                                onClick = {
                                    navController.popBackStack()
                                },
                                width = 260.dp, height = 58.dp
                            ) {
                                Text(
                                    text = "NEXT ROUND",
                                    fontSize = 30.sp,
                                    fontFamily = mamelonFamily,
                                    letterSpacing = (-1.5).sp
                                )
                            }
                        }
                    } else {
                        AccentButtonTemplate(
                            onClick = {
                                navController.navigate(Page.Home.route) {
                                    popUpTo(Page.Home.route) { inclusive = true }
                                }
                            }, width = 255.dp, height = 58.dp
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Home,
                                contentDescription = "Home",
                                modifier = Modifier
                                    .size(40.dp)
                            )
                        }
                    }

                }
            }

        }
        if (pauseState) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black.copy(alpha = 0.4f))
                    .zIndex(4f)
            )
            {
                Popup(
                    alignment = Alignment.Center,
                    onDismissRequest = { pauseState = false },
                    properties = PopupProperties(focusable = true, dismissOnClickOutside = false)
                ) {
                    androidx.compose.material.Surface(
                        modifier = Modifier
                            .size(
                                width = 280.dp,
                                height = 230.dp
                            )
                            .zIndex(8f),
                        shape = RoundedCornerShape(10.dp),
                        color = Primary,
                        border = BorderStroke(width = 3.dp, color = Secondary)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(24.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        )
                        {
                            Text(text = "真的要丟下她一個人嗎？", fontSize = 32.sp, fontFamily = huninnFamily)
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button(onClick = {
                                    pauseState = false
                                    focusSuccess = false
                                    focusEnd = true
                                    intimacyChange = -100
                                    mediaPlayer.pause()
                                    viewModel.onEvent(
                                        CharacterEvent.UpdateIntimacy(
                                            characterId,
                                            intimacyChange
                                        )
                                    )
                                }) {
                                    Text(text = "是", fontFamily = huninnFamily)
                                }
                                Button(
                                    onClick = {
                                        pauseState = false
                                    },
                                    colors = ButtonDefaults.buttonColors(backgroundColor = AccentColor)
                                ) {
                                    Text(text = "否", fontFamily = huninnFamily)
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}

@Composable
private fun FocusTimer(
    modifier: Modifier = Modifier,
    text: String
) {
    Box(
        modifier = modifier
            .size(width = 276.dp, height = 100.dp)
            .background(Primary.copy(alpha = 0.7f), RoundedCornerShape(17.dp))
            .border(6.dp, AccentColor, RoundedCornerShape(17.dp)),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 64.sp,
            fontFamily = mamelonFamily
        )
    }
}
