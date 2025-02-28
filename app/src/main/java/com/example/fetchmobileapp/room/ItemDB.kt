package com.example.fetchmobileapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fetchmobileapp.model.Item

@Database(entities = [Item::class], version = 1)
abstract class ItemDB : RoomDatabase() {
    // DAO
    abstract val itemDao: ItemDao
}