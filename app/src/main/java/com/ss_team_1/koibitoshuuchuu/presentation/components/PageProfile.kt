package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import com.ss_team_1.koibitoshuuchuu.domain.model.User
import com.ss_team_1.koibitoshuuchuu.presentation.utils.coloredShadow
import com.ss_team_1.koibitoshuuchuu.ui.theme.*
import java.util.*

@Composable
fun UserInfo1(
//    onClick: () -> Unit,
    userPhoto: String,
    userName: String,
    userID: Long,
    userGender: String,
    userBirthday: Calendar
//    showDetailButton: Boolean
) {
    Row(
        modifier = Modifier
            .padding(
                start = 30.dp,
                bottom = 0.dp,
                top = 30.dp,
                end = 30.dp
            )

    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Image(
                painter = painterResource(id = userPhoto.toInt()),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .border(
                        3.dp, GreenBlue, CircleShape
                    )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = userName,
                fontStyle = FontStyle(R.font.mamelon),
                color = Color.Black,
                fontSize = 28.sp
            )
            Text(
                text = "ID $userID",
                fontStyle = FontStyle(R.font.mamelon),
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row {
                Text(
                    text = "性別",
                    fontStyle = FontStyle(R.font.mamelon),
                    color = DarkGreenBlue,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.width(40.dp))
                Text(
                    text = userGender,
                    fontStyle = FontStyle(R.font.mamelon),
                    color = Color.Black,
                    fontSize = 20.sp,
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row {
                Text(
                    text = "生日",
                    fontStyle = FontStyle(R.font.mamelon),
                    color = DarkGreenBlue,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.width(40.dp))
                Text(
                    text = userBirthday.get(Calendar.MONTH).toString(),
                    fontStyle = FontStyle(R.font.mamelon),
                    color = Color.Black,
                    fontSize = 20.sp,
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "月",
                    fontStyle = FontStyle(R.font.mamelon),
                    color = DarkGreenBlue,
                    fontSize = 20.sp,
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = userBirthday.get(Calendar.DAY_OF_MONTH).toString(),
                    fontStyle = FontStyle(R.font.mamelon),
                    color = Color.Black,
                    fontSize = 20.sp,
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "日",
                    fontStyle = FontStyle(R.font.mamelon),
                    color = DarkGreenBlue,
                    fontSize = 20.sp,
                )
            }
        }
        Column {
            Spacer(modifier = Modifier.height(180.dp))
            Button(
                onClick = { /* ... */ },
                shape = RoundedCornerShape(100),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = GreenBlue,
                    contentColor = black,
                ),
                modifier = Modifier.coloredShadow(
                    color = Color.Black,
                    offsetY = 4.dp,
                    alpha = 0.25f,
                    shadowRadius = 4.dp,
                    borderRadius = 30.dp
                )
            ) {
                Text(
                    "More",
                    fontStyle = FontStyle(R.font.mamelon)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun UserInfo1Preview() {
    UserInfo1(
        userPhoto = R.drawable.profile_picture1.toString(),
        userName = "酷酷的名字",
        userID = 12345678,
        userGender = "酷酷的草履蟲",
        userBirthday = Calendar.getInstance()
    )
}

@Composable
fun UserInfo2() {
    Column(
        modifier = Modifier
            .background(
                color = ProfilePink,
                shape = RoundedCornerShape(15.dp)
            )
            .width(360.dp)
    ) {
        Text(
            text = "已解鎖",
            fontStyle = FontStyle(R.font.mamelon),
            color = Color.Black,
            fontSize = 20.sp,
            modifier = Modifier.padding(
                top = 20.dp,
                start = 20.dp, bottom = 0.dp
            )
        )
        Text(
            text = "角色",
            fontStyle = FontStyle(R.font.mamelon),
            color = Color.Black,
            fontSize = 15.sp,
            modifier = Modifier.padding(
                start = 40.dp,
                top = 10.dp,
                end = 0.dp,
                bottom = 0.dp
            )
        )
        Info2_character()
        Text(
            text = "場景",
            fontStyle = FontStyle(R.font.mamelon),
            color = Color.Black,
            fontSize = 15.sp,
            modifier = Modifier.padding(
                start = 40.dp,
                top = 5.dp,
                end = 0.dp,
                bottom = 0.dp
            )
        )
        Info2_scene()
        Text(
            text = "物品",
            fontStyle = FontStyle(R.font.mamelon),
            color = Color.Black,
            fontSize = 15.sp,
            modifier = Modifier.padding(
                start = 40.dp,
                top = 5.dp,
                end = 0.dp,
                bottom = 0.dp
            )
        )
        Info2_item()
        Spacer(modifier = Modifier.padding(5.dp))
    }
}

@Composable
fun Info2_character() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(
            start = 0.dp,
            top = 5.dp, end = 0.dp, bottom = 0.dp
        )
    ) {
        Spacer(modifier = Modifier.padding(5.dp))
        Image(
            painter = painterResource(id = R.drawable.profile_arrow_left),
            contentDescription = "arrow left",
            modifier = Modifier
                .size(width = 20.dp, height = 50.dp)
                .background(ProfilePink)
                .width(10.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Box {
            Image(
                painter = painterResource(
                    id = R.drawable.profile_character_1
                ),
                contentDescription = "四季",
                modifier = Modifier
                    .size(height = 90.dp, width = 85.dp)
                    .background(Color.White)
            )
            Image(
                painter = painterResource(
                    id = R.drawable.profile_chname_1
                ),
                contentDescription = "chname_1",
                modifier = Modifier
                    .paddingFromBaseline(80.dp)
                    .size(height = 27.dp, width = 85.dp)

            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Box() {
            Image(
                painter = painterResource(
                    id = R.drawable.profile_character_2
                ),
                contentDescription = "魂魄",
                modifier = Modifier
                    .size(height = 90.dp, width = 85.dp)
                    .background(Color.White)
            )
            Image(
                painter = painterResource(
                    id = R.drawable.profile_lock
                ),
                contentDescription = "lock",
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center)
            )
            Image(
                painter = painterResource(
                    id = R.drawable.profile_chname_2
                ),
                contentDescription = "chname_2",
                modifier = Modifier
                    .paddingFromBaseline(80.dp)
                    .size(height = 27.dp, width = 85.dp)

            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Box() {
            Image(
                painter = painterResource(
                    id = R.drawable.profile_character_3
                ),
                contentDescription = "吉吊",
                modifier = Modifier
                    .size(height = 90.dp, width = 85.dp)
                    .background(Color.White)
            )
            Image(
                painter = painterResource(
                    id = R.drawable.profile_lock
                ),
                contentDescription = "lock",
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center)
            )
            Image(
                painter = painterResource(
                    id = R.drawable.profile_chname_3
                ),
                contentDescription = "chname_3",
                modifier = Modifier
                    .paddingFromBaseline(80.dp)
                    .size(height = 27.dp, width = 85.dp)

            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Image(
            painter = painterResource(
                id = R.drawable.profile_arrow_right
            ),
            contentDescription = "arrow left",
            modifier = Modifier
                .size(width = 20.dp, height = 50.dp)
                .background(ProfilePink)
                .width(10.dp)
        )

    }
}

@Composable
fun Info2_scene() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(
            start = 0.dp,
            top = 5.dp, end = 0.dp, bottom = 0.dp
        )
    ) {
        Spacer(modifier = Modifier.padding(5.dp))
        Image(
            painter = painterResource(id = R.drawable.profile_arrow_left),
            contentDescription = "arrow left",
            modifier = Modifier
                .size(width = 20.dp, height = 50.dp)
                .background(ProfilePink)
                .width(10.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Box {
            Image(
                painter = painterResource(
                    id = R.drawable.profile_scene_1
                ),
                contentDescription = "咖啡廳",
                modifier = Modifier
                    .size(height = 90.dp, width = 85.dp)
                    .background(Color.Transparent)
            )
            Image(
                painter = painterResource(
                    id = R.drawable.profile_scname_1
                ),
                contentDescription = "scname_1",
                modifier = Modifier
                    .paddingFromBaseline(80.dp)
                    .size(height = 27.dp, width = 85.dp)

            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Box() {
            Image(
                painter = painterResource(
                    id = R.drawable.profile_scene_2
                ),
                contentDescription = "圖書館",
                modifier = Modifier
                    .size(height = 90.dp, width = 85.dp)
                    .background(Color.Transparent)
            )
            Image(
                painter = painterResource(
                    id = R.drawable.profile_lock
                ),
                contentDescription = "lock",
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center)
            )
            Image(
                painter = painterResource(
                    id = R.drawable.profile_scname_2
                ),
                contentDescription = "scname_2",
                modifier = Modifier
                    .paddingFromBaseline(80.dp)
                    .size(height = 27.dp, width = 85.dp)

            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Box() {
            Image(
                painter = painterResource(
                    id = R.drawable.profile_scene_3
                ),
                contentDescription = "辦公室",
                modifier = Modifier
                    .size(height = 90.dp, width = 85.dp)
                    .background(Color.Transparent)
            )
            Image(
                painter = painterResource(
                    id = R.drawable.profile_lock
                ),
                contentDescription = "lock",
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center)
            )
            Image(
                painter = painterResource(
                    id = R.drawable.profile_scname_3
                ),
                contentDescription = "scname_3",
                modifier = Modifier
                    .paddingFromBaseline(80.dp)
                    .size(height = 27.dp, width = 85.dp)

            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Image(
            painter = painterResource(
                id = R.drawable.profile_arrow_right
            ),
            contentDescription = "arrow left",
            modifier = Modifier
                .size(width = 20.dp, height = 50.dp)
                .background(ProfilePink)
                .width(10.dp)
        )
    }
}

@Composable
fun Info2_item() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(
            start = 0.dp,
            top = 5.dp, end = 0.dp, bottom = 0.dp
        )
    ) {
        Spacer(modifier = Modifier.padding(5.dp))
        Image(
            painter = painterResource(id = R.drawable.profile_arrow_left),
            contentDescription = "arrow left",
            modifier = Modifier
                .size(width = 20.dp, height = 50.dp)
                .background(ProfilePink)
                .width(10.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Box {
            Image(
                painter = painterResource(
                    id = R.drawable.profile_item_1
                ),
                contentDescription = "玫瑰",
                modifier = Modifier
                    .size(height = 90.dp, width = 85.dp)
                    .background(Color.Transparent)
            )
            Image(
                painter = painterResource(
                    id = R.drawable.profile_itname_1
                ),
                contentDescription = "itname_1",
                modifier = Modifier
                    .paddingFromBaseline(80.dp)
                    .size(height = 27.dp, width = 85.dp)

            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Box() {
            Image(
                painter = painterResource(
                    id = R.drawable.profile_item_2
                ),
                contentDescription = "蛋糕",
                modifier = Modifier
                    .size(height = 90.dp, width = 85.dp)
                    .background(Color.Transparent)
            )
            Image(
                painter = painterResource(
                    id = R.drawable.profile_itname_2
                ),
                contentDescription = "itname_2",
                modifier = Modifier
                    .paddingFromBaseline(80.dp)
                    .size(height = 27.dp, width = 85.dp)

            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Box() {
            Image(
                painter = painterResource(
                    id = R.drawable.profile_item_3
                ),
                contentDescription = "戒指",
                modifier = Modifier
                    .size(height = 90.dp, width = 85.dp)
                    .background(Color.Transparent)
            )
            Image(
                painter = painterResource(
                    id = R.drawable.profile_itname_3
                ),
                contentDescription = "itname_3",
                modifier = Modifier
                    .paddingFromBaseline(80.dp)
                    .size(height = 27.dp, width = 85.dp)

            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Image(
            painter = painterResource(
                id = R.drawable.profile_arrow_right
            ),
            contentDescription = "arrow left",
            modifier = Modifier
                .size(width = 20.dp, height = 50.dp)
                .background(ProfilePink)
                .width(10.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun UserInfo2Preview() {
    UserInfo2()
}

@Composable
fun PageProfile(user: User) {
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
        TopBar(button1 = { SettingsButton() })
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(bottom = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            UserInfo1(
                userPhoto = user.photo_url,
                userName = user.user_name,
                userID = user.id,
                userGender = user.gender,
                userBirthday = user.birthday
            )
            Divider(
                color = Color.Black, thickness = 1.5.dp,
                modifier = Modifier.padding(
                    15.dp
                )
            )
            UserInfo2()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PageProfilePreview() {
    PageProfile(
        user = User(
            user_name = "酷酷的名字",
            photo_url = R.drawable.profile_picture1.toString(),
            id = 12345678,
            gender = "酷酷的草履蟲",
            birthday = Calendar.getInstance(),
            money = 1000,
            gem = 1000,
            join_date = Calendar.getInstance()
        )
    )
}