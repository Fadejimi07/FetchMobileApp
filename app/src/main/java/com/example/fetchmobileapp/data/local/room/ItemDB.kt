package com.example.fetchmobileapp.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fetchmobileapp.data.local.model.ItemDb

@Database(entities = [ItemDb::class], version = 1)
abstract class ItemDB : RoomDatabase() {
    // DAO
    abstract val itemDao: ItemDao
}