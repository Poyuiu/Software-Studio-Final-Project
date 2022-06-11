package com.ss_team_1.koibitoshuuchuu.domain.repository

import com.ss_team_1.koibitoshuuchuu.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getAllItem(): Flow<List<Item>>
    fun getItem(id: Int): Flow<Item>
    suspend fun setItemOwnedQuantity(id: Int, newQuantity: Int)
}