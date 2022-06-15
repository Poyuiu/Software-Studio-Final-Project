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
//@Preview
@Composable
fun GiveCharacterGift(
    itemViewModel: ItemViewModel = hiltViewModel(),
    itemlist: List<Item>
): Int{
    val kindsOfItem = itemlist.indexOfLast{true}
    val intimacyupdate = remember { mutableStateOf(-1) }//沒暗任何案件
    val chooseItem = remember { mutableStateOf(0) }
    val amount = remember { mutableStateOf(1) }
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
            //color = secUn,
            fontStyle = FontStyle(contextFont),
            modifier = Modifier.padding(16.dp)
        )
        Box(modifier = Modifier.fillMaxWidth()){
            Column(
                Modifier.fillMaxWidth().height(160.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(id = giveGiftPhotoList[itemlist[chooseItem.value].id]),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    //modifier = Modifier .width(photoWidthList[helpid.value])
                )
            }
            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                //verticalAlignment = Alignment.CenterVertically
            ){
                if(chooseItem.value !=0){
                    Image(
                        painter = painterResource(id = R.drawable.profile_arrow_left),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(40.dp,64.dp)
                            .clickable(
                                enabled = true,
                                onClickLabel = "clear",
                                onClick = {
                                    /*TODO*/
                                    chooseItem.value--
                                    amount.value = 1
                                }
                            )
                    )
                }

                Spacer(modifier = Modifier.width(164.dp))
                if(chooseItem.value != kindsOfItem){
                    Image(
                        painter = painterResource(id = R.drawable.profile_arrow_right),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(40.dp,64.dp)
                            .clickable(
                                enabled = true,
                                onClickLabel = "clear",
                                onClick = {
                                    /*TODO*/
                                    chooseItem.value++
                                    amount.value = 1
                                }
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
                    colorFilter = if(amount.value < itemlist[chooseItem.value].quantity_owned)null
                            else ColorFilter.tint(color = Color.Gray),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(
                            enabled = (amount.value < itemlist[chooseItem.value].quantity_owned),
                            onClickLabel = "plus gift",
                            onClick = {
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
                    .align(Alignment.CenterStart),
                //verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    text = "將提升的好感度:   ${itemIntimacyAddList[itemlist[chooseItem.value].id]*amount.value}",
                    fontSize = 16.sp,
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
                    .align(Alignment.CenterStart),
                //verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    text = "擁有物品:   ${itemlist[chooseItem.value].quantity_owned} 個",
                    fontSize = 16.sp,
                    fontStyle = FontStyle(contextFont),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth()){
            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                //verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "取消",
                    fontSize = 24.sp,
                    fontStyle = FontStyle(mainFont),
                    modifier = Modifier.padding(8.dp)
                        .clickable(
                            enabled = true,
                            onClickLabel = "doesn't buy",
                            onClick = {
                                intimacyupdate.value = 0
                            }
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
                            onClick = {
                                intimacyupdate.value =
                                    itemIntimacyAddList[itemlist[chooseItem.value].id]*amount.value
                                itemViewModel.onEvent(ItemEvent.UpdateOwnedQuantity
                                    (itemlist[chooseItem.value].id, -(amount.value)))
                            }
                        )
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
    return intimacyupdate.value
}

//@Preview(showBackground = true)
@Composable
fun GiveGiftPopupScreen(
    itemViewModel: ItemViewModel = hiltViewModel(),
    itemlist: List<Item>
): Int{
    val intimacyupdate = remember { mutableStateOf(-1) }//沒暗任何案件
    Box(
        Modifier.fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f), RectangleShape)
    ){
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(240.dp))
            intimacyupdate.value = GiveCharacterGift( itemViewModel,itemlist)
        }
    }
    return intimacyupdate.value
}