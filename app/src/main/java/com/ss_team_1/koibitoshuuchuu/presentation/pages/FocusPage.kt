package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.Page
import com.ss_team_1.koibitoshuuchuu.presentation.components.*
import com.ss_team_1.koibitoshuuchuu.presentation.utils.FocusTimeFormatter
import com.ss_team_1.koibitoshuuchuu.ui.theme.AccentColor
import com.ss_team_1.koibitoshuuchuu.ui.theme.Primary
import com.ss_team_1.koibitoshuuchuu.ui.theme.huninnFamily
import com.ss_team_1.koibitoshuuchuu.ui.theme.mamelonFamily
import kotlinx.coroutines.delay

@Preview
@Composable
private fun FocusPagePreview() {
    FocusPage(navController = NavController(LocalContext.current), focusTime = 15)
}

@Composable
fun FocusPage(navController: NavController, focusTime: Int?) {
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

    // Countdown Timer
    LaunchedEffect(remainTime, pauseState) {
        if (remainTime > 0 && !pauseState && !focusEnd) {
            delay(100L)
            remainTime -= 100L
            if (remainTime <= 0) focusEnd = true
        }
    }

    KBSCScaffold(
        navController = navController,
        backgroundResourceId = R.drawable.coffee_shop_background,
        navbarEnable = false,
        topBarEnable = false
    ) {
        // Character Image
        Image(
            painter = painterResource(id = R.drawable.character_0_photo_main),
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
                intimacyLevel = 1,
                intimacy = 50,
                levelIntimacyNeed = 50
            )
            DialogBox(
                text = "快點專心！我可沒法整天在這裡看著你",
                showTriangle = false,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .offset(y = 58.dp)
            )

            if (!focusEnd) {
                FocusTimer(
                    modifier = Modifier.offset(y = (-137).dp),
                    text = FocusTimeFormatter(remainTime)
                )
            } else {
                Column(
                    modifier = Modifier
                        .offset(y = (-48).dp)
                        .width(323.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ResourceBox()
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
                                    navController.navigate(Page.FocusIntro.route) {
                                        popUpTo(Page.FocusIntro.route) { inclusive = true }
                                    }
                                },
                                width = 248.dp, height = 58.dp
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
            AlertDialog(onDismissRequest = { pauseState = false },
                shape = RoundedCornerShape(10.dp),
                backgroundColor = Primary,
                text = {
                    Text(text = "真的要丟下她一個人嗎？", fontSize = 32.sp, fontFamily = huninnFamily)
                },
                buttons = {
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Button(onClick = {
                            pauseState = false
                            focusSuccess = false
                            focusEnd = true
                        }) {
                            Text(text = "是", fontFamily = huninnFamily)
                        }
                        Button(onClick = {
                            pauseState = false
                        }) {
                            Text(text = "否", fontFamily = huninnFamily)
                        }
                    }
                })
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
