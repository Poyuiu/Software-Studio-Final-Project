package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.Page
import com.ss_team_1.koibitoshuuchuu.ui.theme.KoiBitoShuuChuuTheme

@Composable
fun WelcomePage(navController: NavController = NavController(LocalContext.current)) {
    R.string.detail
    Box(
        Modifier
            .fillMaxSize()
            .clickable(
                enabled = true,
                onClickLabel = "Welcomepage click",
                onClick = {
                    navController.navigate(Page.Home.route)
                }
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        //這個式子只能用手算的 phone: x=1080f y=904
        //StrokeText(LocalContext.current,"戀人專注", 204f,180,168f)//每個字的寬度=size

    }
}

@Preview
@Composable
fun WelcomePagePreview() {
    KoiBitoShuuChuuTheme {
        WelcomePage(NavController(LocalContext.current))
    }
}