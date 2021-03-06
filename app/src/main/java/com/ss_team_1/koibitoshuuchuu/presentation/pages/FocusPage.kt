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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.components.*
import com.ss_team_1.koibitoshuuchuu.presentation.utils.focusTimeFormatter
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.CharacterViewModel
import com.ss_team_1.koibitoshuuchuu.ui.theme.*
import kotlinx.coroutines.delay
import androidx.hilt.navigation.compose.hiltViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.*
import com.ss_team_1.koibitoshuuchuu.presentation.event.CharacterEvent
import com.ss_team_1.koibitoshuuchuu.presentation.event.UserEvent
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
    val characterMood = if (!focusEnd) {
        0
    } else if (focusSuccess) {
        1
    } else {
        2
    }
    // Countdown Timer
    LaunchedEffect(remainTime, pauseState) {
        if (remainTime > 0 && !pauseState && !focusEnd) {
            delay(100L)   /**???????????????  delay(10)  **/
            remainTime -= 100L     /**???????????????  remainTime -= 6000  **/
            if (remainTime <= 0) {
                focusEnd = true
                intimacyChange = focusTime?.times(8) ?: 0
                viewModel.onEvent(CharacterEvent.UpdateIntimacy(characterId!!, intimacyChange))
                moneyChange = focusTime?.times(4) ?: 0
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
            painter = painterResource(id = characterFocusPhotoList[characterId!!][characterMood]),
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
                text = stringResource(id = characterFocusDialog[characterId][characterMood]) ,
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
                            Text(text = "?????????????????????????????????", fontSize = 32.sp, fontFamily = huninnFamily)
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
                                    Text(text = "???", fontFamily = huninnFamily)
                                }
                                Button(
                                    onClick = {
                                        pauseState = false
                                    },
                                    colors = ButtonDefaults.buttonColors(backgroundColor = AccentColor)
                                ) {
                                    Text(text = "???", fontFamily = huninnFamily)
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
