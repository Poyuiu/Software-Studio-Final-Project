package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.ui.theme.Secondary

@Preview
@Composable
private fun NavigationBarPreview() {
    NavigationBar(navController = NavController(LocalContext.current))
}

@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Surface(
        color = Secondary,
        modifier = modifier
            .fillMaxWidth()
            .zIndex(4f)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 25.5.dp),
            horizontalArrangement = Center
        ) {
            NavigationHomeButton()
            NavigationProfileButton()
            NavigationShopButton()
        }
    }
}
/*TODO
* Fix the little border line around buttons
* Navigation and the selected form
* Size tweaking (Not sure what happens when the screen size changes)
 */