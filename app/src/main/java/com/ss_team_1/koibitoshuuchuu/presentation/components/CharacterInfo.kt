package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.utils.ResourceStorer
import com.ss_team_1.koibitoshuuchuu.ui.theme.*

@Composable
fun CharacterInfo(
    onClick: () -> Unit,
    @DrawableRes characterPhoto: Int,
    @StringRes characterName: Int,
    @StringRes characterInfo: Int,
    showDetailButton: Boolean
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .width(344.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(id = characterPhoto),
            contentDescription = "",
            modifier = Modifier
                .padding(8.dp)
                .width(128.dp)
                .height(268.dp)
        )
        Column(
            modifier = Modifier
                .padding(8.dp)
                .width(172.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = characterName),
                fontSize = 28.sp,
                color = secUn,
                fontStyle = FontStyle(mainFont),
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = stringResource(id = characterInfo),
                fontSize = 16.sp,
                fontStyle = FontStyle(mainFont),
                modifier = Modifier.padding(8.dp)
            )
            if(showDetailButton) {
                Spacer(modifier = Modifier.height(8.dp))
                DetailButton(
                    onClick = onClick
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun DetailButton(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(136.dp)
            .height(36.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = secUn,
            contentColor = black,
            disabledBackgroundColor = gray,
            disabledContentColor = black
        ),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(
            width = 1.dp,
            color = grayLine,
        )
    ) {
        Text(
            text = stringResource(R.string.detail),
            fontStyle = FontStyle(R.font.mamelon),
            color = Color.White,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun CharacterInfoPreview() {
    CharacterInfo(
        onClick = {},
        characterName = ResourceStorer.character[0].name,
        characterInfo = ResourceStorer.character[0].info,
        showDetailButton = true,
        characterPhoto = ResourceStorer.character[0].photo
    )
}


@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun DetailButtonPreview() {
    DetailButton(
        onClick = {}
    )
}