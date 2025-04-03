package com.example.fetchmobileapp.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fetchmobileapp.data.local.model.ItemDb

@Dao
interface ItemDao {
    @Insert
    suspend fun insertItemList(items: List<ItemDb>)

    @Query("SELECT listId FROM item_table ORDER BY listId ")
    suspend fun getListIds(): List<Int>

    @Query("SELECT * FROM item_table WHERE listId = :listId AND TRIM(name) != ''")
    suspend fun getItemsFromList(listId: Int): List<ItemDb>

    @Query("SELECT COUNT(*) FROM item_table")
    suspend fun getItemCountFromTable(): Int
}