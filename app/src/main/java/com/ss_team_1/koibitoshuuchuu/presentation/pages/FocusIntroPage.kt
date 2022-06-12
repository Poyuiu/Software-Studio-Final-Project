package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.Page
import com.ss_team_1.koibitoshuuchuu.presentation.components.*
import com.ss_team_1.koibitoshuuchuu.presentation.event.LastFocusSettingEvent
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.LastFocusSettingViewModel
import com.ss_team_1.koibitoshuuchuu.ui.theme.mamelonFamily
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.LazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberLazyListSnapperLayoutInfo

@OptIn(ExperimentalSnapperApi::class)
@Preview
@Composable
fun FocusIntroPage(
    navController: NavController = NavController(LocalContext.current),
    characterId: Int? = 0,
    viewModel: LastFocusSettingViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    var timePickerOpenState by remember {
        mutableStateOf(false)
    }
    var focusTime by remember {
        mutableStateOf(state.lastFocusSetting.focusTime)
    }
    val lazyListState = rememberLazyListState()
    val layoutInfo: LazyListSnapperLayoutInfo =
        rememberLazyListSnapperLayoutInfo(lazyListState = lazyListState)
    KBSCScaffold(
        navController = navController,
        navbarEnable = false,
        backgroundResourceId = R.drawable.coffee_shop_background
    ) {
        Image(
            painter = painterResource(id = characterphotolist[characterId!!]),
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
            FocusIntroTimePickerButton(
                lazyListState = lazyListState,
                layoutInfo = layoutInfo,
                focusTime = focusTime,
                setFocusTime = {
                    focusTime = focusTimeList[layoutInfo.currentItem?.index!!]
                    viewModel.onEvent(LastFocusSettingEvent.SetLastFocusTime(focusTime))
                })
            FocusIntroWorkTextField()
            FocusIntroScenePicker()
            Spacer(modifier = Modifier.size(20.dp))
            // Start Button
            AccentButtonTemplate(
                onClick = { navController.navigate(Page.Focus.route + "/$focusTime/$characterId") }
            ) {
                Text(text = "START", fontSize = 32.sp, fontFamily = mamelonFamily)
            }
        }
    }
}
