package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.layout.Arrangement.Absolute.Center
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
import com.ss_team_1.koibitoshuuchuu.presentation.utils.PageId
import com.ss_team_1.koibitoshuuchuu.ui.theme.Secondary

@Preview
@Composable
private fun NavigationBarPreview() {
    NavigationBar(navController = NavController(LocalContext.current), selectedPage = PageId.home)
}

@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    selectedPage: PageId
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
            NavigationHomeButton(navController, selectedPage == PageId.home)
            NavigationProfileButton(navController, selectedPage == PageId.profile)
            NavigationShopButton(navController, selectedPage == PageId.shop)
        }
    }
}
/*TODO
* Size tweaking (Not sure what happens when the screen size changes)
 */