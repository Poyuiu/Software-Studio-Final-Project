package com.ss_team_1.koibitoshuuchuu.presentation.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.StrokeText

@Composable
fun Heart_initamcybar(
    intimacyLevel: Int,
    intimacy: Int,
    levelIntimacyNeed: Int,
    showPercentage: Boolean
){
    Row{
        characterIntimacyLevel(intimacyLevel)
        intimacyBar(intimacy,levelIntimacyNeed, showPercentage)
    }
}
@Preview
@Composable
fun Heart_initamcybarpreview(){
    Heart_initamcybar(2,400,1314,true)
}

@Composable
fun Name_InfoButton(
    context: Context,
    name: String,
    lock: Boolean
){
    Box(
        Modifier.size(270.dp, 72.dp)
    ){
        StrokeText(LocalContext.current,name, 32f,56,128f)
        Row(
            modifier = Modifier.align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically
        ){
            ButtonWithBorder(lock)
            Spacer(modifier = Modifier.width(12.dp))
        }
    }

}
@Preview
@Composable
fun Name_InfoButtonpreview(){
    Name_InfoButton(LocalContext.current,"四季映姬" ,false )
}

@Composable
fun HomepageCharacter(
    intimacyLevel: Int,
    intimacy: Int,
    levelIntimacyNeed: Int,
    showPercentage: Boolean,
    context: Context,
    name: String,
    lock: Boolean,
    characterOrder: Int
){
    Box(
        Modifier.size(300.dp, 730.dp)
    ){
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Heart_initamcybar(intimacyLevel, intimacy, levelIntimacyNeed, showPercentage)
            Name_InfoButton(context, name, lock)
            if(characterOrder==1){//隨order切照片
                Image(
                    painter = painterResource(id = R.drawable.shikieiki_main),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize()
                )
            }else {
                Image(
                    painter = painterResource(id = R.drawable.shikieiki_main),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize()
                )
            }

        }
    }

}
@Preview
@Composable
fun HomepageCharacterpreview(){
    HomepageCharacter(2,400,1314,true,LocalContext.current,"四季映姬" ,false ,1)
}