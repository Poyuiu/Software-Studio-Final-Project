package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.domain.util.GetPlotLockAndHaveReadState
import com.ss_team_1.koibitoshuuchuu.presentation.components.BackButton
import com.ss_team_1.koibitoshuuchuu.presentation.components.CharacterInfo
import com.ss_team_1.koibitoshuuchuu.presentation.components.PlotList
import com.ss_team_1.koibitoshuuchuu.presentation.components.TopBar
import com.ss_team_1.koibitoshuuchuu.presentation.utils.CharacterInfoAndPlotStorer
import com.ss_team_1.koibitoshuuchuu.presentation.utils.SingleCharacterInfoAndPlotStormer

@Composable
fun PageCharacterInfoAndStory(
    character: SingleCharacterInfoAndPlotStormer,
    onClickGoStory: () -> Unit,
    onClickGoDetail: () -> Unit
) {
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
        TopBar(button1 = { BackButton() })
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            CharacterInfo(
                onClick = onClickGoDetail,
                characterPhoto = character.photo,
                characterName = character.name,
                characterInfo = character.info,
                showDetailButton = true
            )
            Spacer(modifier = Modifier.height(8.dp))
            PlotList(
                onClick = onClickGoStory,
                plotTitleList = GetPlotLockAndHaveReadState().getPlotLockAndHaveReadState(character.id)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun PageCharacterInfoAndStoryPreview(

) {
    PageCharacterInfoAndStory(
        character = CharacterInfoAndPlotStorer.character[0],
        onClickGoStory = {},
        onClickGoDetail = {},
    )
}