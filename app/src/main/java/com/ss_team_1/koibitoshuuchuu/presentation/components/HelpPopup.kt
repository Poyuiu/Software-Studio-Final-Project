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

@Preview
@Composable
fun HelpPopup(
):Int{
    val popup = remember { mutableStateOf(0) }//沒暗任何案件
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
                            }
                        )
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
        Text(
            text = stringResource(id = R.string.Help_body1),
            fontSize = 20.sp,
            fontStyle = FontStyle(contextFont),
            modifier = Modifier.padding(8.dp)
        )
        Box(modifier = Modifier.fillMaxWidth()){
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(id = R.drawable.coin),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(80.dp)
                )
            }
            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                //verticalAlignment = Alignment.CenterVertically
            ){
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
                            }
                        )
                )
                Spacer(modifier = Modifier.width(184.dp))
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
                            }
                        )
                )
                Spacer(modifier = Modifier.width(16.dp))
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
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
            popup.value = NoGift()
        }
    }
    return popup.value
}