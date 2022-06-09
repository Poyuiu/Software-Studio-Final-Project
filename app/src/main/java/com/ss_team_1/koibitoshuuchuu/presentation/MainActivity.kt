package com.ss_team_1.koibitoshuuchuu.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ss_team_1.koibitoshuuchuu.presentation.components.PageProfile
import com.ss_team_1.koibitoshuuchuu.presentation.pages.*
import com.ss_team_1.koibitoshuuchuu.ui.theme.KoiBitoShuuChuuTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoiBitoShuuChuuTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Page.Welcome.route) {
                    composable(Page.Welcome.route) { WelcomePage(navController/*...*/) }
                    composable(Page.Home.route) { HomePage(navController/*...*/) }
                    composable(Page.Profile.route) { PageProfile(navController) }
                    composable(Page.Shop.route) {
                        ShopPage(
                            navController = navController,
                            buyflag = true
                        )
                    }
                    composable(Page.FocusIntro.route) { FocusIntroPage(navController) }
                    composable(Page.Focus.route + "/{focusTime}") { backStackEntry ->
                        val focusTime = backStackEntry.arguments?.getInt("focusTime")
                        FocusPage(navController, focusTime)
                    }
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
    object Shop : Page("shop_page")
    object FocusIntro : Page("focus_intro_page")
    object Focus : Page("focus_page")
}

