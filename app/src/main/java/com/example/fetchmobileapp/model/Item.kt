package com.example.fetchmobileapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("item_table")
data class Item(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val listId: Int,
    val name: String?,
)