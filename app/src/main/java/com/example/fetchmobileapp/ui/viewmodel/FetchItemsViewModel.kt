package com.example.fetchmobileapp.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchmobileapp.domain.usecases.GetAllItemListIdsFromDBUseCase
import com.example.fetchmobileapp.domain.usecases.GetAllItemsByListIdFromDBUseCase
import com.example.fetchmobileapp.domain.usecases.GetAllItemsFromNetworkUseCase
import com.example.fetchmobileapp.domain.usecases.GetItemCountInDBUseCase
import com.example.fetchmobileapp.domain.usecases.InsertItemsFromNetworkToDatabaseUseCase
import com.example.fetchmobileapp.ui.model.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FetchItemsViewModel @Inject constructor(
    private val getAllItemsFromNetworkUseCase: GetAllItemsFromNetworkUseCase,
    private val insertItemsFromNetworkToDatabaseUseCase: InsertItemsFromNetworkToDatabaseUseCase,
    private val getAllItemListIdsFromDBUseCase: GetAllItemListIdsFromDBUseCase,
    private val getAllItemsByListIdFromDBUseCase: GetAllItemsByListIdFromDBUseCase,
    private val getItemCountInDBUseCase: GetItemCountInDBUseCase,
) :
    ViewModel() {
    var items by mutableStateOf<Map<Int, List<Item>>>(emptyMap())
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val itemsCountInDB = getItemCountInDBUseCase.invoke()
            if (itemsCountInDB > 0) {
                fetchItemsFromDB()
            } else {
                val onlineItems = getAllItemsFromNetworkUseCase.invoke()
                insertItemsFromNetworkToDatabaseUseCase.invoke(onlineItems)
                fetchItemsFromDB()
            }
        }
    }

    private fun fetchItemsFromDB() {
        viewModelScope.launch(Dispatchers.IO) {
            val itemsListIds = getAllItemListIdsFromDBUseCase.invoke()
            val itemMap: MutableMap<Int, List<Item>> = mutableMapOf()
            for (listId in itemsListIds) {
                itemMap[listId] = getAllItemsByListIdFromDBUseCase.invoke(listId)
            }
            items = itemMap
        }
    }
}