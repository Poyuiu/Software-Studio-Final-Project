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
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.Page
import com.ss_team_1.koibitoshuuchuu.ui.theme.*

val shopBuySceneHead= listOf(
    R.string.shop_buying_scnen0_head
)
val shopBuySceneBody = listOf(
    R.string.shop_buying_scene0_body
)

@Preview
@Composable
fun SceneBuying():Int{
    val spend = remember { mutableStateOf(1) }//沒暗任何案件
    Column(
        modifier = Modifier
            .width(280.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = shopBuySceneHead[0]),
            fontSize = 20.sp,
            //color = secUn,
            fontStyle = FontStyle(contextFont),
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = stringResource(id = shopBuySceneBody[0]),
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
                    text = "物品價格: 100",
                    fontSize = 14.sp,
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
                    .align(Alignment.CenterEnd),
                //verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "總金額:     100",
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
                            onClickLabel = "unlock click",
                            onClick = {
                                /*TODO*/
                                spend.value =-100
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
fun buyingPopupScreen():Int{
    val spend = remember { mutableStateOf(1) }//沒暗任何案件
    Box(
        Modifier.fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f), RectangleShape)
    ){
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(280.dp))
            spend.value = SceneBuying()
        }

    }
    return spend.value
}