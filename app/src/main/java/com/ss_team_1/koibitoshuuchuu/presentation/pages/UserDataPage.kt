package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.ui.theme.*
import java.util.*

@Composable
fun UserDataPage(navController: NavController) {
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
            UserData_Info_1(
                userPhoto = R.drawable.profile_picture1.toString(),
                userName = "酷酷的名字",
                userID = 1234567,
                userGender = "酷酷的草履蟲",
                userBirthday = Calendar.getInstance()
            )
            UserData_Info_2(
                joinYear = 2022,
                joinMonth = 12,
                joinDay = 32,
                accumulatedDay = 30,
                accumulatedHour = 10
            )
            Spacer(modifier = Modifier.padding(10.dp))
            UserData_Info_3(
                userBirthday = Calendar.getInstance(),
                userGender = "酷酷的草履蟲"
            )
        }
        Box(
            modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth(1f)
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
                text = "早上好 酷酷的名字",
                fontStyle = FontStyle(R.font.mamelon),
                color = Color.Black,
                fontSize = 21.sp,
                modifier = Modifier.padding(
                    start = 55.dp,
                    top = 105.dp,
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserDataPagePreview() {
    UserDataPage(navController = NavController(LocalContext.current))
}