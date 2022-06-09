package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.ui.theme.*

@Preview
@Composable
private fun DialogBoxPreview() {
    DialogBox(
        text = "快點專心！我可沒法整天在這裡看著你",
        showTriangle = false
    )
}

@Composable
fun DialogBox(
    text: String,
    showTriangle: Boolean = true,
    onClickNext: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(width = 283.dp, height = 153.dp)
            .shadow(elevation = 10.dp)
            .border(width = 6.dp, color = Secondary, shape = RoundedCornerShape(32.dp))
            .background(color = Primary.copy(alpha = 0.95f), shape = RoundedCornerShape(32.dp))
            .zIndex(10f)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(26.dp),
            fontSize = 24.sp,
            fontFamily = huninnFamily
        )
        if (showTriangle) {
            Button(
                onClick = onClickNext,
                elevation = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = Color.Transparent,
                    disabledBackgroundColor = Color.Transparent,
                    disabledContentColor = Color.Transparent
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_dialog_triangle),
                    contentDescription = "Dialog Triangle"
                )
            }

        }
    }
}