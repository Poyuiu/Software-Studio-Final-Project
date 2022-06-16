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
import androidx.hilt.navigation.compose.hiltViewModel
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.domain.model.Item
import com.ss_team_1.koibitoshuuchuu.presentation.event.ItemEvent
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.ItemViewModel
import com.ss_team_1.koibitoshuuchuu.ui.theme.AccentDark
import com.ss_team_1.koibitoshuuchuu.ui.theme.black
import com.ss_team_1.koibitoshuuchuu.ui.theme.contextFont
import com.ss_team_1.koibitoshuuchuu.ui.theme.mainFont

val giveGiftPhotoList = listOf(
    R.drawable.give_gift0,
    R.drawable.give_gift1,
    R.drawable.give_gift2,
    R.drawable.give_gift3,
    R.drawable.give_gift4
)
val itemIntimacyAddList = listOf(
    1, 5, 100, 2, 2
)

//@Preview(showBackground = true)
@Composable
fun GiveGiftPopupScreen(
    itemViewModel: ItemViewModel ,
    itemlist: List<Item>,
    amount: Int,
    chooseItem: Int,
    intimacyUpdate: Int,
    kindsOfItem: Int,
    onClickLeft: () -> Unit,
    onClickRight: () -> Unit,
    onClickMinus: () -> Unit,
    onClickPlus: () -> Unit,
    onClickCancel: () -> Unit,
    onClickConfirm: () -> Unit
){
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
                Spacer(modifier = Modifier.height(240.dp))
                Column(
                    modifier = Modifier
                        .width(280.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(id = R.string.Give_character_gift_header),
                        fontSize = 24.sp,
                        color = black,
                        fontStyle = FontStyle(contextFont),
                        modifier = Modifier.padding(16.dp)
                    )
                    Box(modifier = Modifier.fillMaxWidth()){
                        Column(
                            Modifier.fillMaxWidth().height(160.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Image(
                                painter = painterResource(id = giveGiftPhotoList[itemlist[chooseItem].id]),
                                contentDescription = "",
                                contentScale = ContentScale.Fit
                            )
                        }
                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                        ){
                            if(chooseItem !=0){
                                Image(
                                    painter = painterResource(id = R.drawable.profile_arrow_left),
                                    contentDescription = "",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier
                                        .size(40.dp,64.dp)
                                        .clickable(
                                            enabled = true,
                                            onClickLabel = "clear",
                                            onClick = onClickLeft
                                        )
                                )
                            }

                            Spacer(modifier = Modifier.width(164.dp))
                            if(chooseItem != kindsOfItem){
                                Image(
                                    painter = painterResource(id = R.drawable.profile_arrow_right),
                                    contentDescription = "",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier
                                        .size(40.dp,64.dp)
                                        .clickable(
                                            enabled = true,
                                            onClickLabel = "clear",
                                            onClick = onClickRight
                                        )
                                )
                            }else{
                                Spacer(modifier = Modifier.width(28.dp))
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                    ){
                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                        ){
                            Spacer(modifier = Modifier.width(24.dp))
                            Text(
                                text = "數量:",
                                fontSize = 16.sp,
                                color = black,
                                fontStyle = FontStyle(contextFont)
                            )
                            Spacer(modifier = Modifier.width(24.dp))
                            Image(
                                painter = painterResource(id = R.drawable.ic_minus),
                                contentDescription = "",
                                contentScale = ContentScale.Fit,
                                colorFilter = if(amount>1) null
                                else ColorFilter.tint(color = Color.Gray),
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable(
                                        enabled = (amount>1),
                                        onClickLabel = "minus gift",
                                        onClick = onClickMinus
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
                                        text = "$amount",
                                        fontSize = 16.sp,
                                        color = black,
                                        fontStyle = FontStyle(contextFont)
                                    )
                                }

                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Image(
                                painter = painterResource(id = R.drawable.ic_plus),
                                contentDescription = "",
                                contentScale = ContentScale.Fit,
                                colorFilter = if(amount < itemlist[chooseItem].quantity_owned)null
                                else ColorFilter.tint(color = Color.Gray),
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable(
                                        enabled = (amount< itemlist[chooseItem].quantity_owned),
                                        onClickLabel = "plus gift",
                                        onClick = onClickPlus
                                    )
                            )
                        }
                    }
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                        ){
                            Spacer(modifier = Modifier.width(24.dp))
                            Text(
                                text = "將提升的好感度:   ${itemIntimacyAddList[itemlist[chooseItem].id]*amount}",
                                fontSize = 16.sp,
                                color = black,
                                fontStyle = FontStyle(contextFont),
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                        ){
                            Spacer(modifier = Modifier.width(24.dp))
                            Text(
                                text = "擁有物品:   ${itemlist[chooseItem].quantity_owned} 個",
                                fontSize = 16.sp,
                                color = black,
                                fontStyle = FontStyle(contextFont),
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                    Box(modifier = Modifier.fillMaxWidth()){
                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                        ){
                            Text(
                                text = "取消",
                                fontSize = 24.sp,
                                fontStyle = FontStyle(mainFont),
                                modifier = Modifier.padding(8.dp)
                                    .clickable(
                                        enabled = true,
                                        onClickLabel = "doesn't buy",
                                        onClick = onClickCancel
                                    )
                            )
                            Spacer(modifier = Modifier.width(100.dp))
                            Text(
                                text = "送給她",
                                fontSize = 24.sp,
                                fontStyle = FontStyle(mainFont),
                                color = AccentDark,
                                modifier = Modifier.padding(8.dp)
                                    .clickable(
                                        enabled = true,
                                        onClickLabel = "give",
                                        onClick = onClickConfirm
                                    )
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}