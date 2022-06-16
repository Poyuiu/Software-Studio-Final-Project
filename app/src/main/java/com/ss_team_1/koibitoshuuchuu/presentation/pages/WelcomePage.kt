package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.Page
import com.ss_team_1.koibitoshuuchuu.presentation.components.RoundButtonTemplate
import com.ss_team_1.koibitoshuuchuu.presentation.event.PlotStateEvent
import com.ss_team_1.koibitoshuuchuu.presentation.event.SceneEvent
import com.ss_team_1.koibitoshuuchuu.presentation.utils.ResourceStorer
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.PlotStateViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.SceneViewModel
import com.ss_team_1.koibitoshuuchuu.ui.theme.KoiBitoShuuChuuTheme

@Composable
fun WelcomePage(navController: NavController = NavController(LocalContext.current)) {
    R.string.detail
    val debugInit = false
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
    if (debugInit) {
        val plotStateViewModel: PlotStateViewModel = hiltViewModel()
        val sceneViewModel: SceneViewModel = hiltViewModel()
        RoundButtonTemplate(
            icon = Icons.Outlined.HelpOutline,
            iconSize = 36.dp,
            onClick = {
                val character_count = ResourceStorer.character.size
                for (i in 0 until character_count) {
                    val plot_count = ResourceStorer.character[i].plotList.size
                    for (j in 0 until plot_count) {
                        plotStateViewModel.onEvent(
                            PlotStateEvent.SetPlotStateValue(
                                characterId = i,
                                plotNum = j,
                                newValue = false
                            )
                        )
                    }
                }
                // reset scenes
                for (id in (0..3)) {
                    sceneViewModel.onEvent(SceneEvent.SetScene(id, false))
                }
            }
        )
    }
}

@Preview
@Composable
fun WelcomePagePreview() {
    KoiBitoShuuChuuTheme {
        WelcomePage(NavController(LocalContext.current))
    }
}