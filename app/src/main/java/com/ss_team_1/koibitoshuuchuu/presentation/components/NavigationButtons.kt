package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.Page
import com.ss_team_1.koibitoshuuchuu.ui.theme.Primary
import com.ss_team_1.koibitoshuuchuu.ui.theme.Secondary

//@Preview(showBackground = true)
@Composable
fun NavigationProfileButton(navController:NavController, selected: Boolean) {
    NavigationButtonTemplate(
        onClick = { navController.navigate(Page.Profile.route) },
        selected = selected,
        painter =  painterResource(id = if(selected) R.drawable.ic_profile_pink else R.drawable.ic_profile)
    )
}

//@Preview(showBackground = true)
@Composable
fun NavigationHomeButton(navController:NavController, selected: Boolean) {
    NavigationButtonTemplate(
        onClick = { navController.navigate(Page.Home.route) },
        selected = selected,
        painter = painterResource(id = if(selected) R.drawable.ic_home_pink else R.drawable.ic_home)
    )
}

//@Preview(showBackground = true)
@Composable
fun NavigationShopButton(navController:NavController, selected: Boolean) {
    NavigationButtonTemplate(
        onClick = { navController.navigate(Page.Shop.route) },
        selected = selected,
        painter = painterResource(id = if(selected) R.drawable.ic_shop_pink else R.drawable.ic_shop)
    )
}

@Composable
private fun NavigationButtonTemplate(
    onClick: () -> Unit,
    selected: Boolean,
    painter: Painter
) {
    Button(
        modifier = Modifier.size(width = 120.dp, height = 48.dp),
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (selected) Primary else Secondary
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp
        )
    ) {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier
                .padding(top = 4.dp)
                .size(30.dp)
        )
    }
}

