package com.ss_team_1.koibitoshuuchuu.domain.use_case.item

import com.ss_team_1.koibitoshuuchuu.domain.model.Item
import com.ss_team_1.koibitoshuuchuu.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow

class GetItemById(
    private val repository: ItemRepository
) {
    operator fun invoke(id: Int): Flow<Item> {
        return repository.getItem(id)
    }
}