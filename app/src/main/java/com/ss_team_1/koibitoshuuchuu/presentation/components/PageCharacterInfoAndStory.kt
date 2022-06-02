package com.ss_team_1.koibitoshuuchuu.presentation.components

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
import com.ss_team_1.koibitoshuuchuu.domain.use_case.plot.Character

@Composable
fun PageCharacterInfoAndStory(
    character: Character,
    onClickGoStroy: () -> Unit,
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
        TopBar {
            BackButton()
        }
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
                onClick = onClickGoStroy,
                plotTitleList = character.plotList
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun PageCharacterInfoAndStoryPreview(

) {
    PageCharacterInfoAndStory(
        character = Character(
            name = "四季映姫",
            photo = R.drawable.shikieiki_main,
            info = "暱稱：閻蘿王\n" +
                    "\n" +
                    "身高：較高與高\n" + "之間\n" +
                    "種族：閻魔\n" +
                    "\n" +
                    "住所：彼岸\n" +
                    "職業：審判官",
        ),
        onClickGoStroy = {},
        onClickGoDetail = {},
    )
}