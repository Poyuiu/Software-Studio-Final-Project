package com.ss_team_1.koibitoshuuchuu.presentation.components

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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.ui.theme.AccentDark
import com.ss_team_1.koibitoshuuchuu.ui.theme.black
import com.ss_team_1.koibitoshuuchuu.ui.theme.contextFont
import com.ss_team_1.koibitoshuuchuu.ui.theme.mainFont

@Preview
@Composable
fun NoGift(
):Int{
    val popup = remember { mutableStateOf(0) }//沒暗任何案件
    androidx.compose.material.Surface(){
        Column(
            modifier = Modifier
                .width(280.dp)
                .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.No_Gift_to_give_header),
                fontSize = 28.sp,
                color = black,
                fontStyle = FontStyle(contextFont),
                modifier = Modifier.padding(8.dp)
            )
            Box(modifier = Modifier.fillMaxWidth()){
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    //verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "沒錢QQ",
                        fontSize = 24.sp,
                        color = black,
                        fontStyle = FontStyle(mainFont),
                        modifier = Modifier.padding(8.dp)
                            .clickable(
                                enabled = true,
                                onClickLabel = "doesn't buy",
                                onClick = {
                                    popup.value = 1
                                }
                            )
                    )
                    Spacer(modifier = Modifier.width(64.dp))
                    Text(
                        text = "去商店",
                        fontSize = 24.sp,
                        fontStyle = FontStyle(mainFont),
                        color = AccentDark,
                        modifier = Modifier.padding(8.dp)
                            .clickable(
                                enabled = true,
                                onClickLabel = "give gift",
                                onClick = {
                                    popup.value = 2
                                }
                            )
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

    return popup.value
}

@Preview(showBackground = true)
@Composable
fun NoGiftPopupScreen(
): Int{
    val popup = remember { mutableStateOf(0) }//沒暗任何案件
    androidx.compose.material.Surface(
        color = Color.Black.copy(alpha = 0f)
    ){
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
    }

    return popup.value
}