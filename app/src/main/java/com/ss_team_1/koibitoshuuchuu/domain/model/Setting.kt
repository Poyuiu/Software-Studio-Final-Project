package com.ss_team_1.koibitoshuuchuu.domain.model

data class Setting (
    val soundEffectVolume: Int,
    val bgmVolume: Int,
    val keepScreenOpen: Boolean,
    val language: Int, //ex: 0: chinese, 1: english, 2: japanese, ...
    val restrictedMode: Boolean
)