package com.ss_team_1.koibitoshuuchuu.presentation.utils

import android.util.Log

fun focusTimeFormatter(milliSecond: Long): String {
    val totalSecond = milliSecond / 1000
    val minutes = totalSecond / 60
    val seconds = totalSecond % 60
    val formattedTime = String.format("%02d:%02d", minutes, seconds)
//    Log.d("formatter", "minutes: $minutes, seconds: $seconds")
//    Log.d("formatter", formattedTime)
    return formattedTime
}