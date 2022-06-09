package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.MyApplication
import com.ss_team_1.koibitoshuuchuu.presentation.components.*

@Preview
@Composable
fun HomePage(
    navController: NavController = NavController(LocalContext.current)
) {
    Box(
        Modifier.fillMaxSize()
    ){
        val characterid: MutableState<Int> =
            remember { mutableStateOf(0) }

        //var checkedState by rememberSaveable { mutableStateOf(false) }
        val intimacyLevel =
            remember{
                MyApplication.appContainer()
                    .characterRepository.getCharacter(characterid.value)
                    .value?.level() }

        val intimacy =
            remember{
                MyApplication.appContainer()
                    .characterRepository.getCharacter(characterid.value)
                    .value?.intimacy }

        val levelIntimacyNeed =
            remember{
                MyApplication.appContainer()
                    .characterRepository.getCharacter(characterid.value)
                    .value?.intimacyNeeded() }

        val  showPercentage: MutableState<Boolean> =
            remember { mutableStateOf(false) }

        var lock = true
        if (intimacyLevel != null) {
            if ( intimacyLevel > 0 ) lock = false
        }

        Image(
            painter = painterResource(id = R.drawable.coffee_shop_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        TopBar(button1 = { SettingsButton() }, button2 = {HelpButton()})
        NavigationBar(modifier = Modifier.align(Alignment.BottomCenter),navController)
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(96.dp))
            if (intimacyLevel != null && intimacy != null && levelIntimacyNeed !=null) {
                HomepageCharacter(intimacyLevel,intimacy,levelIntimacyNeed,
                    showPercentage.value, LocalContext.current, lock,characterid.value)
            }else {
                HomepageCharacter(100,5,10,
                    showPercentage.value, LocalContext.current, lock,characterid.value)
            }
        }
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            FocusButton(LocalContext.current, lock)
            Spacer(modifier = Modifier.height(120.dp))
        }
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            rightRoundedTriangle()
        }
        Row(
            modifier = Modifier.align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically
        ) {
            leftRoundedTriangle()
        }

    }
}

