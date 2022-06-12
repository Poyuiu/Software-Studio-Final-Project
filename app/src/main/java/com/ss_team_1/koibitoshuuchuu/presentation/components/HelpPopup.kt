package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.ui.theme.AccentDark
import com.ss_team_1.koibitoshuuchuu.ui.theme.contextFont
import com.ss_team_1.koibitoshuuchuu.ui.theme.mainFont

val helpbodylist= listOf(
    R.string.Help_body0,
    R.string.Help_body1,
    R.string.Help_body2,
    R.string.Help_body3,
    R.string.Help_body4,
    R.string.Help_body5,
    R.string.Help_body6
)
val helpPhotoList = listOf(
    R.drawable.help_photo0,
    R.drawable.help_photo1,
    R.drawable.help_photo2,
    R.drawable.help_photo3,
    R.drawable.help_photo4,
    R.drawable.help_photo5,
    R.drawable.help_photo6
)

val photoWidthList=listOf(
    200.dp,
    101.dp,
    113.dp,
    149.dp,
    180.dp,
    105.dp,
    112.dp
)
@Preview
@Composable
fun HelpPopup(
):Int{
    val popup = remember { mutableStateOf(0) }//沒暗任何案件
    val helpid = remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .width(280.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxWidth()){
            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                //verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "幫助",
                    fontSize = 28.sp,
                    fontStyle = FontStyle(contextFont),
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(modifier = Modifier.width(144.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_help_clear),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable(
                            enabled = true,
                            onClickLabel = "clear",
                            onClick = {
                                /*TODO*/
                                popup.value = 1
                            }
                        )
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        }

        Text(
            text = stringResource(id = helpbodylist[helpid.value]),
            fontSize = 20.sp,
            fontStyle = FontStyle(contextFont),
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxWidth()){
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(id = helpPhotoList[helpid.value]),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(photoWidthList[helpid.value])
                )
            }
            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                //verticalAlignment = Alignment.CenterVertically
            ){
                if(helpid.value !=0){
                    Image(
                        painter = painterResource(id = R.drawable.profile_arrow_left),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(28.dp)
                            .clickable(
                                enabled = true,
                                onClickLabel = "clear",
                                onClick = {
                                    /*TODO*/
                                    helpid.value--
                                }
                            )
                    )
                }

                Spacer(modifier = Modifier.width(188.dp))
                if(helpid.value!=6){
                    Image(
                        painter = painterResource(id = R.drawable.profile_arrow_right),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(28.dp)
                            .clickable(
                                enabled = true,
                                onClickLabel = "clear",
                                onClick = {
                                    /*TODO*/
                                    helpid.value++
                                }
                            )
                    )
                }else{
                    Spacer(modifier = Modifier.width(28.dp))
                }

                Spacer(modifier = Modifier.width(16.dp))
            }

        }

        if(helpid.value==6){
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "好的",
                fontSize = 32.sp,
                fontStyle = FontStyle(mainFont),
                color = AccentDark,
                modifier = Modifier.padding(8.dp)
                    .clickable(
                        enabled = true,
                        onClickLabel = "buy gift",
                        onClick = {
                            /*TODO*/
                            popup.value = 1
                        }
                    )
            )

        }
        Spacer(modifier = Modifier.height(24.dp))
    }


    return popup.value
}

@Preview(showBackground = true)
@Composable
fun HelpPopupScreen(
): Int{
    val popup = remember { mutableStateOf(0) }//沒暗任何案件
    Box(
        Modifier.fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f), RectangleShape)
    ){
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(280.dp))
            popup.value = HelpPopup()
        }
    }
    return popup.value
}