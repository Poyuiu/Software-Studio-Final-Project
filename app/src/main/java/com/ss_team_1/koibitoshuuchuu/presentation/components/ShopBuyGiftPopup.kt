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

val shopBuyGiftHead= listOf(
    R.string.shop_buying_gift0_head,
    R.string.shop_buying_gift1_head,
    R.string.shop_buying_gift2_head,
    R.string.shop_buying_gift3_head,
    R.string.shop_buying_gift4_head
)
val shopBuyGiftBody = listOf(
    R.string.shop_buying_gift0_body,
    R.string.shop_buying_gift1_body,
    R.string.shop_buying_gift2_body,
    R.string.shop_buying_gift3_body,
    R.string.shop_buying_gift4_body
)
val giftPriceList = listOf(
    10, 30, 100, 20, 30
)
//@Preview
@Composable
fun GiftBuying(
    gift:Int,
    money: Int
): Int{
    val spend = remember { mutableStateOf(-1) }//沒暗任何案件
    val amount = remember { mutableStateOf(1) }
    Column(
        modifier = Modifier
            .width(280.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = shopBuyGiftHead[gift]),
            fontSize = 20.sp,
            //color = secUn,
            fontStyle = FontStyle(contextFont),
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = stringResource(id = shopBuyGiftBody[gift]),
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
                    text = "物品價格: ${giftPriceList[gift]}",
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
                    colorFilter = if(amount.value>1) null
                                else ColorFilter.tint(color = Color.Gray),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(
                            enabled = (amount.value>1),
                            onClickLabel = "minus gift",
                            onClick = {
                                /*TODO*/
                                amount.value--
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
                            text = "${amount.value}",
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
                    colorFilter = if((amount.value+1)*giftPriceList[gift] <= money) null
                                else ColorFilter.tint(color = Color.Gray),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(
                            enabled = ((amount.value+1)*giftPriceList[gift] <= money),
                            onClickLabel = "plus gift",
                            onClick = {
                                /*TODO*/
                                amount.value++
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
                    text = "總金額:     ${giftPriceList[gift]*amount.value}",
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
                    text = "取消",
                    fontSize = 16.sp,
                    fontStyle = FontStyle(mainFont),
                    color = if(money >= giftPriceList[gift])grayLine else AccentDark,
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
                Spacer(modifier = Modifier.width(32.dp))
                Text(
                    text = if(money >= giftPriceList[gift])"購買" else "沒錢喔!",
                    fontSize = 16.sp,
                    fontStyle = FontStyle(mainFont),
                    color = if(money >= giftPriceList[gift])AccentDark else grayLine,
                    modifier = Modifier.padding(8.dp)
                        .clickable(
                            enabled = (money >= giftPriceList[gift]),
                            onClickLabel = "buy gift",
                            onClick = {
                                /*TODO*/
                                spend.value = giftPriceList[gift]*amount.value
                                /***************************/
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

//@Preview(showBackground = true)
@Composable
fun buyinggiftPopupScreen(
    buy:Int,
    money: Int
):Int{
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
            spend.value = GiftBuying(buy-3,money)//挑整排序，去除場景的序號
        }
    }
    return spend.value
}