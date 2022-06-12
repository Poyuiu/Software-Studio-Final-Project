package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.UserViewModel
import java.util.*

@Composable
fun PageProfile(navController: NavController= NavController(LocalContext.current),
    userViewModel: UserViewModel= hiltViewModel(),

) {
    val userPhoto = remember {
        userViewModel.state.value.userInfo.photo_url
    }
    val userName =  remember{
        userViewModel.state.value.userInfo.user_name
    }
    val userID = remember {
       userViewModel.state.value.userInfo.id
    }
    val userGender = remember {
        userViewModel.state.value.userInfo.gender
    }
    val userBirthday = remember {
        userViewModel.state.value.userInfo.birthday
    }
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
        NavigationBar(modifier = Modifier.align(Alignment.BottomCenter), navController)
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(bottom = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            if (userPhoto != null) {
//                if (userName != null) {
//                    if (userID != null) {
//                        if (userGender != null) {
//                            if (userBirthday != null) {
//                                UserInfo1(
//                                    userPhoto = userPhoto,
//                                    userName = userName,
//                                    userID = userID,
//                                    userGender = userGender,
//                                    userBirthday = userBirthday
//                                )
//                            }
//                        }
//                    }
//                }
//            }
            UserInfo1(
                userPhoto = R.drawable.profile_picture1.toString(),
                userName = userViewModel.state.value.userInfo.user_name,
                userID = 1234567,
                userGender = "酷酷的草履蟲",
                userBirthday = Calendar.getInstance(),
                navController
            )
            Divider(
                color = Color.Black, thickness = 1.2.dp,
                modifier = Modifier.padding(
                    12.dp
                )
            )
            UserInfo2()
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PageProfilePreview() {
//    PageProfile(
//        navController = NavController(LocalContext.current)
//    )
//}