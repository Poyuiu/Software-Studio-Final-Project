package com.ss_team_1.koibitoshuuchuu.presentation.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.FastForward
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Help
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.ui.theme.Secondary

@Preview
@Composable
fun ForwardButton() {
    RoundButtonTemplate(
        icon = Icons.Outlined.FastForward,
        iconSize = 30.dp,
        onClick = {}
    )
}

@Preview
@Composable
fun HelpButton() {
    RoundButtonTemplate(
        icon = Icons.Outlined.Help,
        iconSize = 30.dp,
        onClick = {}
    )
}

@Preview
@Composable
fun SettingsButton() {
    RoundButtonTemplate(
        icon = Icons.Outlined.Settings,
        iconSize = 30.dp,
        onClick = {}
    )
}

@Preview
@Composable
fun PauseButton() {
    RoundButtonTemplate(
        icon = Icons.Default.Pause,
        iconSize = 36.dp,
        onClick = {}
    )
}

@Preview
@Composable
fun BackButton() {
    RoundButtonTemplate(
        icon = Icons.Default.ArrowBack,
        iconSize = 36.dp,
        onClick = {}
    )
}

@Composable
fun RoundButtonTemplate(
    icon: ImageVector,
    iconSize: Dp = 24.dp,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.size(36.dp),
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
