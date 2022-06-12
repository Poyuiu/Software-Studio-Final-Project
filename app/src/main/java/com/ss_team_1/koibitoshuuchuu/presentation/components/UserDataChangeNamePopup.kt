package com.ss_team_1.koibitoshuuchuu.presentation.components


import android.service.autofill.UserData
import android.service.autofill.Validators.or
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.event.LastFocusSettingEvent
import com.ss_team_1.koibitoshuuchuu.presentation.event.UserEvent
import com.ss_team_1.koibitoshuuchuu.presentation.utils.OutlinedText
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.LastFocusSettingViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.UserViewModel
import com.ss_team_1.koibitoshuuchuu.ui.theme.*

@Preview
@Composable
fun ChangeNameDialog(
    userViewModel: UserViewModel = hiltViewModel()
): Boolean {
    val cancel = remember {
        mutableStateOf(false)
    }
    val confirm = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .width(340.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.change_name_dialog_title),
            fontSize = 32.sp,
            //color = secUn,
            fontStyle = FontStyle(contextFont),
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = stringResource(id = R.string.change_name_dialog_content),
            fontSize = 19.sp,
            fontStyle = FontStyle(contextFont)
        )
        Spacer(modifier = Modifier.padding(10.dp))

        ChangeNameTextField(
//            onValueChange = { it ->
//                userViewModel.onEvent(UserEvent.SetUserName(it))
//            },
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                //verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "CANCEL",
                    fontSize = 14.sp,
                    fontStyle = FontStyle(mainFont),
                    color = grayLine,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable(
                            enabled = true,
                            onClickLabel = "doesn't buy",
                            onClick = {
                                /*TODO*/
                                cancel.value = true
                            }
                        )
                )
                Text(
                    text = "COMFIRM",
                    fontSize = 14.sp,
                    fontStyle = FontStyle(mainFont),
                    color = AccentDark,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable(
                            enabled = true,
                            onClickLabel = "buy gift",
                            onClick = {
                                /*TODO*/
                                confirm.value = true
                            }
                        )
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
    return cancel.value || confirm.value
}

@Preview(showBackground = true)
@Composable
fun ChangeNamePopUp(): Boolean {
    val spend = remember { mutableStateOf(false) }//沒暗任何案件
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f), RectangleShape)
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            spend.value = ChangeNameDialog()
        }
    }
    return spend.value
}

@Preview
@Composable
private fun FocusIntroWorkTextFieldPreview() {
    ChangeNameTextField(
//        onValueChange = {},
//        FocusRequester(),
//        LocalFocusManager.current
    )
}

@Composable
fun ChangeNameTextField(
//    onValueChange: (String) -> Unit,
//    focusRequester: FocusRequester,
//    focusManager: FocusManager,
    userViewModel: UserViewModel = hiltViewModel()
) {
    val userName = remember {
        userViewModel.state.value.userInfo.user_name
    }
    var textState by remember { mutableStateOf(TextFieldValue(userName)) }
    Column {
        Box(
            modifier = Modifier
                .size(width = 240.dp, height = 50.dp)
                //.clip(RoundedCornerShape(17.dp))
                .background(color = GreenBlue.copy(alpha = 0.5f), shape = RoundedCornerShape(17.dp))
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(17.dp)),
            contentAlignment = Alignment.Center
        ) {
            BasicTextField(
                value = textState,
                onValueChange = {
                    textState = it
                    userViewModel.onEvent(UserEvent.SetUserName(textState.text))
                },
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp,
                    fontFamily = huninnFamily
                ),
            )
        }
    }
}