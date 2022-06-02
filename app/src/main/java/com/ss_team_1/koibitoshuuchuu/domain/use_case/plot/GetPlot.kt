package com.ss_team_1.koibitoshuuchuu.domain.use_case.plot

import android.provider.ContactsContract
import androidx.annotation.DrawableRes

class GetPlot {
    operator fun invoke(
        characterName: String, level: Int
    ):List<Plot> {
        return listOf(
            Plot("第一個故事", false, true),
            Plot("不是第二個故事", false),
            Plot("可能是第三個故事", false),
            Plot("跳過第四個故事"),
            Plot("懶得寫第五個故事"),
        )
    }
}

class Plot{
    val title: String
    val lock: Boolean
    val haveRead: Boolean

    constructor(title: String, lock:Boolean = true, haveRead:Boolean = false){
        this.title = title
        this.lock = lock
        this.haveRead = haveRead
    }
}

class Character{
    val plotList: List<Plot>
    val name: String
    val photo: Int
    val info: String
    constructor(
        name: String,
        @DrawableRes photo: Int,
        info: String,
        plotList: List<Plot> =
            listOf(
                Plot("第一個故事", false, true),
                Plot("不是第二個故事", false, true),
                Plot("可能是第三個故事", false, true),
                Plot("跳過第四個故事", false, true),
                Plot("懶得寫第五個故事", false),
                Plot("沒有第六個故事", false),
                Plot("不是最後一個故事"),
                Plot("是最後一個故事"),
            )
    ){
        this.plotList = plotList
        this.name = name
        this.photo = photo
        this.info = info
    }
}