package com.example.fetchmobileapp.data.network

import com.example.fetchmobileapp.data.network.model.ItemNetwork
import retrofit2.http.GET

interface ApiService {
    @GET("/hiring.json")
    suspend fun getItems(): List<ItemNetwork>
}