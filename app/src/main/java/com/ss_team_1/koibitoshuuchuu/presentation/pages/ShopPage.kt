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
    buyflag: Boolean
) {
    val openDialog = remember { mutableStateOf(false) }
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
                .align(Alignment.TopCenter)
                .clickable(
                    enabled = true,
                    onClickLabel = "Welcomepage click",
                    onClick = {
                        openDialog.value = true
                    }
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            money_diamond_bar(100000, 400)
            if (buyflag) {
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
            ShopSceneGoods()
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

        if (openDialog.value) {

            AlertDialog(
                onDismissRequest = {
                    // Dismiss the dialog when the user clicks outside the dialog or on the back
                    // button. If you want to disable that functionality, simply use an empty
                    // onCloseRequest.
                    openDialog.value = false
                },
                title = {
                    Text(text = "Dialog Title")
                },
                text = {
                    Text("Here is a text ")
                },
                confirmButton = {
                    Button(

                        onClick = {
                            openDialog.value = false
                        }) {
                        Text("This is the Confirm Button")
                    }
                },
                dismissButton = {
                    Button(

                        onClick = {
                            openDialog.value = false
                        }) {
                        Text("This is the dismiss Button")
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun ShopPagePreview() {
    ShopPage(navController = NavController(LocalContext.current), true)
}