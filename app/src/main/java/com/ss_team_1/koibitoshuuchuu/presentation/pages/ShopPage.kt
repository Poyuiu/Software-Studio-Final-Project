package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.components.*

@Composable
fun ShopPage(
    navController: NavController,
) {
    val openDialog = remember { mutableStateOf(false) }
    val buying = remember { mutableStateOf(-1) }
    val spend = remember { mutableStateOf(1) }//沒暗任何案件
    val boughtflag = remember { mutableStateOf(false) }
    Box(
        Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_only_color),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        NavigationBar(modifier = Modifier.align(Alignment.BottomCenter), navController)
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            money_diamond_bar(100000, 400)
            if (boughtflag.value) {
                Image(
                    painter = painterResource(id = R.drawable.shop_buy_gift_0),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(336.dp, 40.dp)
                )
            } else {
                Spacer(modifier = Modifier.height(40.dp))
            }
            Image(
                painter = painterResource(id = R.drawable.shop_header_0),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(356.dp, 72.dp)
            )

             buying.value =ShopSceneGoods()
            if(buying.value>-1 && spend.value==1) openDialog.value =true
            Spacer(modifier = Modifier.height(36.dp))
            Image(
                painter = painterResource(id = R.drawable.shop_header_1),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(356.dp, 72.dp)
            )
            ShopGiftGoodsRow0()
            Spacer(modifier = Modifier.height(36.dp))
            ShopGiftGoodsRow1()
        }


    }
    if(openDialog.value){
        spend.value=buyingPopupScreen()
        if(spend.value<=0){
            openDialog.value=false
        }
        if(spend.value<0){
            boughtflag.value=true
        }
    }
}

@Preview
@Composable
fun ShopPagePreview() {
    ShopPage(navController = NavController(LocalContext.current))
}