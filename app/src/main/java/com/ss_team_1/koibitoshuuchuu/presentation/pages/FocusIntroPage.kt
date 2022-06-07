package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.components.*

@Preview
@Composable
fun FocusIntroPage() {
    KBSCScaffold(
        navbarEnable = false,
        backgroundResourceId = R.drawable.coffee_shop_background
    ) {
        Image(
            painter = painterResource(id = R.drawable.shikieiki_main),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize(0.84f)
                .align(Alignment.Center),
            contentScale = ContentScale.Fit
        )
        Column(
            modifier = Modifier
                .padding(44.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            FocusIntroTimepickerButton()
            FocusIntroWorkTextField()
            FocusIntroSceneButton()
            Spacer(modifier = Modifier.size(20.dp))
            AccentButtonTemplate(onClick = {}) {
                Text(text = "START")
            }
        }
    }
}
