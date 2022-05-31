package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ss_team_1.koibitoshuuchuu.R


@Composable
fun PlotBotton(
    modifier: Modifier = Modifier,
    navController: NavController,
    lock: Boolean,
    haveRead: Boolean,
    id: Int
) {
    Button(
        onClick = { navController.navigate("friendslist") },
        
    ) {
        Text(text = "PLOT $id")
    }
}