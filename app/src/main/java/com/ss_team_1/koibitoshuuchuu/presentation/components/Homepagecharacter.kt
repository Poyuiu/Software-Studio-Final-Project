package com.ss_team_1.koibitoshuuchuu.presentation.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
fun Name_InfoButton(/*調*/
    context: Context,
    characterId: Int,
    lock: Boolean
){
    Box(
        Modifier.size(280.dp, 72.dp)
    ){
        //StrokeText(LocalContext.current,name, 32f,56,128f)
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ){
            //Spacer(modifier = Modifier.width(8.dp))
            Box(
                Modifier.size(220.dp,72.dp)
                    .padding(8.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.character_0_name),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            ButtonWithBorder(lock)
            Spacer(modifier = Modifier.width(8.dp))

        }
    }

}
@Preview
@Composable
fun Name_InfoButtonpreview(){
    Name_InfoButton(LocalContext.current,0 ,false )
}

@Composable
fun HomepageCharacter(
    intimacyLevel: Int,
    intimacy: Int,
    levelIntimacyNeed: Int,
    showPercentage: Boolean,
    context: Context,
    lock: Boolean,
    characterId: Int
){
    Box(
        Modifier.size(300.dp, 730.dp)
    ){
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Heart_initamcybar(intimacyLevel, intimacy, levelIntimacyNeed, showPercentage)
            Name_InfoButton(context, characterId, lock)
            if(characterId==0){//隨order切照片
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
    HomepageCharacter(2,400,1314,true,LocalContext.current ,false ,0)
}