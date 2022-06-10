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
import com.ss_team_1.koibitoshuuchuu.ui.theme.contextFont
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.ui.theme.AccentDark
import com.ss_team_1.koibitoshuuchuu.ui.theme.grayLine
import com.ss_team_1.koibitoshuuchuu.ui.theme.mainFont

@Preview
@Composable
fun GiftBuying(

): Int{
    val spend = remember { mutableStateOf(-1) }//沒暗任何案件
    Column(
        modifier = Modifier
            .width(280.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.shop_buying_gift2_head),
            fontSize = 20.sp,
            //color = secUn,
            fontStyle = FontStyle(contextFont),
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = stringResource(id = R.string.shop_buying_gift2_body),
            fontSize = 14.sp,
            fontStyle = FontStyle(contextFont)
        )
        Box(
            modifier = Modifier.fillMaxWidth()
        ){
            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                //verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    text = "物品價格: 500",
                    fontSize = 14.sp,
                    fontStyle = FontStyle(contextFont),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        ){
            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                //verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    text = "數量:",
                    fontSize = 16.sp,
                    fontStyle = FontStyle(contextFont)
                )
                Spacer(modifier = Modifier.width(24.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_minus),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(color = Color.Gray),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(
                            enabled = true,
                            onClickLabel = "minus gift",
                            onClick = {
                                /*TODO*/
                            }
                        )
                )
                Spacer(modifier = Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .width(90.dp)
                        .height(30.dp)
                        .align(Alignment.CenterVertically)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.popup_block),
                        contentDescription = "",
                        contentScale = ContentScale.Fit
                    )
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "1",
                            fontSize = 16.sp,
                            fontStyle = FontStyle(contextFont)
                        )
                    }

                }
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(color = Color.Gray),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(
                            enabled = true,
                            onClickLabel = "plus gift",
                            onClick = {
                                /*TODO*/
                            }
                        )
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth()
        ){
            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                //verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "總金額:     500",
                    fontSize = 16.sp,
                    fontStyle = FontStyle(contextFont)
                )
                Spacer(modifier = Modifier.width(24.dp))
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth()
        ){
            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                //verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "CANCEL",
                    fontSize = 14.sp,
                    fontStyle = FontStyle(mainFont),
                    color = grayLine,
                    modifier = Modifier.padding(8.dp)
                        .clickable(
                            enabled = true,
                            onClickLabel = "doesn't buy",
                            onClick = {
                                /*TODO*/
                                spend.value = 0
                            }
                        )
                )
                Text(
                    text = "COMFIRM",
                    fontSize = 14.sp,
                    fontStyle = FontStyle(mainFont),
                    color = AccentDark,
                    modifier = Modifier.padding(8.dp)
                        .clickable(
                            enabled = true,
                            onClickLabel = "buy gift",
                            onClick = {
                                /*TODO*/
                                spend.value = 500+5000
                                /***************************/
                                /************扣錢!!!!!!!!,加禮物**************/
                            }
                        )
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
    return spend.value
}

@Preview(showBackground = true)
@Composable
fun buyinggiftPopupScreen():Int{
    val spend = remember { mutableStateOf(-1) }//沒暗任何案件
    Box(
        Modifier.fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f), RectangleShape)
    ){
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(280.dp))
            spend.value = GiftBuying()
        }
    }
    return spend.value
}