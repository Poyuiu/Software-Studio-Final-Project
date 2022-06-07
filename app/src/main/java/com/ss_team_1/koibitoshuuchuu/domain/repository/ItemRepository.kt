package com.ss_team_1.koibitoshuuchuu.domain.repository

import androidx.lifecycle.LiveData
import com.ss_team_1.koibitoshuuchuu.domain.model.Item

interface ItemRepository {
    fun getAllItem(): LiveData<List<Item>>
    fun getItem(id: Int): LiveData<Item>
    fun updateItemOwnedQuantity(id: Int, changeAmount: Int)
}