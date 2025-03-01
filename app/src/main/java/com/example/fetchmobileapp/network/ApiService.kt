package com.example.fetchmobileapp.network

import com.example.fetchmobileapp.model.Item
import retrofit2.http.GET

interface ApiService {
    @GET("/hiring.json")
    suspend fun getItems(): List<Item>
}