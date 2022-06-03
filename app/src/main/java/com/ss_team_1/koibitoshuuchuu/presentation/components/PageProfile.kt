package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.domain.model.User
import com.ss_team_1.koibitoshuuchuu.presentation.StrokeText
import com.ss_team_1.koibitoshuuchuu.presentation.utils.coloredShadow
import com.ss_team_1.koibitoshuuchuu.ui.theme.DarkGreenBlue
import com.ss_team_1.koibitoshuuchuu.ui.theme.GreenBlue
import com.ss_team_1.koibitoshuuchuu.ui.theme.black
import java.util.*

@Composable
fun UserInfo(
//    onClick: () -> Unit,
    @DrawableRes userPhoto: Int,
    userName: String,
    userID: Long,
    userGender: String,
    userBirthday: Date
//    playergender: String,
//    playerBirthday: String,
//    showDetailButton: Boolean
) {
    Box {

        //這個式子只能用手算的 phone: x=1080f y=904
        StrokeText(
            LocalContext.current, userName,
            130f, 215, 90f
        )//每個字的寬度=size

        Row(
            modifier = Modifier
                .padding(35.dp)

        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                Image(
                    painter = painterResource(id = userPhoto),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .size(130.dp)
                        .clip(CircleShape)
                        .border(
                            3.dp, GreenBlue, CircleShape
                        )
                )
                Spacer(modifier = Modifier.height(50.dp))
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
                        fontSize = 24.sp,
                        //textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Text(
                        text = userGender,
                        fontStyle = FontStyle(R.font.mamelon),
                        color = Color.Black,
                        fontSize = 18.sp,
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row {
                    Text(
                        text = "生日",
                        fontStyle = FontStyle(R.font.mamelon),
                        color = DarkGreenBlue,
                        fontSize = 24.sp,
                        //textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Text(
                        text = userBirthday.toString(),
                        fontStyle = FontStyle(R.font.mamelon),
                        color = Color.Black,
                        fontSize = 18.sp,
                    )
                }
            }
            Column {
                Spacer(modifier = Modifier.height(260.dp))
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

}

@Preview(showBackground = true)
@Composable
fun UserInfoPreview() {
    UserInfo(
        userPhoto = R.drawable.profile_picture1,
        userName = "酷酷的名字",
        userID = 12345678,
        userGender = "酷酷的草履蟲",
        userBirthday = Date(2000,1,1)
    )
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
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Text(text = "Cool Name")
//            Spacer(modifier = Modifier.height(80.dp))
            UserInfo(
                userPhoto = user.photo_url,
                userName = user.user_name,
                userID = user.id,
                userGender = user.gender,
                userBirthday = user.birthday
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PageProfilePreview() {
    PageProfile(
        user = User(
            user_name = "酷酷的名字",
            photo_url = R.drawable.profile_picture1,
            id = 12345678,
            gender = "酷酷的草履蟲",
            birthday = Date(2000, 1, 1),
            money = 1000,
            gem = 1000,
            join_date = Date(2000, 1, 1),
            total_focus_time = 100
        )
    )
}