package com.ss_team_1.koibitoshuuchuu.domain.use_case.plot

class GetPlot {
    operator fun invoke(
        characterName: String, level: Int
    ):List<String> {
        return listOf("one", "two", "three")
    }
}