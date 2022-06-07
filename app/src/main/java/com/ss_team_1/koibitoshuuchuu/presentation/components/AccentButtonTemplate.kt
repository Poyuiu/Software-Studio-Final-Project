package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.ui.theme.AccentColor
import com.ss_team_1.koibitoshuuchuu.ui.theme.AccentDark
import com.ss_team_1.koibitoshuuchuu.ui.theme.Primary

@Preview
@Composable
private fun AccentButtonPreview() {
    AccentButtonTemplate(onClick = {}) {
        Text(text = "START")
    }
}

@Composable
fun AccentButtonTemplate(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    width: Dp = 255.dp,
    height: Dp = 70.dp,
    content: @Composable() () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(36.dp),
        border = BorderStroke(width = 3.dp, color = Primary),
        modifier = modifier.size(width = width, height = height),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = AccentColor,
            contentColor = AccentDark
        )
    ) {
        content()
    }
}