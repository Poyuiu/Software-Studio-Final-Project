package com.ss_team_1.koibitoshuuchuu.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.Page
import com.ss_team_1.koibitoshuuchuu.presentation.components.*
import com.ss_team_1.koibitoshuuchuu.presentation.event.CharacterEvent
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.CharacterViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.ItemViewModel
import com.ss_team_1.koibitoshuuchuu.ui.theme.Secondary

//@Preview
@Composable
fun HomePage(
    navController: NavController = NavController(LocalContext.current),
    viewModel: CharacterViewModel = hiltViewModel(),
    itemViewModel: ItemViewModel = hiltViewModel(),
    onClickToCharacterInfo: (Int) -> Unit
) {
    val state = viewModel.state.value
    val itemState = itemViewModel.state.value
    val openDialog1 = remember { mutableStateOf(false) }
    val popup = remember { mutableStateOf(0) }
    val openDialog2 = remember { mutableStateOf(false) }
    val intimacyupdate = remember { mutableStateOf(-1) }
    val openDialogNoGift = remember { mutableStateOf(false) }
    val popupNoGift = remember { mutableStateOf(0) }
    val clickedHelp = remember { mutableStateOf(false) }
    Box(
        Modifier.fillMaxSize()
    ) {
        val characterid: MutableState<Int> =
            remember { mutableStateOf(0) }
        val lock = state.characters[characterid.value].level == 0 //&& state.characters[characterid.value].intimacy == 0

        //var checkedState by rememberSaveable { mutableStateOf(false) }

        Image(
            painter = painterResource(id = R.drawable.coffee_shop_background),
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
                SettingsButton()
                clickedHelp.value = HelpButton()
            }

        }
        NavigationBar(modifier = Modifier.align(Alignment.BottomCenter), navController)
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
                onClickToCharacterInfo = { onClickToCharacterInfo(characterid.value) },
                !(openDialog1.value && openDialog2.value)
            )
        }
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /*FocusButton(
                LocalContext.current,
                lock,
                navController
            )*/
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
                                enabled = !(openDialog1.value && openDialog2.value),
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
                                enabled = !(openDialog1.value && openDialog2.value),
                                onClickLabel = "focus click",
                                onClick = {
                                    navController.navigate(Page.FocusIntro.route+"/${characterid.value}")
                                }
                            )
                    )
                }

            }
            Spacer(modifier = Modifier.height(120.dp))
        }
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .clickable(
                    enabled = !(openDialog1.value && openDialog2.value),
                    onClickLabel = "Clickable right shift",
                    onClick = {
                        if (characterid.value < 2) {
                            characterid.value += 1
                        } else {
                            characterid.value = 0
                        }
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
                    enabled = !(openDialog1.value && openDialog2.value),
                    onClickLabel = "Clickable left shift",
                    onClick = {
                        if (characterid.value > 0) {
                            characterid.value -= 1
                        } else {
                            characterid.value = 2
                        }
                    }
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            leftRoundedTriangle()
        }
        if(openDialog1.value){
            popup.value = UnlockPopupScreen()
            if(popup.value==1){
                openDialog1.value=false
            }
            else if(popup.value==2){
                openDialog1.value=false
                if(itemState.Items[2].quantity_owned>0){
                    openDialog2.value=true
                }else{
                    openDialogNoGift.value = true
                }

            }
        }
        else if(openDialogNoGift.value){
            popupNoGift.value = NoGiftPopupScreen()
            if(popupNoGift.value == 1){
                openDialogNoGift.value = false
            }
            else if(popupNoGift.value == 2){
                navController.navigate(Page.Shop.route)
                openDialogNoGift.value = false
            }
        }
        else if(openDialog2.value){
            intimacyupdate.value = GiveGiftPopupScreen()
            if(intimacyupdate.value >= 0){
                openDialog2.value=false
                if(intimacyupdate.value!=0){
                    viewModel.onEvent(CharacterEvent.UpdateIntimacy(characterid.value,100))
                }
            }
        }
    }
}

