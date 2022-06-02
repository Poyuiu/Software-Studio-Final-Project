package com.ss_team_1.koibitoshuuchuu.domain.use_case.plot

import com.ss_team_1.koibitoshuuchuu.R
import com.ss_team_1.koibitoshuuchuu.presentation.components.BarChart

data class PlotUseCases(
    val shikieiki: Character = Character(
        name = "四季映姫",
        photo = R.drawable.shikieiki_main,
        info = "暱稱：閻蘿王\n" +
                "\n" +
                "身高：較高與高\n" + "之間\n" +
                "種族：閻魔\n" +
                "\n" +
                "住所：彼岸\n" +
                "職業：審判官",
        plotList =
        listOf(
            Plot("第一個故事", false, true),
            Plot("不是第二個故事", false, true),
            Plot("可能是第三個故事", false, true),
            Plot("跳過第四個故事", false, true),
            Plot("懶得寫第五個故事", false),
            Plot("沒有第六個故事", false),
            Plot("不是最後一個故事"),
            Plot("是最後一個故事"),
        ),
        introduction = "四季映姫是閻魔之一，擔當幻想郷及其他地區的閻魔，負責對死者的裁決。在是非曲直廳中負責審判死者的工作，死神小野塚小町的上司。\n" +
                "\n" +
                "平時在彼岸的是非曲直廳内裁決死者的靈魂，有時會到幻想郷去説教，警告人們積累善行，以免被判下地獄。\n" +
                "\n" +
                "身穿十分鄭重的袍裝，性格嚴肅認真，不過偶爾也有意外萌的一面。",
        focusRecord = mapOf(
                Pair("5/28", 6f),
                Pair("5/29", 4f),
                Pair("5/30", 3f),
                Pair("5/31", 7f),
                Pair("6/1", 1f),
                Pair("6/2", 2f),
                Pair("6/3", 1f),
            )
    )
)