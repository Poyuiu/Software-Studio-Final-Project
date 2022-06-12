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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.bought_list
import com.ss_team_1.koibitoshuuchuu.presentation.components.*
import com.ss_team_1.koibitoshuuchuu.presentation.event.ItemEvent
import com.ss_team_1.koibitoshuuchuu.presentation.event.SceneEvent
import com.ss_team_1.koibitoshuuchuu.presentation.event.UserEvent
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.ItemViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.SceneViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.UserViewModel


@Composable
fun ShopPage(
    navController: NavController,
    viewModel: ItemViewModel = hiltViewModel(),
    sceneViewModel: SceneViewModel = hiltViewModel(),
    userViewModel: UserViewModel = hiltViewModel()
) {
    val state = userViewModel.state.value
    val sceneState = sceneViewModel.state.value
    val openDialog = remember { mutableStateOf(false) }
    val buying = remember { mutableStateOf(-1) }
    val spending = remember { mutableStateOf(-1) }//沒暗任何案件
    val boughtflag = remember { mutableStateOf(false) }
    Box(
        Modifier.fillMaxSize()
    ) {
        val matrix = ColorMatrix()
        matrix.setToSaturation(0F)
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
            money_diamond_bar(state.userInfo.money, 100)
            if (boughtflag.value) {
                Image(
                    painter = painterResource(id = bought_list[spending.value/1000]),
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

            Box(modifier = Modifier.size(328.dp,128.dp)){
                Row(
                    modifier = Modifier.align(Alignment.CenterStart),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.shop_scene_0),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        colorFilter = if(sceneState.scenes[1].is_owned) ColorFilter.colorMatrix(matrix)
                                                    else null,
                        modifier = Modifier
                            .size(88.dp, 138.dp)
                            .clickable(
                                enabled = !openDialog.value && !sceneState.scenes[1].is_owned,
                                onClickLabel = "buy scene0",
                                onClick = {
                                    /*TODO*/
                                    buying.value = 0
                                }
                            )
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.shop_scene_1),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        colorFilter = if(sceneState.scenes[2].is_owned) ColorFilter.colorMatrix(matrix)
                                            else null,
                        modifier = Modifier
                            .size(88.dp, 138.dp)
                            .clickable(
                                enabled = !openDialog.value && !sceneState.scenes[2].is_owned,
                                onClickLabel = "buy scene1",
                                onClick = {
                                    /*TODO*/
                                    buying.value = 1
                                }
                            )
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.shop_scene_2),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        colorFilter = if(sceneState.scenes[3].is_owned) ColorFilter.colorMatrix(matrix)
                                            else null,
                        modifier = Modifier
                            .size(88.dp, 138.dp)
                            .clickable(
                                enabled = !openDialog.value && !sceneState.scenes[3].is_owned,
                                onClickLabel = "buy scene2",
                                onClick = {
                                    /*TODO*/
                                    buying.value = 2
                                }
                            )
                    )
                }
            }
            Spacer(modifier = Modifier.height(36.dp))
            Image(
                painter = painterResource(id = R.drawable.shop_header_1),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(356.dp, 72.dp)
            )
            Box(modifier = Modifier.size(328.dp,128.dp)){
                Row(
                    modifier = Modifier.align(Alignment.CenterStart),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.shop_gift_0),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(88.dp, 138.dp)
                            .clickable(
                                enabled = !openDialog.value,
                                onClickLabel = "buy gift0",
                                onClick = {
                                    /*TODO*/
                                    buying.value = 3
                                }
                            )
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.shop_gift_1),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(88.dp, 138.dp)
                            .clickable(
                                enabled = !openDialog.value,
                                onClickLabel = "buy gift1",
                                onClick = {
                                    /*TODO*/
                                    buying.value = 4
                                }
                            )
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.shop_gift_2),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(88.dp, 138.dp)
                            .clickable(
                                enabled = !openDialog.value,
                                onClickLabel = "buy gift2",
                                onClick = {
                                    /*TODO*/
                                    buying.value = 5
                                }
                            )
                    )
                }
            }
            Spacer(modifier = Modifier.height(36.dp))
            Box(modifier = Modifier.size(328.dp,128.dp)){
                Row(
                    modifier = Modifier.align(Alignment.CenterStart),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.shop_gift_3),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(88.dp, 138.dp)
                            .clickable(
                                enabled = !openDialog.value,
                                onClickLabel = "buy gift3",
                                onClick = {
                                    /*TODO*/
                                    buying.value = 6
                                }
                            )
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    Image(
                        painter = painterResource(id = R.drawable.shop_gift_4),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(88.dp, 138.dp)
                            .clickable(
                                enabled = !openDialog.value,
                                onClickLabel = "buy gift4",
                                onClick = {
                                    /*TODO*/
                                    buying.value = 7
                                }
                            )
                    )
                }
            }
            if(buying.value>-1){
                openDialog.value = true
                boughtflag.value=false
            }
        }
        if(openDialog.value){
            if(buying.value<=2) spending.value=buyingPopupScreen(buying.value)
            else spending.value=buyinggiftPopupScreen()
            if(spending.value>0){
                boughtflag.value=true
                if(spending.value/1000 == 5){
                    viewModel.onEvent(ItemEvent.UpdateOwnedQuantity(2,+1))
                }else if(spending.value/1000<=2){
                    sceneViewModel.onEvent(SceneEvent.SetScene((spending.value/1000)+1,true))
                }
                userViewModel.onEvent(UserEvent.UpdateMoney(-(spending.value%1000)))
            }
            if(spending.value >= 0){
                buying.value=-1
                openDialog.value=false
            }

        }

    }
}

@Preview
@Composable
fun ShopPagePreview() {
    ShopPage(navController = NavController(LocalContext.current))
}