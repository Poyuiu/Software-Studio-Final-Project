package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.outlined.FastForward
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.presentation.utils.coloredShadow
import com.ss_team_1.koibitoshuuchuu.ui.theme.Secondary

@Preview(showBackground = true)
@Composable
fun ForwardButton(onClick: () -> Unit = {}) {
    RoundButtonTemplate(
        icon = Icons.Outlined.FastForward,
        iconSize = 36.dp,
        onClick = onClick
    )
}

@Preview
@Composable
fun HelpButton() {
    RoundButtonTemplate(
        icon = Icons.Outlined.HelpOutline,
        iconSize = 36.dp,
        onClick = {
        }
    )
}
@Preview
@Composable
fun SettingsButton() {
    RoundButtonTemplate(
        icon = Icons.Outlined.Settings,
        iconSize = 36.dp,
        onClick = {}
    )
}

@Preview
@Composable
fun PauseButton(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    RoundButtonTemplate(
        modifier = modifier,
        icon = Icons.Default.Pause,
        iconSize = 36.dp,
        onClick = onClick
    )
}

@Preview
@Composable
private fun BackButtonPreview(){
    BackButton(navController = NavController(LocalContext.current))
}

@Composable
fun BackButton(navController: NavController) {
    RoundButtonTemplate(
        icon = Icons.Default.ArrowBack,
        iconSize = 36.dp,
        onClick = {navController.popBackStack()}
    )
}

@Composable
fun RoundButtonTemplate(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconSize: Dp = 24.dp,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .size(46.dp)
            .coloredShadow(
                color = Color.Black,
                offsetY = 4.dp,
                alpha = 0.25f,
                shadowRadius = 4.dp,
                borderRadius = 30.dp
            ),
        onClick = onClick, colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.White, contentColor = Secondary
        ), shape = CircleShape, contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            icon,
            contentDescription = "Menu Icon",
            modifier = Modifier.size(iconSize)
        )
    }
}
