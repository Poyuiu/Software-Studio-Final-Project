package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.People
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.ui.theme.Primary
import com.ss_team_1.koibitoshuuchuu.ui.theme.Secondary

@Preview(showBackground = true)
@Composable
fun NavigationProfileButton() {
    NavigationButtonTemplate(
        onClick = { /*TODO*/ },
        selected = false,
        painter = painterResource(id = R.drawable.ic_profile)
    )
}

@Preview(showBackground = true)
@Composable
fun NavigationHomeButton() {
    NavigationButtonTemplate(
        onClick = { /*TODO*/ },
        selected = false,
        painter = painterResource(id = R.drawable.ic_home)
    )
}

@Preview(showBackground = true)
@Composable
fun NavigationShopButton() {
    NavigationButtonTemplate(
        onClick = { /*TODO*/ },
        selected = false,
        painter = painterResource(id = R.drawable.ic_shop)
    )
}

@Composable
private fun NavigationButtonTemplate(
    onClick: () -> Unit,
    selected: Boolean,
    painter: Painter
) {
    Button(
        modifier = Modifier.size(width = 120.dp, height = 48.dp),
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (selected) Primary else Secondary
        )
    ) {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier
                .padding(top = 4.dp)
                .size(30.dp)
        )
    }
}

