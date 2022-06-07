package com.ss_team_1.koibitoshuuchuu.data.data_source.item

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.Item
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.itemDataStore: DataStore<Preferences> by preferencesDataStore(name="item_data")
private const val numOfItems = 5

class ItemDataStore(val context: Context) {
    private val _quantity = List(numOfItems) {
        intPreferencesKey("quantity$it")
    }

    val itemDataFlow = context.itemDataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { item ->
            List(numOfItems) {
                Item(it, item[_quantity[it]] ?: 0)
            }
        }

    fun getItem(id: Int): Flow<Item> {
        return context.itemDataStore.data
            .catch {
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }
            .map { item ->
                Item(id, item[_quantity[id]] ?: 0)
            }
    }

    suspend fun setQuantity(id: Int, newQuantity: Int) {
        context.itemDataStore.edit { item ->
            item[_quantity[id]] = newQuantity
        }
    }
}