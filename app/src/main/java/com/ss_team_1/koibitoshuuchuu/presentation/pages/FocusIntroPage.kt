package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.Page
import com.ss_team_1.koibitoshuuchuu.presentation.components.*
import com.ss_team_1.koibitoshuuchuu.ui.theme.mamelonFamily

@Preview
@Composable
fun FocusIntroPage(navController: NavController = NavController(LocalContext.current)) {
    var timePickerOpenState by remember {
        mutableStateOf(false)
    }
    KBSCScaffold(
        navController = navController,
        navbarEnable = false,
        backgroundResourceId = R.drawable.coffee_shop_background
    ) {
        Image(
            painter = painterResource(id = R.drawable.character_0_photo_main),
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
            FocusIntroTimePickerButton()
            FocusIntroWorkTextField()
            FocusIntroScenePicker()
            Spacer(modifier = Modifier.size(20.dp))
            // Start Button
            AccentButtonTemplate(onClick = { navController.navigate(Page.Focus.route) }) {
                Text(text = "START", fontSize = 32.sp, fontFamily = mamelonFamily)
            }
        }
    }
}
