package com.ss_team_1.koibitoshuuchuu.presentation.utils

import androidx.annotation.DrawableRes
import com.ss_team_1.koibitoshuuchuu.R


class CharacterInfoAndPlotStorer {
    companion object {
        val character: List<SingleCharaterInfoAndPlotStorer> = listOf(
            //四季映姫
            SingleCharaterInfoAndPlotStorer(
                id = 0,
                name = R.string.character0_name,
                photo = R.drawable.character_0_photo_main,
                info = R.string.character0_info,
                plotList =
                listOf(
                    Plot(
                        title = R.string.character0_plot0_title,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.character_0_photo_main,
                                R.string.character0_plot0_snapshot0
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_main,
                                R.string.character0_plot0_snapshot1
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_main,
                                R.string.character0_plot0_snapshot2
                            ),
                        )
                    ),
                ),
                introduction = R.string.character0_introduction,
            ),
            //魂魄妖夢
            SingleCharaterInfoAndPlotStorer(
                id = 1,
                name = R.string.character1_name,
                photo = R.drawable.character_1_photo,
                info = R.string.character1_info,
                plotList =
                listOf(
                ),
                introduction = R.string.character1_introduction,
            ),
        )
    }
}

class SingleCharaterInfoAndPlotStorer {
    val id: Int
    val plotList: List<Plot>
    val name: Int
    val photo: Int
    val info: Int
    val introduction: Int

    constructor(
        id: Int,
        name: Int,
        @DrawableRes photo: Int,
        info: Int,
        plotList: List<Plot>,
        introduction: Int,
    ) {
        this.id = id
        this.plotList = plotList
        this.name = name
        this.photo = photo
        this.info = info
        this.introduction = introduction
    }
}

class Plot {
    val title: Int
    val plotContent: List<PlotSnapShot>

    constructor(title: Int, plotContent: List<PlotSnapShot>) {
        this.title = title
        this.plotContent = plotContent
    }
}

class PlotSnapShot {
    val characterPhoto: Int
    val plotDiscription: Int

    constructor(photo: Int, discription: Int) {
        this.plotDiscription = discription
        this.characterPhoto = photo
    }
}

