package com.ss_team_1.koibitoshuuchuu.presentation.event

sealed class PlotStateEvent {
    data class SetPlotState(val characterId: Int, val plotNum: Int): PlotStateEvent()
    data class SetPlotStateValue(val characterId: Int, val plotNum: Int, val newValue: Boolean): PlotStateEvent()
}
