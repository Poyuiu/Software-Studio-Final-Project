package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.ss_team_1.koibitoshuuchuu.data.data_source.item.ItemDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.Item
import com.ss_team_1.koibitoshuuchuu.domain.repository.ItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch

class ItemRepositoryImplementation (
    private val itemDataStore: ItemDataStore
): ItemRepository {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    override fun getAllItem(): LiveData<List<Item>> {
        return itemDataStore.itemDataFlow.asLiveData(coroutineScope.coroutineContext)
    }

    override fun getItem(id: Int): LiveData<Item> {
        return itemDataStore.getItem(id).asLiveData(coroutineScope.coroutineContext)
    }

    override fun updateItemOwnedQuantity(id: Int, changeAmount: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            val newQuantity = itemDataStore.getItem(id).last().quantity_owned + changeAmount
            itemDataStore.setQuantity(id, newQuantity)
        }
    }
}