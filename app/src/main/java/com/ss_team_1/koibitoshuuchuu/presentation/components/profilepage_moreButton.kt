package com.ss_team_1.koibitoshuuchuu.presentation.components

import android.content.res.Resources
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material.ButtonDefaults
import com.ss_team_1.koibitoshuuchuu.ui.theme.GreenBlue
import com.ss_team_1.koibitoshuuchuu.ui.theme.black
import com.ss_team_1.koibitoshuuchuu.ui.theme.gray
import com.ss_team_1.koibitoshuuchuu.ui.theme.secUn

@Composable
fun moreButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit // TODO
) {
    Button(
        onClick = { /* ... */ },
        shape = RoundedCornerShape(100),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = GreenBlue,
            contentColor = black,
        )
        ) {
        // Inner content including an icon and a text label

        Text("More")
    }
}


@Preview(showBackground = true)
@Composable
fun moreButtonPreview() {
    moreButton(
        onClick = {}
    )
}