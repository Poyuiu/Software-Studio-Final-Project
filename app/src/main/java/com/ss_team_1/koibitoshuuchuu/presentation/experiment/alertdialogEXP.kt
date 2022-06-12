package com.ss_team_1.koibitoshuuchuu.presentation.experiment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ss_team_1.koibitoshuuchuu.presentation.characternamelist
import com.ss_team_1.koibitoshuuchuu.ui.theme.Purple500

@Preview
@Composable
fun CallAlertDialog() {
    val isDialogOpen = remember { mutableStateOf(false)}

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        ShowAlertDialog(isDialogOpen)

        Button(
            onClick = {
                isDialogOpen.value = true
            },
            modifier = Modifier
                .padding(10.dp)
                .height(50.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Purple500)
        ) {
            Text(
                text = "Show Popup",
                color = Color.White
            )
        }
    }
}

@Composable
fun ShowAlertDialog(isDialogOpen: MutableState<Boolean>) {
    val emailVal = remember { mutableStateOf("") }
    val passwordVal = remember { mutableStateOf("") }

    val passwordVisibility = remember {
        mutableStateOf(false)
    }
    val focusRequester = remember {
        FocusRequester
    }

    if(isDialogOpen.value) {
        Dialog(onDismissRequest = { isDialogOpen.value = false }) {
            Surface(
                modifier = Modifier
                    .width(300.dp)
                    .height(400.dp)
                    .padding(5.dp),
                shape = RoundedCornerShape(5.dp),
                color = Color.Yellow
            ) {
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.padding(5.dp))

                    Text(
                        text = "Login Popup",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )

                    Image(
                        painter = painterResource(id = characternamelist[0]),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    OutlinedTextField(
                        value = emailVal.value,
                        onValueChange = { emailVal.value = it },
                        label = { Text(text = "Email Address") },
                        placeholder = { Text(text = "Email Address") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    OutlinedTextField(
                        value = passwordVal.value,
                        onValueChange = { passwordVal.value = it },
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    passwordVisibility.value = !passwordVisibility.value
                                }
                            ) {
                                Icon(painter = painterResource(id = characternamelist[1]), contentDescription ="",
                                    tint = if (passwordVisibility.value) Purple500 else Color.Gray
                                )
                            }
                        },
                        label = { Text(text = "Password") },
                        placeholder = { Text(text = "Password") },
                        singleLine = true,
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else
                            PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    Spacer(modifier = Modifier.padding(15.dp))

                    Button(
                        onClick = {
                            isDialogOpen.value = false
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(60.dp)
                            .padding(10.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Purple500)
                    ) {
                        Text(
                            text = "Close",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }

}
