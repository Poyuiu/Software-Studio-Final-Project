package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.event.ItemEvent
import com.ss_team_1.koibitoshuuchuu.presentation.event.SceneEvent
import com.ss_team_1.koibitoshuuchuu.presentation.event.UserEvent
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.UserViewModel
import com.ss_team_1.koibitoshuuchuu.ui.theme.*
import java.util.*

@Composable
fun UserDataPage(
    navController: NavController,
    userViewModel: UserViewModel = hiltViewModel()
) {
    val openDialog = remember { mutableStateOf(false) }
    val userName = userViewModel.state.value.userInfo.user_name
    val joinDate: Calendar = userViewModel.state.value.userInfo.join_date
    val userBirthday: Calendar = userViewModel.state.value.userInfo.birthday
    val userGender: String = userViewModel.state.value.userInfo.gender
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.background_only_color),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        TopBar(button1 = { BackButton(navController) })
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(bottom = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Row(modifier = Modifier.padding(20.dp)) {
                Box() {
                    Image(
                        painter = painterResource(id = R.drawable.profile_picture1),
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .size(130.dp)
                            .clip(CircleShape)
                            .border(
                                3.dp, GreenBlue, CircleShape
                            )
                    )
                    Image(
                        painter = painterResource(id = R.drawable.userdata_icon_pen),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.BottomEnd)
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        text = userName,
                        fontStyle = FontStyle(R.font.mamelon),
                        color = Color.Black,
                        fontSize = 32.sp
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "ID 1234567",
                        fontStyle = FontStyle(R.font.mamelon),
                        color = Color.Black,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                    )
                }
                Column {
                    Spacer(modifier = Modifier.padding(14.dp))
                    Image(
                        painter = painterResource(id = R.drawable.userdata_icon_pen),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable(
                                enabled = true,
                                onClickLabel = "change name",
                                onClick = {
                                    /*TODO*/
                                    openDialog.value = true
                                }
                            )
                    )
                }
            }
            UserData_Info_2(
                joinYear = joinDate.get(Calendar.YEAR),
                joinMonth = joinDate.get(Calendar.MONTH),
                joinDay = joinDate.get(Calendar.DAY_OF_MONTH),
                accumulatedDay = 30,
                accumulatedHour = 10
            )
            Spacer(modifier = Modifier.padding(10.dp))
            UserData_Info_3(
                userBirthday = userBirthday,
                userGender = userGender
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth(1f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.userdata_pitcure_1),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 140.dp, height = 190.dp)
                    .align(Alignment.BottomEnd)
            )
            Image(
                painter = painterResource(id = R.drawable.userdata_conversation_1),
                contentDescription = null,
                modifier = Modifier
                    .size(height = 180.dp, width = 250.dp)
                    .padding(start = 40.dp, top = 40.dp)
            )
            Text(
                text = "早上好 $userName",
                fontStyle = FontStyle(R.font.mamelon),
                color = Color.Black,
                fontSize = 21.sp,
                modifier = Modifier.padding(
                    start = 55.dp,
                    top = 105.dp,
                )
            )
        }
        if (openDialog.value) {
            if (ChangeNamePopUp())
                openDialog.value = false
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserDataPagePreview() {
    UserDataPage(navController = NavController(LocalContext.current))
}