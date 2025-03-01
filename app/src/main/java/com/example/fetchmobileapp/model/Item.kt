package com.example.fetchmobileapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity("item_table")
data class Item(
    @PrimaryKey(autoGenerate = false)
    @SerialName(value = "id")
    val id: Int,
    @SerialName(value = "listId")
    val listId: Int,
    @SerialName(value = "name")
    val name: String?,
)