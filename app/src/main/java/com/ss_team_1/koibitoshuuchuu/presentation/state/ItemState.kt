package com.ss_team_1.koibitoshuuchuu.presentation.state

import com.ss_team_1.koibitoshuuchuu.data.data_source.item.numOfItems
import com.ss_team_1.koibitoshuuchuu.domain.model.Item

data class ItemState (
    val Items: List<Item> = List(numOfItems) {
        Item(it, 0)
    }
)