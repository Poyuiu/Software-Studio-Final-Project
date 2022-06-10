package com.ss_team_1.koibitoshuuchuu.presentation.utils

import androidx.annotation.DrawableRes
import com.ss_team_1.koibitoshuuchuu.R


class ResourceStorer {
    companion object {
        val character: List<SingleCharacterInfoAndPlotStormer> = listOf(
            //四季映姫
            SingleCharacterInfoAndPlotStormer(
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
                                R.string.character0_plot0_snapshot0,
                                R.drawable.background_only_color
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_main,
                                R.string.character0_plot0_snapshot1,
                                R.drawable.background_only_color
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_main,
                                R.string.character0_plot0_snapshot2,
                                R.drawable.background_only_color
                            ),
                        )
                    ),
                ),
                introduction = R.string.character0_introduction,
            ),
            //魂魄妖夢
            SingleCharacterInfoAndPlotStormer(
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
        val weekdayName = listOf(
            R.string.sunday,
            R.string.monday,
            R.string.tuesday,
            R.string.wednesday,
            R.string.thursday,
            R.string.friday,
            R.string.saturday,
            R.string.sunday,
        )
    }
}

class SingleCharacterInfoAndPlotStormer {
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
    val plotDescription: Int
    val backgroundPhoto: Int

    constructor(photo: Int, description: Int, backgroundPhoto: Int) {
        this.plotDescription = description
        this.characterPhoto = photo
        this.backgroundPhoto = backgroundPhoto
    }
}

