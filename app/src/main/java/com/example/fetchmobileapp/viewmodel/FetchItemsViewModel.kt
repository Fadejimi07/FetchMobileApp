package com.example.fetchmobileapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchmobileapp.model.Item
import com.example.fetchmobileapp.repository.FetchItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FetchItemsViewModel @Inject constructor(private val repo: FetchItemsRepository) :
    ViewModel() {
    var items by mutableStateOf<Map<Int, List<Item>>>(emptyMap())
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val itemsCountInDB = repo.getItemsCountInDB()
            if (itemsCountInDB > 0) {
                fetchItemsFromDB()
            } else {
                val onlineItems = repo.fetchItemsFromOnlineApi()
                repo.insertItemsIntoDB(onlineItems)
                fetchItemsFromDB()
            }
        }
    }

    private fun fetchItemsFromDB() {
        viewModelScope.launch(Dispatchers.IO) {
            val itemsListIds = repo.getListIdsFromDB()
            val itemMap: MutableMap<Int, List<Item>> = mutableMapOf()
            for (listId in itemsListIds) {
                itemMap[listId] = repo.getItemsByListIdFromDB(listId)
            }
            items = itemMap
        }
    }
}