package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import com.ss_team_1.koibitoshuuchuu.data.data_source.item.ItemDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.Item
import com.ss_team_1.koibitoshuuchuu.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow

class ItemRepositoryImplementation (
    private val itemDataStore: ItemDataStore
): ItemRepository {
    override fun getAllItem(): Flow<List<Item>> {
        return itemDataStore.itemDataFlow
    }

    override fun getItem(id: Int): Flow<Item> {
        return itemDataStore.getItem(id)
    }

    override suspend fun setItemOwnedQuantity(id: Int, newQuantity: Int) {
        itemDataStore.setQuantity(id, newQuantity)
    }
}