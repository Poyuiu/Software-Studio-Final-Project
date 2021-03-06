package com.ss_team_1.koibitoshuuchuu.presentation.pages

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.Page
import com.ss_team_1.koibitoshuuchuu.presentation.components.*
import com.ss_team_1.koibitoshuuchuu.presentation.event.CharacterEvent
import com.ss_team_1.koibitoshuuchuu.presentation.event.ItemEvent
import com.ss_team_1.koibitoshuuchuu.presentation.event.UserEvent
import com.ss_team_1.koibitoshuuchuu.presentation.sceneIdList
import com.ss_team_1.koibitoshuuchuu.presentation.utils.PageId
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.CharacterViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.ItemViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.LastFocusSettingViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.UserViewModel
import com.ss_team_1.koibitoshuuchuu.ui.theme.Secondary
import java.util.*

//@Preview
@Composable
fun HomePage(
    navController: NavController = NavController(LocalContext.current),
    viewModel: CharacterViewModel = hiltViewModel(),
    itemViewModel: ItemViewModel = hiltViewModel(),
    focusSetViewModel: LastFocusSettingViewModel = hiltViewModel(),
    userViewModel: UserViewModel = hiltViewModel(),
    onClickToCharacterInfo: (Int) -> Unit
) {
    val state = viewModel.state.value
    val itemState = itemViewModel.state.value
    val focusState = focusSetViewModel.state.value
    val openDialog1 = remember { mutableStateOf(false) }
    val popup = remember { mutableStateOf(0) }
    val openDialog2 = remember { mutableStateOf(false) }
    val intimacyupdate = remember { mutableStateOf(-1) }
    val openDialogNoGift = remember { mutableStateOf(false) }
    val popupNoGift = remember { mutableStateOf(0) }
    val clickedHelp = remember { mutableStateOf(false) }
    val popupHelp = remember { mutableStateOf(0) }
    val characterid: MutableState<Int> =
        remember { mutableStateOf(0) }


    val itemList = itemState.Items.filter { it.quantity_owned>0 }

/***givegiftpopup***/
    val kindsOfItem = itemList.indexOfLast{true}
    val chooseItem = remember { mutableStateOf(0) }
    val amount = remember { mutableStateOf(1) }

    // set the join date in homepage avoid user being not in
    // profile page at the first time
    val joinDate: Calendar = userViewModel.state.value.userInfo.join_date
    if (joinDate.get(Calendar.YEAR)== 1970){
        userViewModel.onEvent(UserEvent.SetJoinDate(Calendar.getInstance()))
    }
    // character animation
    // take false left and true right
    var characterMoveRight by remember { mutableStateOf(false) }
    fun characterAdd() {
        if (characterid.value < 2) {
            characterid.value += 1
        } else {
            characterid.value = 0
        }
        characterMoveRight = true
    }

    fun characterMinus() {
        if (characterid.value > 0) {
            characterid.value -= 1
        } else {
            characterid.value = 2
        }
        characterMoveRight = false
    }

    // Image drag
    var imageOffset by remember { mutableStateOf(0f) }
    var onDragState by remember { mutableStateOf(false) }
    val imageThreshold = with(LocalDensity.current) { 100.dp.toPx() }

    if (onDragState) {
//        Log.d("focus", "dragged")
        if (imageOffset > imageThreshold) {
            characterAdd()
            onDragState = false
//            Log.d("focus", "add chara")
        } else if (imageOffset < -imageThreshold) {
            characterMinus()
            onDragState = false
//            Log.d("focus", "minus chara")
        }

    }



    Box(
        Modifier
            .fillMaxSize()
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState(onDelta = { delta ->
                    imageOffset += delta
//                    Log.d("focus", "offset: $imageOffset")
                }),
                onDragStarted = {
//                    Log.d("focus", "onDragStart")
                    onDragState = true
                },
                onDragStopped = {
//                    Log.d("focus", "onDragStopped")
                    onDragState = false
                    imageOffset = 0f
                }
            )
    ) {

        val lock =
            state.characters[characterid.value].level == 0 //&& state.characters[characterid.value].intimacy == 0

        //var checkedState by rememberSaveable { mutableStateOf(false) }

        Image(
            painter = painterResource(id = sceneIdList[focusState.lastFocusSetting.sceneId]),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        //TopBar(button1 = { SettingsButton() }, button2 = { HelpButton() })
        androidx.compose.material.Surface(
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(4f),
            shape = TopBarShape(),
            color = Secondary,
            elevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .padding(bottom = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SettingsButton {
                    navController.navigate(Page.Settings.route)
                }
                RoundButtonTemplate(
                    icon = Icons.Outlined.HelpOutline,
                    iconSize = 36.dp,
                    onClick = {
                        clickedHelp.value = true
                    }
                )
            }

        }
        NavigationBar(modifier = Modifier.align(Alignment.BottomCenter), navController, PageId.home)
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(64.dp))
//            if (intimacyLevel != null && intimacy != null && levelIntimacyNeed !=null) {
//                HomepageCharacter(intimacyLevel,intimacy,levelIntimacyNeed,
//                    LocalContext.current, lock,characterid.value)
//            }else {
//                HomepageCharacter(0,0,100,
//                    LocalContext.current, lock,characterid.value)
//            }
            HomepageCharacter(
                intimacyLevel = state.characters[characterid.value].level,
                intimacy = state.characters[characterid.value].intimacy,
                levelIntimacyNeed = state.characters[characterid.value].intimacyNeeded(),
                context = LocalContext.current,
                lock = lock,
                characterId = characterid.value,
                moveRight = characterMoveRight,
                onClickToCharacterInfo = { onClickToCharacterInfo(characterid.value) },
                enable = !(openDialog1.value || openDialog2.value || openDialogNoGift.value || clickedHelp.value)
            )
        }
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(!lock){
                Box(Modifier.size(144.dp, 40.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.give_gift_button),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable(
                                enabled = !(openDialog1.value || openDialog2.value || openDialogNoGift.value || clickedHelp.value),
                                onClickLabel = "give gift",
                                onClick = {
                                    if (itemList.isNotEmpty()) {
                                        openDialog2.value = true
                                    } else {
                                        openDialogNoGift.value = true
                                    }
                                }
                            )
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
            Box(
                Modifier
                    .size(216.dp, 66.dp)
            ) {
                if (lock) {
                    Image(
                        painter = painterResource(id = R.drawable.focus_button_unlock),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable(
                                enabled = !(openDialog1.value || openDialog2.value || openDialogNoGift.value || clickedHelp.value),
                                onClickLabel = "unlock click",
                                onClick = {
                                    /*TODO*/
                                    openDialog1.value = true
                                }
                            )
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.focus_button),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable(
                                enabled = !(openDialog1.value || openDialog2.value || openDialogNoGift.value || clickedHelp.value),
                                onClickLabel = "focus click",
                                onClick = {
                                    navController.navigate(Page.FocusIntro.route + "/${characterid.value}")
                                }
                            )
                    )
                }

            }
            Spacer(modifier = Modifier.height(100.dp))
        }
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .clickable(
                    enabled = !(openDialog1.value || openDialog2.value || openDialogNoGift.value || clickedHelp.value),
                    onClickLabel = "Clickable right shift",
                    onClick = {
                        characterAdd()
                    }
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            rightRoundedTriangle()
        }
        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .clickable(
                    enabled = !(openDialog1.value || openDialog2.value || openDialogNoGift.value || clickedHelp.value),
                    onClickLabel = "Clickable left shift",
                    onClick = {
                        characterMinus()
                    }
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            leftRoundedTriangle()
        }
    }
    if (clickedHelp.value) {
        popupHelp.value = HelpPopupScreen()
        if (popupHelp.value == 1) {
            clickedHelp.value = false
        }
    }

    if (openDialog1.value) {
        popup.value = UnlockPopupScreen()
        if (popup.value == 1) {
            openDialog1.value = false
        } else if (popup.value == 2) {
            openDialog1.value = false
            if(itemList.isNotEmpty()){
                openDialog2.value = true
            } else {
                openDialogNoGift.value = true
            }
        }
    } else if (openDialogNoGift.value) {
        popupNoGift.value = NoGiftPopupScreen()
        if (popupNoGift.value == 1) {
            openDialogNoGift.value = false
        } else if (popupNoGift.value == 2) {
            navController.navigate(Page.Shop.route)
            openDialogNoGift.value = false
        }
    } else if (openDialog2.value) {
        GiveGiftPopupScreen( itemViewModel, itemlist = itemList, amount.value,
                                    chooseItem.value,intimacyupdate.value, kindsOfItem,
        onClickLeft = {
            chooseItem.value--
            amount.value = 1},
        onClickRight = {
            chooseItem.value++
            amount.value = 1 },
        onClickMinus = {amount.value--},
        onClickPlus = {amount.value++},
        onClickCancel = {intimacyupdate.value = 0},
        onClickConfirm = {
            intimacyupdate.value =
            itemIntimacyAddList[itemList[chooseItem.value].id]*amount.value
            itemViewModel.onEvent(ItemEvent.UpdateOwnedQuantity(itemList[chooseItem.value].id, -(amount.value))) }
        )
        if (intimacyupdate.value >= 0) {
            openDialog2.value = false
            viewModel.onEvent(CharacterEvent.UpdateIntimacy(characterid.value, intimacyupdate.value))
        }
    }
}

