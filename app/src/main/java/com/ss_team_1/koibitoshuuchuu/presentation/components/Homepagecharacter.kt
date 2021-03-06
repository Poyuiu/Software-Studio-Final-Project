package com.ss_team_1.koibitoshuuchuu.presentation.components

import android.content.Context
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.characternamelist
import com.ss_team_1.koibitoshuuchuu.presentation.characterphotolist


@Composable
fun Heart_initamcybar(
    intimacyLevel: Int,
    intimacy: Int,
    levelIntimacyNeed: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        characterIntimacyLevel(intimacyLevel)
        intimacyBar(intimacy, levelIntimacyNeed)
    }
}

@Preview
@Composable
fun Heart_initamcybarpreview() {
    Heart_initamcybar(2, 400, 1314)
}

@Composable
fun Name_InfoButton(/*調*/
    context: Context,
    characterId: Int,
    lock: Boolean,
    onClickToCharacterInfo: () -> Unit = {}
) {

    Box(
        Modifier.size(280.dp, 72.dp)
    ) {
        //StrokeText(LocalContext.current,name, 32f,56,128f)
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Spacer(modifier = Modifier.width(8.dp))
            Box(
                Modifier
                    .size(220.dp, 72.dp)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = characternamelist[characterId]),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            ButtonWithBorder(lock, onClickToCharacterInfo)
            Spacer(modifier = Modifier.width(8.dp))

        }
    }

}

@Preview
@Composable
fun Name_InfoButtonpreview() {
    Name_InfoButton(LocalContext.current, 1, false)
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomepageCharacter(
    intimacyLevel: Int,
    intimacy: Int,
    levelIntimacyNeed: Int,
    context: Context,
    lock: Boolean,
    characterId: Int,
    onClickToCharacterInfo: () -> Unit = {},
    moveRight: Boolean,
    enable: Boolean,
) {
    val matrix = ColorMatrix()
    if (lock)
        matrix.setToSaturation(0F)
    Box(
        Modifier.size(300.dp, 730.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Heart_initamcybar(intimacyLevel, intimacy, levelIntimacyNeed)
            Name_InfoButton(context, characterId, lock, onClickToCharacterInfo)
            AnimatedContent(targetState = characterId,
                transitionSpec = {
                    if (!moveRight) {
                        slideInHorizontally { fullWidth -> (fullWidth * 1.5).toInt() } with
                                slideOutHorizontally { fullWidth -> -(fullWidth * 1.5).toInt() }
                    } else {
                        slideInHorizontally { fullWidth -> -(fullWidth * 1.5).toInt() } with
                                slideOutHorizontally { fullWidth -> (fullWidth * 1.5).toInt() }
                    }.using(SizeTransform(clip = false))
                }) { targetCharacterId ->
                Image(
                    painter = painterResource(id = characterphotolist[targetCharacterId]),
                    colorFilter = ColorFilter.colorMatrix(matrix),//調灰階
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable(
                            enabled = !lock,
                            onClickLabel = "character click",
                            onClick = onClickToCharacterInfo
                        )
                )
            }

//            if (lock) {//隨order切照片
//                Image(
//                    painter = painterResource(id = characterphotolist[characterId]),
//                    contentDescription = "",
//                    modifier = Modifier.fillMaxSize(),
//                    colorFilter = ColorFilter.colorMatrix(matrix)//調灰階
//                )
//            } else {
//                Image(
//                    painter = painterResource(id = characterphotolist[characterId]),
//                    contentDescription = "",
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .clickable(
//                            enabled = enable,
//                            onClickLabel = "character click",
//                            onClick = onClickToCharacterInfo
//                        )
//                )
            /*Button(
                onClick = onClickToCharacterInfo,
                enabled = enable,
                elevation = null,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(id = characterphotolist[characterId]),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize()
                )
            }*/
        }
    }
}


/*@Preview
@Composable
fun HomepageCharacterpreview(){
    HomepageCharacter(2,400,1314,LocalContext.current ,false ,1,,true)
}*/

