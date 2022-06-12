package com.ss_team_1.koibitoshuuchuu.presentation.pages

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.Page
import com.ss_team_1.koibitoshuuchuu.presentation.characterphotolist
import com.ss_team_1.koibitoshuuchuu.presentation.components.*
import com.ss_team_1.koibitoshuuchuu.presentation.event.LastFocusSettingEvent
import com.ss_team_1.koibitoshuuchuu.presentation.sceneIdList
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.LastFocusSettingViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.SceneViewModel
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
    mediaPlayer: MediaPlayer,
    viewModel: LastFocusSettingViewModel = hiltViewModel(),
    sceneViewModel: SceneViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
//    var focusTime by remember {
//        mutableStateOf(25)
//    }
    val lazyListState = rememberLazyListState()
    val layoutInfo: LazyListSnapperLayoutInfo =
        rememberLazyListSnapperLayoutInfo(lazyListState = lazyListState)
    val focusRequester = remember {
        FocusRequester()
    }
    val focusManager = LocalFocusManager.current

    /***Time Picker***/
    val focusTime = state.lastFocusSetting.focusTime
    var timePickerOpenState by remember { mutableStateOf(false) }
    fun onTimePickerStart() {
        timePickerOpenState = true
    }

    fun onTimePickerEnd() {
        if (timePickerOpenState)
            viewModel.onEvent(LastFocusSettingEvent.SetLastFocusTime(focusTimeList[layoutInfo.currentItem?.index!!]))
        timePickerOpenState = false
    }

    /***Work TextField***/
    val workDesc = state.lastFocusSetting.work
    var workOpenState by remember { mutableStateOf(false) }
    fun onWorkStart() {
        workOpenState = true
    }

    fun onWorkEnd() {
        if (workOpenState)
            focusManager.clearFocus()
        workOpenState = false
    }

    /***Scene Picker***/
    val sceneId = state.lastFocusSetting.sceneId
    val sceneList = sceneViewModel.state.value.scenes
    var scenePickerOpenState by remember { mutableStateOf(false) }
    fun onScenePickerStart() {
        scenePickerOpenState = true
    }

    fun onScenePickerEnd() {
        scenePickerOpenState = false
    }



    KBSCScaffold(
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(onTap = {
                onTimePickerEnd()
                onWorkEnd()
                onScenePickerEnd()
            })
        },
        navController = navController,
        navbarEnable = false,
        backgroundResourceId = sceneIdList[sceneId]
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
            /***Work TextField***/
            FocusIntroWorkTextField(
                workOpenState = workOpenState,
                onPress = {
                    onWorkStart()
                    onTimePickerEnd()
                    onScenePickerEnd()
                },
                onDone = { },
                workDesc = workDesc, onValueChange = { it ->
                    viewModel.onEvent(LastFocusSettingEvent.SetLastWork(it))
                },
                focusRequester = focusRequester, focusManager = focusManager
            )
            /***Time Picker***/
            FocusIntroTimePickerButton(
                timePickerOpenState = timePickerOpenState,
                lazyListState = lazyListState,
                onClick = {
                    onTimePickerStart()
                    onWorkEnd()
                    onScenePickerEnd()
                },
                onDone = { onTimePickerEnd() },
                layoutInfo = layoutInfo,
                focusTime = focusTime,
                setFocusTime = {
                    viewModel.onEvent(LastFocusSettingEvent.SetLastFocusTime(focusTimeList[layoutInfo.currentItem?.index!!]))
                }
            )
            /***Scene Picker***/
            FocusIntroScenePicker(
                scenePickerOpenState = scenePickerOpenState,
                onClick = {
                    onScenePickerStart()
                    onTimePickerEnd()
                    onWorkEnd()
                },
                onDone = { onScenePickerEnd() },
                sceneId = sceneId,
                sceneList = sceneList.filter { it.is_owned }) {
                viewModel.onEvent(LastFocusSettingEvent.SetLastSceneId(it))
            }
            Spacer(modifier = Modifier.size(20.dp))
            // Start Button
            AccentButtonTemplate(
                onClick = {
                    mediaPlayer.start()
                    navController.navigate(Page.Focus.route + "/$focusTime/$characterId")
                }
            ) {
                Text(text = "START", fontSize = 32.sp, fontFamily = mamelonFamily)
            }
        }
    }
}
