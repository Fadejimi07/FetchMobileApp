package com.example.fetchmobileapp.data.repository

import com.example.fetchmobileapp.data.local.model.ItemDb
import com.example.fetchmobileapp.data.local.room.ItemDao
import com.example.fetchmobileapp.data.network.ApiService
import com.example.fetchmobileapp.ui.model.Item
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FetchItemsRepositoryImpl @Inject constructor(
    private val itemDao: ItemDao,
    private val apiService: ApiService
) :
    FetchItemsRepository {
    override suspend fun fetchItemsFromOnlineApi(): List<ItemDb> {
        return apiService.getItems().map { itemNetwork -> itemNetwork.toItemDb() }
    }

    override suspend fun insertItemsIntoDB(items: List<ItemDb>) {
        itemDao.insertItemList(items)
    }

    override suspend fun getListIdsFromDB(): List<Int> {
        return itemDao.getListIds()
    }

    override suspend fun getItemsByListIdFromDB(listId: Int): List<Item> {
        return itemDao.getItemsFromList(listId).map { itemDb -> itemDb.toItem() }
    }

    override suspend fun getItemsCountInDB(): Int {
        return itemDao.getItemCountFromTable()
    }
}