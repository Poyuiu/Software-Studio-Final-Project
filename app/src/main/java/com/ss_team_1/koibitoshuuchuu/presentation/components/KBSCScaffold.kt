package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.ss_team_1.koibitoshuuchuu.R

@Preview
@Composable
private fun KBSCScaffoldPreview() {
    KBSCScaffold(button1 = { BackButton() }) {
        Image(
            painter = painterResource(id = R.drawable.shikieiki_main),
            contentDescription = "",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun KBSCScaffold(
    topBarEnable: Boolean = true,
    navbarEnable: Boolean = true,
    button1: (@Composable() () -> Unit) = { BackButton() },
    button2: (@Composable() () -> Unit) = {},
    content: @Composable() BoxScope.() -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.background),
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
            NavigationBar(modifier = Modifier.align(Alignment.BottomCenter))
        }
        content()
    }
}