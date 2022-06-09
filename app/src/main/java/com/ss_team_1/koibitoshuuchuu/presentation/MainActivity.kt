package com.ss_team_1.koibitoshuuchuu.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ss_team_1.koibitoshuuchuu.presentation.components.PageProfile
import com.ss_team_1.koibitoshuuchuu.presentation.components.UserDataPage
import com.ss_team_1.koibitoshuuchuu.presentation.pages.*
import com.ss_team_1.koibitoshuuchuu.ui.theme.KoiBitoShuuChuuTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoiBitoShuuChuuTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Page.Welcome.route) {
                    composable(Page.Welcome.route) { WelcomePage(navController/*...*/) }
                    composable(Page.Home.route) {
                        HomePage(navController,
                            onClickToCharacterInfo = { characterID ->
                                navController.navigate(Page.CharacterInfoAndStory.route + "/$characterID")
                            }
                        )
                    }
                    composable(Page.Profile.route) { PageProfile(navController) }
                    composable(Page.UserData.route) { UserDataPage(navController) }
                    composable(Page.Shop.route) {
                        ShopPage(
                            navController = navController,
                            buyflag = true
                        )
                    }
                    composable(Page.FocusIntro.route) { FocusIntroPage(navController) }
                    composable(
                        Page.Focus.route + "/{focusTime}",
                        arguments = listOf(navArgument("focusTime") {
                            type = NavType.IntType
                        })
                    ) { backStackEntry ->
                        val focusTime = backStackEntry.arguments?.getInt("focusTime")
                        FocusPage(navController, focusTime)
                    }
                    composable(
                        //character0 will be -> Page.CharacterInfoAndStory.route + "/0"
                        route = Page.CharacterInfoAndStory.route + "/{characterID}",
                        arguments = listOf(
                            navArgument("characterID") {
                                type = NavType.IntType
                            }
                        )
                    ) { entry ->
                        val characterID = entry.arguments?.getInt("characterID")!!
                        CharacterInfoAndStoryPage(
                            characterID = characterID,
                            onClickGoStory = { plotID ->
                                navController.navigate(Page.Plot.route + "/$characterID/$plotID")
                            },
                            onClickGoDetail = { navController.navigate(Page.CharacterDetail.route + "/$characterID") },
                            navController = navController
                        )
                    }

                    composable(
                        route = Page.CharacterDetail.route + "/{characterID}",
                        arguments = listOf(
                            navArgument("characterID") {
                                type = NavType.IntType
                            }
                        )
                    ) { entry ->
                        CharacterDetailPage(
                            characterID = entry.arguments?.getInt("characterID")!!,
                            navController = navController
                        )
                    }
                    composable(
                        route = Page.Plot.route + "/{characterID}/{plotID}",
                        arguments = listOf(
                            navArgument("characterID") {
                                type = NavType.IntType
                            },
                            navArgument("plotID") {
                                type = NavType.IntType
                            }
                        )
                    ) { entry ->
                        PlotPage(
                            plotID = entry.arguments?.getInt("plotID")!!,
                            characterID = entry.arguments?.getInt("characterID")!!,
                            navController = navController,
                            onPlotEnd = { navController.popBackStack() }
                        )
                    }
                    //composable(Page.FocusIntro.route) { FocusIntroPage(navController) }
                    /*...*/
                }

                //WelcomePage()
            }
        }
    }
}

/**
 * Class for route of Pages
 */
sealed class Page(val route: String) {
    object Welcome : Page("welcome_page")
    object Home : Page("home_page")
    object Profile : Page("profile_page")
    object UserData : Page("user_data_page")
    object Shop : Page("shop_page")
    object FocusIntro : Page("focus_intro_page")
    object Focus : Page("focus_page")
    object CharacterInfoAndStory : Page("character_info_and_story_page")
    object CharacterDetail : Page("character_detail_page")
    object Plot : Page("plot_page")
}

