package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
                MyApplication.app_container
                    ?.characterRepository?.getCharacter(characterid.value)
                    ?.value?.level() }

        val intimacy =
            remember{
                MyApplication.app_container
                    ?.characterRepository?.getCharacter(characterid.value)
                    ?.value?.intimacy }

        val levelIntimacyNeed =
            remember{
                MyApplication.app_container
                    ?.characterRepository?.getCharacter(characterid.value)
                    ?.value?.intimacyNeeded() }


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
            Spacer(modifier = Modifier.height(64.dp))
            if (intimacyLevel != null && intimacy != null && levelIntimacyNeed !=null) {
                HomepageCharacter(intimacyLevel,intimacy,levelIntimacyNeed,
                    LocalContext.current, lock,characterid.value)
            }else {
                HomepageCharacter(0,0,100,
                    LocalContext.current, lock,characterid.value)
            }
        }
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            FocusButton(LocalContext.current, lock, navController)
            Spacer(modifier = Modifier.height(120.dp))
        }
        Row(
            modifier = Modifier.align(Alignment.CenterStart)
                .clickable (
                    enabled = true,
                    onClickLabel = "Clickable right shift",
                    onClick = {
                        if(characterid.value<2){
                            characterid.value+=1
                        }else{characterid.value=0}
                    }
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            rightRoundedTriangle(
                /*modifier = Modifier
                    .clickable (
                        enabled = true,
                        onClickLabel = "Clickable right shift",
                        onClick = {
                            if(characterid.value<2){
                                characterid.value+=1
                            }else{characterid.value=0}
                        }
                    )*/
            )
        }
        Row(
            modifier = Modifier.align(Alignment.CenterEnd)
                .clickable (
                    enabled = true,
                    onClickLabel = "Clickable left shift",
                    onClick = {
                        if(characterid.value>0){
                            characterid.value-=1
                        }else{characterid.value=2}
                    }
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            leftRoundedTriangle(
                /*modifier = Modifier
                    .clickable (
                        enabled = true,
                        onClickLabel = "Clickable left shift",
                        onClick = {
                            if(characterid.value>0){
                                characterid.value-=1
                            }else{characterid.value=2}
                        }
                    )*/
            )
        }

    }
}

