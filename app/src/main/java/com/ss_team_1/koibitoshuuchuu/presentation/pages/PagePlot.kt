package com.ss_team_1.koibitoshuuchuu.presentation.components

import android.util.LogPrinter
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.utils.CharacterInfoAndPlotStorer
import com.ss_team_1.koibitoshuuchuu.presentation.utils.PlotSnapShot
import com.ss_team_1.koibitoshuuchuu.presentation.utils.coloredShadow
import com.ss_team_1.koibitoshuuchuu.ui.theme.*

/*
STILL NOT COMPLETE!!!!!!!!!!!!!!!!!!!!
 */

@Composable
fun PagePlot(
    @DrawableRes backGround: Int,
    plotContent: List<PlotSnapShot>,
    auto: Boolean,
) {

    var plotSnapShotState by remember {
        mutableStateOf(0)
    }
    ///////THIS DOSE NOT MOVE, I DON't KNOW WHY QQ

    Box(
        Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = backGround),
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
                    PauseButton()
                else
                    ForwardButton()
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
                    text = stringResource(id = plotContent[plotSnapShotState].plotDiscription),
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
        backGround = R.drawable.background_only_color,
        plotContent = CharacterInfoAndPlotStorer.character[0].plotList[0].plotContent,
        auto = false
    )
}