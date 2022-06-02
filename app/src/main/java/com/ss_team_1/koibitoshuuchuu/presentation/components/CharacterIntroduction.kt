package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.ui.theme.*

@Composable
fun CharacterIntroduction(
    introduction: String,
) {

    Column(
        modifier = Modifier
            .padding(8.dp)
            .width(344.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "簡介",
            fontSize = 28.sp,
            color = secUn,
            fontStyle = FontStyle(mainFont),
            modifier = Modifier.padding(bottom = 8.dp, top = 16.dp)
        )
        Text(
            text = introduction,
            fontSize = 16.sp,
            fontStyle = FontStyle(mainFont),
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
        )
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun CharacterIntroductionPreview() {
    CharacterIntroduction(
        introduction = "四季映姫是閻魔之一，擔當幻想郷及其他地區的閻魔，負責對死者的裁決。在是非曲直廳中負責審判死者的工作，死神小野塚小町的上司。\n" +
                "\n" +
                "平時在彼岸的是非曲直廳内裁決死者的靈魂，有時會到幻想郷去説教，警告人們積累善行，以免被判下地獄。\n" +
                "\n" +
                "身穿十分鄭重的袍裝，性格嚴肅認真，不過偶爾也有意外萌的一面。"
    )
}