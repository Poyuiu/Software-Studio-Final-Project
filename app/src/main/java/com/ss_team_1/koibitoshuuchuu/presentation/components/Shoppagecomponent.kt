package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.ui.theme.mainFont
import com.ss_team_1.koibitoshuuchuu.ui.theme.mamelonFamily
import com.ss_team_1.koibitoshuuchuu.ui.theme.secUn

@Composable
fun money_diamond_bar(
    money: Int,
    diamond: Int
){
    Row(
        modifier = Modifier
            .width(336.dp)
            .height(50.dp)
            .background(color = Color(0xfff8bbd0)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = R.drawable.diamond),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "$diamond",
            fontSize = 24.sp,
            fontFamily = mamelonFamily,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF000000)
        )
        Spacer(modifier = Modifier.width(64.dp))
        Image(
            painter = painterResource(id = R.drawable.coin),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "$money",
            fontSize = 24.sp,
            fontFamily = mamelonFamily,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF000000)
        )
    }
}
@Preview
@Composable
fun money_diamond_barpreview(){
    money_diamond_bar(100000,400)
}

@Composable
fun ShopSceneGoods(){
    Box(modifier = Modifier.size(328.dp,128.dp)){
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.shop_scene_0),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(88.dp,138.dp)
                    .clickable(
                        enabled = true,
                        onClickLabel = "buy scene0",
                        onClick = {
                            /*TODO*/
                        }
                    )
            )
            Spacer(modifier = Modifier.width(32.dp))
            Image(
                painter = painterResource(id = R.drawable.shop_scene_1),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(88.dp,138.dp)
                    .clickable(
                        enabled = true,
                        onClickLabel = "buy scene1",
                        onClick = {
                            /*TODO*/
                        }
                    )
            )
            Spacer(modifier = Modifier.width(32.dp))
            Image(
                painter = painterResource(id = R.drawable.shop_scene_2),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(88.dp,138.dp)
                    .clickable(
                        enabled = true,
                        onClickLabel = "buy scene2",
                        onClick = {
                            /*TODO*/
                        }
                    )
            )
        }
    }


}
@Preview
@Composable
fun ShopSceneGoodspreview(){
    ShopSceneGoods()
}

@Composable
fun ShopGiftGoodsRow0(){
    Box(modifier = Modifier.size(328.dp,128.dp)){
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.shop_gift_0),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(88.dp,138.dp)
                    .clickable(
                        enabled = true,
                        onClickLabel = "buy gift0",
                        onClick = {
                            /*TODO*/
                        }
                    )
            )
            Spacer(modifier = Modifier.width(32.dp))
            Image(
                painter = painterResource(id = R.drawable.shop_gift_1),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(88.dp,138.dp)
                    .clickable(
                        enabled = true,
                        onClickLabel = "buy gift1",
                        onClick = {
                            /*TODO*/
                        }
                    )
            )
            Spacer(modifier = Modifier.width(32.dp))
            Image(
                painter = painterResource(id = R.drawable.shop_gift_2),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(88.dp,138.dp)
                    .clickable(
                        enabled = true,
                        onClickLabel = "buy gift2",
                        onClick = {
                            /*TODO*/
                        }
                    )
            )
        }
    }


}
@Preview
@Composable
fun ShopGiftGoodsRow0preview(){
    ShopGiftGoodsRow0()
}

@Composable
fun ShopGiftGoodsRow1(){
    Box(modifier = Modifier.size(328.dp,128.dp)){
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.shop_gift_3),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(88.dp,138.dp)
                    .clickable(
                        enabled = true,
                        onClickLabel = "buy gift3",
                        onClick = {
                            /*TODO*/
                        }
                    )
            )
            Spacer(modifier = Modifier.width(32.dp))
            Image(
                painter = painterResource(id = R.drawable.shop_gift_4),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(88.dp,138.dp)
                    .clickable(
                        enabled = true,
                        onClickLabel = "buy gift4",
                        onClick = {
                            /*TODO*/
                        }
                    )
            )
        }
    }


}
@Preview
@Composable
fun ShopGiftGoodsRow1preview(){
    ShopGiftGoodsRow1()
}