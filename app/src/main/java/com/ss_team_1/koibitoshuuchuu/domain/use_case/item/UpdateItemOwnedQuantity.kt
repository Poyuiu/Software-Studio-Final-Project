package com.ss_team_1.koibitoshuuchuu.domain.use_case.item

import com.ss_team_1.koibitoshuuchuu.domain.repository.ItemRepository
import kotlinx.coroutines.flow.last

class UpdateItemOwnedQuantity(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(id: Int, changeAmount: Int) {
        val newQuantity = repository.getItem(id).last().quantity_owned + changeAmount
        repository.setItemOwnedQuantity(id, newQuantity)
    }
}