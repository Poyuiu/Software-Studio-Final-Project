package com.ss_team_1.koibitoshuuchuu.presentation.components


import android.service.autofill.Validators.or
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ss_team_1.koibitoshuuchuu.ui.theme.contextFont
import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.ui.theme.AccentDark
import com.ss_team_1.koibitoshuuchuu.ui.theme.grayLine
import com.ss_team_1.koibitoshuuchuu.ui.theme.mainFont

@Preview
@Composable
fun ChangeNameDialog(

): Boolean {
    val cancel = remember {
        mutableStateOf(false)
    }
    val confirm = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .width(340.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.change_name_dialog_title),
            fontSize = 32.sp,
            //color = secUn,
            fontStyle = FontStyle(contextFont),
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = stringResource(id = R.string.change_name_dialog_content),
            fontSize = 19.sp,
            fontStyle = FontStyle(contextFont)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Image(
            painter = painterResource(id = R.drawable.change_name_grid), contentDescription = null
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                //verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "CANCEL",
                    fontSize = 14.sp,
                    fontStyle = FontStyle(mainFont),
                    color = grayLine,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable(
                            enabled = true,
                            onClickLabel = "doesn't buy",
                            onClick = {
                                /*TODO*/
                                cancel.value = true
                            }
                        )
                )
                Text(
                    text = "COMFIRM",
                    fontSize = 14.sp,
                    fontStyle = FontStyle(mainFont),
                    color = AccentDark,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable(
                            enabled = true,
                            onClickLabel = "buy gift",
                            onClick = {
                                /*TODO*/
                                confirm.value = true
                            }
                        )
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
    return cancel.value || confirm.value
}

@Preview(showBackground = true)
@Composable
fun ChangeNamePopUp(): Boolean {
    val spend = remember { mutableStateOf(false) }//沒暗任何案件
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f), RectangleShape)
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            spend.value = ChangeNameDialog()
        }
    }
    return spend.value
}