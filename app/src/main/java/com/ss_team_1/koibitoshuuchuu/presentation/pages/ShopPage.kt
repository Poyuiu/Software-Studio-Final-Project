package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.components.*

@Composable
fun ShopPage(
    buyflag:Boolean
){
    Box(
        Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.background_only_color),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        NavigationBar(modifier = Modifier.align(Alignment.BottomCenter))
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(32.dp))
            money_diamond_bar(100000,400)
            if(buyflag){
                Image(
                    painter = painterResource(id = R.drawable.shop_buy_gift_0),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(336.dp,40.dp)
                )
            }else{
                Spacer(modifier = Modifier.height(40.dp))
            }
            Image(
                painter = painterResource(id = R.drawable.shop_header_0),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(356.dp,72.dp)
            )
            ShopSceneGoods()
            Spacer(modifier = Modifier.height(36.dp))
            Image(
                painter = painterResource(id = R.drawable.shop_header_1),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(356.dp,72.dp)
            )
            ShopGiftGoodsRow0()
            Spacer(modifier = Modifier.height(36.dp))
            ShopGiftGoodsRow1()
        }
    }
}

@Preview
@Composable
fun ShopPagePreview(){
    ShopPage(false)
}