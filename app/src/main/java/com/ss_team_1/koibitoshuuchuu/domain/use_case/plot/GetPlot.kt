package com.ss_team_1.koibitoshuuchuu.domain.use_case.plot

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