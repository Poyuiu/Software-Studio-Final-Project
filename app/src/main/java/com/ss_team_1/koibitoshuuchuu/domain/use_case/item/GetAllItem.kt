package com.ss_team_1.koibitoshuuchuu.domain.use_case.item

import com.ss_team_1.koibitoshuuchuu.domain.model.Item
import com.ss_team_1.koibitoshuuchuu.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow

class GetAllItem(
    private val repository: ItemRepository
) {
    operator fun invoke(): Flow<List<Item>> {
        return repository.getAllItem()
    }
}