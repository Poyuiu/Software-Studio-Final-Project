package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.presentation.components.*
import com.ss_team_1.koibitoshuuchuu.presentation.utils.ResourceStorer.Companion.character
import kotlinx.coroutines.delay

/*
STILL NOT COMPLETE!!!!!!!!!!!!!!!!!!!!
 */

@Composable
fun PlotPage(
    plotID: Int,
    characterID: Int,
    onPlotEnd: () -> Unit,
    navController: NavController
) {

    var plotSnapShotState by remember {
        mutableStateOf(0)
    }
    var auto by remember {
        mutableStateOf(false)
    }
    val plotContent = character[characterID].plotList[plotID].plotContent
    val plotContentSize = plotContent.size
    LaunchedEffect(plotSnapShotState, auto) {
        if (auto) {
            if (plotSnapShotState < plotContentSize - 1)
            {
                delay(3000L)
                plotSnapShotState++
            }
            else
                onPlotEnd()
        }
    }
    Box(
        Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = plotContent[plotSnapShotState].backgroundPhoto),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        TopBar(
            button1 = { BackButton(navController) },
            button2 = {
                if (auto)
                    PauseButton(onClick = { auto = false })
                else
                    ForwardButton(onClick = { auto = true })
            }
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .height(680.dp)
                    .width(320.dp)
            ) {

                Image(
                    painter = painterResource(id = plotContent[plotSnapShotState].characterPhoto),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxSize()
                )
                DialogBox(
                    text = stringResource(id = plotContent[plotSnapShotState].plotDescription),
                    showTriangle = !auto,
                    onClickNext = {
                        if (plotSnapShotState < plotContentSize - 1)
                            plotSnapShotState++
                        else
                            onPlotEnd()
                    },
                    fontSize = 18,
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun PagePlotPreview() {
    PlotPage(
        plotID = 0,
        characterID = 0,
        navController = NavController(LocalContext.current),
        onPlotEnd = {}
    )
}