package com.ss_team_1.koibitoshuuchuu.domain.repository

import androidx.lifecycle.LiveData

interface ItemRepository {
    fun getItemOwnedQuantity(id: Int): LiveData<Int>
    fun updateItemOwnedQuantity(id: Int, changeAmount: Int)
}