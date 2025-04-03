package com.example.fetchmobileapp.data.network.model

import com.example.fetchmobileapp.data.local.model.ItemDb

data class ItemNetwork(
    val id: Int,
    val listId: Int,
    val name: String
) {
    fun toItemDb(): ItemDb {
        return ItemDb(
            id = this.id,
            listId = this.listId,
            name = this.name
        )
    }
}