package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.presentation.components.*
import com.ss_team_1.koibitoshuuchuu.presentation.utils.CharacterInfoAndPlotStorer
import com.ss_team_1.koibitoshuuchuu.presentation.utils.PlotSnapShot

/*
STILL NOT COMPLETE!!!!!!!!!!!!!!!!!!!!
 */

@Composable
fun PagePlot(
    plotContent: List<PlotSnapShot>,
) {

    var plotSnapShotState by remember {
        mutableStateOf(0)
    }
    ///////ABOVE DOSE NOT MOVE, I DON't KNOW WHY QQ
    var auto by remember {
        mutableStateOf(false)
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

        //THIS ONLY FOR TEST, CAN BE REMOVE
        Text(
            text = plotSnapShotState.toString(),
            modifier = Modifier.align(Alignment.CenterStart)
        )
        TopBar(
            button1 = { BackButton() },
            button2 = {
                if (auto)
                    PauseButton(onClick = {auto = false})
                else
                    ForwardButton(onClick = {auto = true})
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
                    showTriangle = true,
                    onClickNext = { plotSnapShotState++ },
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun PagePlotPreview() {
    PagePlot(
        plotContent = CharacterInfoAndPlotStorer.character[0].plotList[0].plotContent
    )
}