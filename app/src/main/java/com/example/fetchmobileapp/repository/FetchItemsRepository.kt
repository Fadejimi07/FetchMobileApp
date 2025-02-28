package com.example.fetchmobileapp.repository

import com.example.fetchmobileapp.model.Item

interface FetchItemsRepository {
    suspend fun fetchItemsFromOnlineApi(): List<Item>

    suspend fun insertItemsIntoDB(items: List<Item>)

    suspend fun getListIdsFromDB(): List<Int>

    suspend fun getItemsByListIdFromDB(listId: Int): List<Item>

    suspend fun getItemsCountInDB(): Int
}