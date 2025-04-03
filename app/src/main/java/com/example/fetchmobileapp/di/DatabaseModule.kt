package com.example.fetchmobileapp.di

import android.content.Context
import androidx.room.Room
import com.example.fetchmobileapp.data.local.room.ItemDB
import com.example.fetchmobileapp.data.local.room.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
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