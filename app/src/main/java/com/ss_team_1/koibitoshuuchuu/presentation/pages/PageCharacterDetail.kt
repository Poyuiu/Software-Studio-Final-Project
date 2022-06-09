package com.ss_team_1.koibitoshuuchuu.presentation.pages


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.MyApplication
import com.ss_team_1.koibitoshuuchuu.presentation.components.*
import com.ss_team_1.koibitoshuuchuu.presentation.utils.CharacterInfoAndPlotStorer

@Composable
fun PageCharacterDetail(
    characterID: Int,
) {
    val character = remember {
        CharacterInfoAndPlotStorer.character[characterID]
    }
    val focusRecord = remember {
        MyApplication.appContainer().focusHistoryRepository.getLastWeekHistoryByCharacterIdGroupByDay(
            characterID
        ).value!!
    }

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
                .align(Alignment.TopCenter)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            CharacterInfo(
                onClick = {},
                characterPhoto = character.photo,
                characterName = character.name,
                characterInfo = character.info,
                showDetailButton = false
            )
            Spacer(modifier = Modifier.height(8.dp))
            BarChart(data = focusRecord)
            Spacer(modifier = Modifier.height(8.dp))
            CharacterIntroduction(
                introduction = character.introduction
            )
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun PageCharacterDetailPreview(

) {
    PageCharacterDetail(
        characterID = 0,
    )
}