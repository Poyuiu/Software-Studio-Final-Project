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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.ui.theme.DarkGreenBlue
import com.ss_team_1.koibitoshuuchuu.ui.theme.GreenBlue
import com.ss_team_1.koibitoshuuchuu.ui.theme.ProfilePink
import com.ss_team_1.koibitoshuuchuu.ui.theme.secUn
import java.util.*

@Composable
fun UserData_Info_1(
//    onClick: () -> Unit,
    userPhoto: String,
    userName: String,
    userID: Long,
    userGender: String,
    userBirthday: Calendar
//    showDetailButton: Boolean
) {
    Row(modifier = Modifier.padding(20.dp)) {
        Box() {
            Image(
                painter = painterResource(id = userPhoto.toInt()),
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
                text = "ID $userID",
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
                modifier = Modifier.size(30.dp)
                    .clickable(
                        enabled = true,
                        onClickLabel = "change name",
                        onClick = {
                            /*TODO*/
                        }
                    )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun UserData_Info_1_Preview() {
    UserData_Info_1(
        userBirthday = Calendar.getInstance(),
        userID = 1234567,
        userGender = "酷酷的草履蟲",
        userName = "酷酷的名字",
        userPhoto = R.drawable.profile_picture1.toString()
    )
}

@Composable
fun UserData_Info_2(
    joinYear: Int,
    joinMonth: Int,
    joinDay: Int,
    accumulatedDay: Int,
    accumulatedHour: Int
) {
    Column(
        modifier = Modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )
            .width(340.dp)
    ) {
        Text(
            text = "加入時間",
            fontStyle = FontStyle(R.font.mamelon_bold),
            color = secUn,
            fontSize = 26.sp,
            modifier = Modifier.padding(
                top = 20.dp,
                start = 20.dp, bottom = 0.dp
            )
        )
        Row {
            Text(
                text = joinYear.toString(),
                fontStyle = FontStyle(R.font.mamelon),
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    top = 5.dp,
                    start = 40.dp, bottom = 0.dp
                )
            )
            Text(
                text = "年",
                fontStyle = FontStyle(R.font.mamelon),
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    top = 5.dp,
                    start = 10.dp, bottom = 0.dp
                )
            )
            Text(
                text = joinMonth.toString(),
                fontStyle = FontStyle(R.font.mamelon),
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    top = 5.dp,
                    start = 10.dp, bottom = 0.dp
                )
            )
            Text(
                text = "月",
                fontStyle = FontStyle(R.font.mamelon),
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    top = 5.dp,
                    start = 10.dp, bottom = 0.dp
                )
            )
            Text(
                text = joinDay.toString(),
                fontStyle = FontStyle(R.font.mamelon),
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    top = 5.dp,
                    start = 10.dp, bottom = 0.dp
                )
            )
            Text(
                text = "日",
                fontStyle = FontStyle(R.font.mamelon),
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    top = 5.dp,
                    start = 10.dp, bottom = 0.dp
                )
            )
        }
        Text(
            text = "累積專心時間",
            fontStyle = FontStyle(R.font.mamelon_bold),
            color = secUn,
            fontSize = 26.sp,
            modifier = Modifier.padding(
                top = 5.dp,
                start = 20.dp, bottom = 0.dp
            )
        )
        Row {
            Text(
                text = accumulatedDay.toString(),
                fontStyle = FontStyle(R.font.mamelon),
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    top = 5.dp,
                    start = 100.dp, bottom = 0.dp
                )
            )
            Text(
                text = "月",
                fontStyle = FontStyle(R.font.mamelon),
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    top = 5.dp,
                    start = 10.dp, bottom = 0.dp
                )
            )
            Text(
                text = accumulatedHour.toString(),
                fontStyle = FontStyle(R.font.mamelon),
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    top = 5.dp,
                    start = 10.dp, bottom = 0.dp
                )
            )
            Text(
                text = "時",
                fontStyle = FontStyle(R.font.mamelon),
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    top = 5.dp,
                    start = 10.dp, bottom = 0.dp
                )
            )
        }
        Spacer(modifier = Modifier.size(15.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun UserData_Info_2_Preview() {
    UserData_Info_2(
        joinYear = 2022,
        joinMonth = 12,
        joinDay = 12,
        accumulatedDay = 30,
        accumulatedHour = 10
    )
}

@Composable
fun UserData_Info_3(
    userGender: String,
    userBirthday: Calendar
) {
    Column(
        modifier = Modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )
            .width(340.dp)
    ) {
        Row(
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(
                text = "性別",
                fontStyle = FontStyle(R.font.mamelon),
                color = DarkGreenBlue,
                fontSize = 32.sp,
                modifier = Modifier.padding(
                    top = 20.dp,
                    start = 20.dp, bottom = 0.dp
                )
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Column {
                Spacer(modifier = Modifier.padding(5.dp))
                Box(modifier = Modifier.background(color = ProfilePink)) {
                    Text(
                        text = userGender,
                        fontStyle = FontStyle(R.font.mamelon),
                        color = Color.Black,
                        fontSize = 26.sp,
                        modifier = Modifier.padding(
                            start = 20.dp,
                            top = 10.dp,
                            end = 40.dp,
                            bottom = 10.dp
                        )
                    )
                    Image(
                        painter = painterResource(id = R.drawable.userdata_icon_pen),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .align(Alignment.BottomEnd)
                    )
                }
            }
        }
        Row(
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(
                text = "生日",
                fontStyle = FontStyle(R.font.mamelon),
                color = DarkGreenBlue,
                fontSize = 32.sp,
                modifier = Modifier.padding(
                    top = 20.dp,
                    start = 20.dp, bottom = 0.dp
                )
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Column {
                Spacer(modifier = Modifier.padding(5.dp))
                Box(modifier = Modifier.background(color = ProfilePink)) {
                    Row {
                        Text(
                            text = userBirthday.get(Calendar.MONTH).toString(),
                            fontStyle = FontStyle(R.font.mamelon),
                            color = Color.Black,
                            fontSize = 26.sp,
                            modifier = Modifier.padding(
                                start = 20.dp,
                                top = 10.dp,
                                end = 10.dp,
                                bottom = 10.dp
                            )
                        )
                        Text(
                            text = "月",
                            fontStyle = FontStyle(R.font.mamelon),
                            color = Color.Black,
                            fontSize = 26.sp,
                            modifier = Modifier.padding(
                                start = 5.dp,
                                top = 10.dp,
                                end = 10.dp,
                                bottom = 10.dp
                            )
                        )
                        Text(
                            text = userBirthday.get(Calendar.DAY_OF_MONTH).toString(),
                            fontStyle = FontStyle(R.font.mamelon),
                            color = Color.Black,
                            fontSize = 26.sp,
                            modifier = Modifier.padding(
                                start = 5.dp,
                                top = 10.dp,
                                end = 10.dp,
                                bottom = 10.dp
                            )
                        )
                        Text(
                            text = "日",
                            fontStyle = FontStyle(R.font.mamelon),
                            color = Color.Black,
                            fontSize = 26.sp,
                            modifier = Modifier.padding(
                                start = 5.dp,
                                top = 10.dp,
                                end = 60.dp,
                                bottom = 10.dp
                            )
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.userdata_icon_pen),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .align(Alignment.BottomEnd)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.size(40.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun UserData_Info_3_Preview() {
    UserData_Info_3(
        userGender = "酷酷的草履蟲",
        userBirthday = Calendar.getInstance()
    )
}