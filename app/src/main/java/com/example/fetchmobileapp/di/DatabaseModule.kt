package com.example.fetchmobileapp.di

import android.content.Context
import androidx.room.Room
import com.example.fetchmobileapp.room.ItemDB
import com.example.fetchmobileapp.room.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object DatabaseModule {
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): ItemDB {
        return Room.databaseBuilder(
            context = context,
            ItemDB::class.java,
            "item_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideItemDao(itemDB: ItemDB): ItemDao {
        return itemDB.itemDao
    }
}