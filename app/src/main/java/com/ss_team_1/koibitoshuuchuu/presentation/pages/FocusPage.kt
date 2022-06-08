package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.components.DialogBox
import com.ss_team_1.koibitoshuuchuu.presentation.components.Heart_initamcybar
import com.ss_team_1.koibitoshuuchuu.presentation.components.KBSCScaffold
import com.ss_team_1.koibitoshuuchuu.presentation.components.PauseButton
import com.ss_team_1.koibitoshuuchuu.ui.theme.AccentColor
import com.ss_team_1.koibitoshuuchuu.ui.theme.Primary
import com.ss_team_1.koibitoshuuchuu.ui.theme.huninnFamily
import com.ss_team_1.koibitoshuuchuu.ui.theme.mamelonFamily

@Preview

@Composable
fun FocusPage() {
    var pauseState by remember { mutableStateOf(false) }
    var focusSuccess by remember {
        mutableStateOf(true)
    }
    var focusEnd by remember {
        mutableStateOf(false)
    }
    KBSCScaffold(
        backgroundResourceId = R.drawable.coffee_shop_background,
        navbarEnable = false,
        topBarEnable = false
    ) {
        Image(
            painter = painterResource(id = R.drawable.shikieiki_main),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize(0.84f)
                .align(Alignment.Center)
                .padding(top = 10.dp),
            contentScale = ContentScale.Fit
        )
        PauseButton(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp),
            onClick = { pauseState = true }
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Heart_initamcybar(
                modifier = Modifier.offset(y = 40.dp),
                intimacyLevel = 1,
                intimacy = 50,
                levelIntimacyNeed = 50,
                showPercentage = false
            )

            DialogBox(
                text = "快點專心！我可沒法整天在這裡看著你",
                showTriangle = false,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .offset(y = 58.dp)
            )
            FocusTimer(modifier = Modifier.offset(y = (-137).dp))
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
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(width = 276.dp, height = 100.dp)
            .background(Primary.copy(alpha = 0.7f), RoundedCornerShape(17.dp))
            .border(6.dp, AccentColor, RoundedCornerShape(17.dp)),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = "00:10",
            textAlign = TextAlign.Center,
            fontSize = 64.sp,
            fontFamily = mamelonFamily
        )
    }
}
