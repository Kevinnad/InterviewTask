package com.example.myapplication.repositories

import com.example.myapplication.Constants
import com.example.myapplication.network.Services
import com.example.myapplication.network.handleRequest
import javax.inject.Inject

class ApiRepo @Inject constructor(private val services: Services) {

    suspend fun fetchList() = handleRequest { services.getListApi(Constants.API_KEY) }
}