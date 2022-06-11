package com.ss_team_1.koibitoshuuchuu.domain.use_case.item

data class ItemUseCases (
    val getAllItem: GetAllItem,
    val getItemById: GetItemById,
    val updateItemOwnedQuantity: UpdateItemOwnedQuantity,
)