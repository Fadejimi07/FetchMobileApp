package com.example.fetchmobileapp.repository

import com.example.fetchmobileapp.model.Item
import com.example.fetchmobileapp.network.ApiService
import com.example.fetchmobileapp.room.ItemDao
import javax.inject.Inject

class FetchItemsRepositoryImpl @Inject constructor(
    private val itemDao: ItemDao,
    private val apiService: ApiService
) :
    FetchItemsRepository {
    override suspend fun fetchItemsFromOnlineApi(): List<Item> {
        return apiService.getItems()
    }

    override suspend fun insertItemsIntoDB(items: List<Item>) {
        itemDao.insertItemList(items)
    }

    override suspend fun getListIdsFromDB(): List<Int> {
        return itemDao.getListIds()
    }

    override suspend fun getItemsByListIdFromDB(listId: Int): List<Item> {
        return itemDao.getItemsFromList(listId)
    }

    override suspend fun getItemsCountInDB(): Int {
        return itemDao.getItemCountFromTable()
    }
}