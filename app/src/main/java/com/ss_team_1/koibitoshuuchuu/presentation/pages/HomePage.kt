package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.domain.model.Character
import com.ss_team_1.koibitoshuuchuu.domain.use_case.plot.PlotUseCases
import com.ss_team_1.koibitoshuuchuu.presentation.components.*

@Preview
@Composable
fun HomePage(
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
            Spacer(modifier = Modifier.height(96.dp))
            HomepageCharacter(2,400,1314,true, LocalContext.current,"四季映姬" ,false ,1)
        }
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            FocusButton(LocalContext.current,false)
            Spacer(modifier = Modifier.height(120.dp))
        }
    }
}
