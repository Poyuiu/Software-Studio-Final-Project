package com.ss_team_1.koibitoshuuchuu.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.components.PageProfile
import com.ss_team_1.koibitoshuuchuu.presentation.pages.FocusIntroPage
import com.ss_team_1.koibitoshuuchuu.presentation.pages.FocusPage
import com.ss_team_1.koibitoshuuchuu.presentation.pages.HomePage
import com.ss_team_1.koibitoshuuchuu.presentation.pages.ShopPage
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
                    composable(Page.Focus.route) { FocusPage(navController) }
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

@Composable
fun WelcomePage(navController: NavController = NavController(LocalContext.current)) {
    R.string.detail
    Box(
        Modifier
            .fillMaxSize()
            .clickable(
                enabled = true,
                onClickLabel = "Welcomepage click",
                onClick = {
                    navController.navigate(Page.Home.route)
                }
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        //這個式子只能用手算的 phone: x=1080f y=904
        //StrokeText(LocalContext.current,"戀人專注", 204f,180,168f)//每個字的寬度=size

    }
}

@Preview
@Composable
fun WelcomepagePreview() {
    KoiBitoShuuChuuTheme {
        WelcomePage(NavController(LocalContext.current))
    }
}

/*@SuppressLint("NewApi")
@Composable
fun StrokeText(context: Context, string: String, x: Float, y: Int, size: Float){
    val customTypeface = context.resources.getFont(R.font.mamelon)

    val textPaintStroke = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        style = android.graphics.Paint.Style.STROKE
        textSize = size
        color = android.graphics.Color.BLACK
        strokeWidth = size/6f
        strokeMiter= size/8f
        strokeJoin = android.graphics.Paint.Join.ROUND
        typeface = customTypeface
    }

    val textPaint = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        style = android.graphics.Paint.Style.FILL
        textSize = size
        color = android.graphics.Color.WHITE
        typeface = customTypeface
    }
    Canvas(
        modifier = Modifier.fillMaxSize(),
        onDraw = {
            drawIntoCanvas {
                it.nativeCanvas.drawText(
                    string,
                    x,
                    y.dp.toPx(),
                    textPaintStroke
                )
                it.nativeCanvas.drawText(
                    string,
                    x,
                    y.dp.toPx(),
                    textPaint
                )
            }
        }
    )
}

@Composable
fun LoverFocusApp(context: Context){

    Surface(
        color = MaterialTheme.colors.primary
    ) {
        Text(text = "Welcome，你好", modifier = Modifier.padding(24.dp),fontFamily = mamelonFamily, fontWeight = FontWeight.Normal)
        StrokeText(LocalContext.current,"戀人專注Welcome，你好", 30f,100,64f)

    }
}

@Preview
@Composable
fun DefaultPreview() {
    KoiBitoShuuChuuTheme {
        LoverFocusApp(LocalContext.current)
    }
}*/