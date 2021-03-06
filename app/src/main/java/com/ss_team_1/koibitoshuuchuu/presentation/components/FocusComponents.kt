package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.ui.theme.Primary
import com.ss_team_1.koibitoshuuchuu.ui.theme.Secondary
import com.ss_team_1.koibitoshuuchuu.ui.theme.mamelonFamily

@Preview
@Composable
fun SquareHomeButton(onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Primary, contentColor = Secondary),
        border = BorderStroke(width = 2.dp, color = Secondary),
        modifier = Modifier.size(58.dp)
    ) {
        Icon(
            imageVector = Icons.Outlined.Home,
            contentDescription = "",
            modifier = Modifier
                .size(30.dp)
        )
    }
}

@Preview
@Composable
private fun ResourceBoxPreview()
{
    ResourceBox(intimacyChange = 100, moneyChange = 100)
}
@Composable
fun ResourceBox(intimacyChange: Int, moneyChange: Int) {
    val intimacyText = if (intimacyChange > 0) {
        "+$intimacyChange"
    } else if (intimacyChange < 0) {
        "$intimacyChange"
    } else "-----"

    val moneyText = if (moneyChange > 0) {
        "+$moneyChange"
    } else if (moneyChange < 0) {
        "$moneyChange"
    } else "-----"
    androidx.compose.material.Surface(
        modifier = Modifier.size(width = 323.dp, height = 61.dp),
        shape = RoundedCornerShape(15.dp),
        color = Primary.copy(alpha = 0.7f),
        border = BorderStroke(width = 3.dp, color = Secondary)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ResourcedValue(imageId = R.drawable.heart_intimacy, text = intimacyText)
            ResourcedValue(imageId = R.drawable.ic_coin, text = moneyText)
        }
    }
}

@Composable
private fun ResourcedValue(
    imageId: Int,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(10.dp)
    ) {
        Image(
            modifier = Modifier.size(42.dp),
            painter = painterResource(id = imageId),
            contentDescription = "resource",
            contentScale = ContentScale.Fit
        )
        Text(text = text, fontFamily = mamelonFamily, fontSize = 32.sp)
    }
}