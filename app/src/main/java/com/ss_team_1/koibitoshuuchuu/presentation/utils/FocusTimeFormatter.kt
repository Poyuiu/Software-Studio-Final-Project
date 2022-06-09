package com.ss_team_1.koibitoshuuchuu.presentation.utils

fun FocusTimeFormatter(milliSecond: Long): String {
    val totalSecond = milliSecond / 1000
    val minutes = totalSecond / 60
    val seconds = totalSecond % 60
    return if (minutes >= 10) "$minutes" else "0$minutes" + if (seconds >= 10) ":$seconds" else ":0$seconds"
}