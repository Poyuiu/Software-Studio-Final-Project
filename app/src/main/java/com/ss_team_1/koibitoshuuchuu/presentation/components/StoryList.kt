package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StoryList(
    onClick: () -> Unit,
    characterName: String
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(13.dp),
        modifier = Modifier
    ){
        /*
        PlotButton(
            onClick = onClick,
            lock = Story.lock,
            haveRead = ,
            id = 7,
            title = "標題範例"
        )

         */
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun StoryListPreview() {
    StoryList(
        onClick = {},
        characterName = ""
    )
}