package com.example.fetchmobileapp.network

import com.example.fetchmobileapp.model.Item
import retrofit2.http.GET

interface ApiService {
    @GET("/hiring")
    suspend fun getList(): List<Item>
}