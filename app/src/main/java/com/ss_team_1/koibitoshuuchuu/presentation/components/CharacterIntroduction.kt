package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.presentation.utils.ResourceStorer
import com.ss_team_1.koibitoshuuchuu.ui.theme.*

@Composable
fun CharacterIntroduction(
    @StringRes introduction: Int,
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
            text = stringResource(id = introduction),
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
        introduction = ResourceStorer.character[0].introduction
    )
}