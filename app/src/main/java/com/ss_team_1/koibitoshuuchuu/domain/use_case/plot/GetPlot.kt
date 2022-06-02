package com.ss_team_1.koibitoshuuchuu.domain.use_case.plot

import android.provider.ContactsContract
import androidx.annotation.DrawableRes
import com.ss_team_1.koibitoshuuchuu.R


class Plot {
    val title: String
    val lock: Boolean
    val haveRead: Boolean

    constructor(title: String, lock: Boolean = true, haveRead: Boolean = false) {
        this.title = title
        this.lock = lock
        this.haveRead = haveRead
    }
}


class Character {
    val plotList: List<Plot>
    val name: String
    val photo: Int
    val info: String
    val introduction: String
    val focusRecord: Map<String, Float>

    constructor(
        name: String,
        @DrawableRes photo: Int,
        info: String,
        plotList: List<Plot>,
        introduction: String,
        focusRecord: Map<String, Float>
    ) {
        this.plotList = plotList
        this.name = name
        this.photo = photo
        this.info = info
        this.introduction = introduction
        this.focusRecord = focusRecord
    }
}