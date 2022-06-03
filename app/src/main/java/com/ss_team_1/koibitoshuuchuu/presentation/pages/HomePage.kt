package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.domain.use_case.plot.Character
import com.ss_team_1.koibitoshuuchuu.presentation.components.*

@Preview
@Composable
fun HomePage(
    character: Character
) {
    Box(
        Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.coffee_shop_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        TopBar(button1 = { SettingsButton() }, button2 = {HelpButton()})
        NavigationBar(modifier = Modifier.align(Alignment.BottomCenter))
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            
        }
    }
}