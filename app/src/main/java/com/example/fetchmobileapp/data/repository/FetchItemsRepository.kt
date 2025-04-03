package com.example.fetchmobileapp.data.repository

import com.example.fetchmobileapp.data.local.model.ItemDb
import com.example.fetchmobileapp.ui.model.Item

interface FetchItemsRepository {
    suspend fun fetchItemsFromOnlineApi(): List<ItemDb>

    suspend fun insertItemsIntoDB(items: List<ItemDb>)

    suspend fun getListIdsFromDB(): List<Int>

    suspend fun getItemsByListIdFromDB(listId: Int): List<Item>

    suspend fun getItemsCountInDB(): Int
}