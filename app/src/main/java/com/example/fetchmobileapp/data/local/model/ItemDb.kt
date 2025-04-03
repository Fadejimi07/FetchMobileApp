package com.example.fetchmobileapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fetchmobileapp.ui.model.Item

@Entity("item_table")
data class ItemDb(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val listId: Int,
    val name: String?,
) {
    fun toItem(): Item {
        return Item(
            id = id,
            listId = listId,
            name = name
        )
    }
}