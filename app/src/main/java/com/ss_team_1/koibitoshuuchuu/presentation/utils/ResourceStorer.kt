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
                        title = R.string.character0_plot2_title,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot4_snapshot0,
                                R.drawable.background_workplace
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_sleep,
                                R.string.character0_plot4_snapshot1,
                                R.drawable.background_hospital
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_awake,
                                R.string.character0_plot4_snapshot2,
                                R.drawable.background_hospital
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_laugh,
                                R.string.character0_plot4_snapshot3,
                                R.drawable.background_hospital
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_laugh,
                                R.string.character0_plot4_snapshot4,
                                R.drawable.background_hospital
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_laugh,
                                R.string.character0_plot4_snapshot5,
                                R.drawable.background_hospital
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_laugh,
                                R.string.character0_plot4_snapshot6,
                                R.drawable.background_hospital
                            ),
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot4_snapshot7,
                                R.drawable.background_only_color
                            ),
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot4_snapshot8,
                                R.drawable.background_only_color
                            ),
                        )
                    ),
                    Plot(
                        title = R.string.character0_plot0_title,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot0_snapshot0,
                                R.drawable.background_river
                            ),
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot0_snapshot1,
                                R.drawable.background_river
                            ),
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot0_snapshot3,
                                R.drawable.background_river
                            ),
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot0_snapshot4,
                                R.drawable.background_river
                            ),
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot0_snapshot5,
                                R.drawable.background_river
                            ),
                        )
                    ),
                    Plot(
                        title = R.string.character0_plot1_title,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot1_snapshot0,
                                R.drawable.background_river
                            ),
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot1_snapshot1,
                                R.drawable.background_river
                            ),
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot1_snapshot2,
                                R.drawable.background_river
                            ),
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot1_snapshot3,
                                R.drawable.background_river
                            ),
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot1_snapshot4,
                                R.drawable.background_river
                            ),
                        )
                    ),
                    Plot(
                        title = R.string.character0_plot2_title,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.character_0_photo_main,
                                R.string.character0_plot2_snapshot0,
                                R.drawable.background_workplace
                            ),
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot2_snapshot1,
                                R.drawable.background_workplace
                            ),
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot2_snapshot2,
                                R.drawable.background_workplace
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_smile,
                                R.string.character0_plot2_snapshot3,
                                R.drawable.background_workplace
                            ),
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.character0_plot2_snapshot4,
                                R.drawable.background_workplace
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_judge_me,
                                R.string.character0_plot2_snapshot5,
                                R.drawable.background_workplace
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_smile,
                                R.string.character0_plot2_snapshot6,
                                R.drawable.background_workplace
                            ),
                        )
                    ),
                    Plot(
                        title = R.string.character0_plot3_title,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.character_0_photo_go_hell,
                                R.string.character0_plot3_snapshot0,
                                R.drawable.background_workplace
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_disappoint,
                                R.string.character0_plot3_snapshot1,
                                R.drawable.background_workplace
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_charming,
                                R.string.character0_plot3_snapshot2,
                                R.drawable.background_workplace
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_angry,
                                R.string.character0_plot3_snapshot3,
                                R.drawable.background_workplace
                            ),
                            PlotSnapShot(
                                R.drawable.character_0_photo_disappoint,
                                R.string.character0_plot3_snapshot4,
                                R.drawable.background_workplace
                            )
                        )
                    )
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
                    Plot(
                        title = R.string.a_space,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.a_space,
                                R.drawable.background_only_color
                            ),
                        )
                    ),
                    Plot(
                        title = R.string.a_space,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.a_space,
                                R.drawable.background_only_color
                            ),
                        )
                    ),
                    Plot(
                        title = R.string.a_space,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.a_space,
                                R.drawable.background_only_color
                            ),
                        )
                    ),
                    Plot(
                        title = R.string.a_space,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.a_space,
                                R.drawable.background_only_color
                            ),
                        )
                    ),
                    Plot(
                        title = R.string.a_space,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.a_space,
                                R.drawable.background_only_color
                            ),
                        )
                    ),
                ),
                introduction = R.string.character1_introduction,
            ),
            SingleCharacterInfoAndPlotStormer(
                id = 2,
                name = R.string.character2_name,
                photo = R.drawable.character_2_photo,
                info = R.string.character2_info,
                plotList =
                listOf(
                    Plot(
                        title = R.string.a_space,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.a_space,
                                R.drawable.background_only_color
                            ),
                        )
                    ),
                    Plot(
                        title = R.string.a_space,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.a_space,
                                R.drawable.background_only_color
                            ),
                        )
                    ),
                    Plot(
                        title = R.string.a_space,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.a_space,
                                R.drawable.background_only_color
                            ),
                        )
                    ),
                    Plot(
                        title = R.string.a_space,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.a_space,
                                R.drawable.background_only_color
                            ),
                        )
                    ),
                    Plot(
                        title = R.string.a_space,
                        plotContent = listOf(
                            PlotSnapShot(
                                R.drawable.background_transparent,
                                R.string.a_space,
                                R.drawable.background_only_color
                            ),
                        )
                    ),
                ),
                introduction = R.string.character2_introduction,
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

        val background = mapOf(
            Pair("transparent", R.drawable.background_transparent),
            Pair("river", R.drawable.background_river)
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

