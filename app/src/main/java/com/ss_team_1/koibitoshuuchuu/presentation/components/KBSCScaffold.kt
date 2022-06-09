package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R

@Preview
@Composable
private fun KBSCScaffoldPreview() {
    KBSCScaffold(
        navController = NavController(LocalContext.current),
        button1 = { BackButton() },
        backgroundResourceId = R.drawable.coffee_shop_background
    ) {
        Image(
            painter = painterResource(id = R.drawable.character_0_photo_main),
            contentDescription = "",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun KBSCScaffold(
    navController: NavController,
    topBarEnable: Boolean = true,
    navbarEnable: Boolean = true,
    backgroundResourceId: Int,
    button1: (@Composable() () -> Unit) = { BackButton() },
    button2: (@Composable() () -> Unit) = {},
    content: @Composable() BoxScope.() -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            painter = painterResource(id = backgroundResourceId),
            contentDescription = "background",
            contentScale = ContentScale.FillBounds
        )
        if (topBarEnable) {
            TopBar(
                modifier = Modifier.align(Alignment.TopCenter),
                button1 = button1,
                button2 = button2
            )
        }
        if (navbarEnable) {
            NavigationBar(modifier = Modifier.align(Alignment.BottomCenter), navController)
        }
        content()
    }
}