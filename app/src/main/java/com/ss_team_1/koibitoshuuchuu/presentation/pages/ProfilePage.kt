package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.utils.PageId
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.CharacterViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.UserViewModel
import com.ss_team_1.koibitoshuuchuu.ui.theme.ProfilePink
import java.util.*

@Composable
fun PageProfile(
    navController: NavController = NavController(LocalContext.current),
    userViewModel: UserViewModel = hiltViewModel(),
    characterViewModel: CharacterViewModel = hiltViewModel()
) {
    val userPhoto = remember {
        userViewModel.state.value.userInfo.photo_url
    }
    val userName = remember {
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
        NavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            navController,
            PageId.profile
        )
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(bottom = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UserInfo1(
                userPhoto = R.drawable.profile_picture1.toString(),
                userName = userViewModel.state.value.userInfo.user_name,
                userID = userViewModel.state.value.userInfo.id,
                userGender = userViewModel.state.value.userInfo.gender,
                userBirthday = userViewModel.state.value.userInfo.birthday,
                navController
            )
            Divider(
                color = Color.Black, thickness = 1.2.dp,
                modifier = Modifier.padding(
                    12.dp
                )
            )
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
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(
                        start = 0.dp,
                        top = 5.dp, end = 0.dp, bottom = 0.dp
                    )
                ) {
                    val matrix = ColorMatrix()
                    matrix.setToSaturation(0F)
                    Spacer(modifier = Modifier.padding(5.dp))
                    Image(
                        painter = painterResource(id = R.drawable.profile_arrow_left),
                        contentDescription = "arrow left",
                        modifier = Modifier
                            .size(width = 20.dp, height = 50.dp)
                            .background(ProfilePink)
                            .width(10.dp)
                            .clickable { /*future new roles*/ }
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
                    Box {
                        Image(
                            painter = painterResource(
                                id = R.drawable.profile_character_2
                            ),
                            colorFilter =
                            if (characterViewModel.state.value.characters[1].level == 0) ColorFilter.colorMatrix(
                                matrix
                            )
                            else null,
                            contentDescription = "魂魄",
                            modifier = Modifier
                                .size(height = 90.dp, width = 85.dp)
                                .background(Color.White)
                        )
                        if (characterViewModel.state.value.characters[1].level == 0) {
                            Image(
                                painter = painterResource(
                                    id = R.drawable.profile_lock
                                ),
                                contentDescription = "lock",
                                modifier = Modifier
                                    .size(50.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Image(
                            painter = painterResource(
                                id = R.drawable.profile_chname_2,
                            ),
                            colorFilter =
                            if (characterViewModel.state.value.characters[1].level == 0) ColorFilter.colorMatrix(
                                matrix
                            )
                            else null,
                            contentDescription = "chname_2",
                            modifier = Modifier
                                .paddingFromBaseline(80.dp)
                                .size(height = 27.dp, width = 85.dp)

                        )
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    Box {
                        Image(
                            painter = painterResource(
                                id = R.drawable.profile_character_3
                            ),
                            contentDescription = "吉吊",
                            colorFilter =
                            if (characterViewModel.state.value.characters[2].level == 0) ColorFilter.colorMatrix(
                                matrix
                            )
                            else null,
                            modifier = Modifier
                                .size(height = 90.dp, width = 85.dp)
                                .background(Color.White)
                        )
                        if (characterViewModel.state.value.characters[2].level == 0) {
                            Image(
                                painter = painterResource(
                                    id = R.drawable.profile_lock
                                ),
                                contentDescription = "lock",
                                modifier = Modifier
                                    .size(50.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Image(
                            painter = painterResource(
                                id = R.drawable.profile_chname_3
                            ),
                            colorFilter =
                            if (characterViewModel.state.value.characters[2].level == 0) ColorFilter.colorMatrix(
                                matrix
                            )
                            else null,
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
                            .clickable { /*future new roles*/ }
                    )
                }
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
                            .clickable { /*future new scenes*/ }
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
                    Box {
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
                    Box {
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
                            .clickable { /*future new scenes*/ }
                    )
                }
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
                            .clickable { /*future new items*/ }
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
//                        colorFilter =
//                if (characterViewModel.state.value.characters[1].level == 0) ColorFilter.colorMatrix(
//                    matrix
//                )
//                else n
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
                    Box {
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
                    Box {
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
                        contentDescription = "arrow right",
                        modifier = Modifier
                            .size(width = 20.dp, height = 50.dp)
                            .background(ProfilePink)
                            .width(10.dp)
                            .clickable { /*future new items*/ }
                    )

                }
                Spacer(modifier = Modifier.padding(5.dp))
            }
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