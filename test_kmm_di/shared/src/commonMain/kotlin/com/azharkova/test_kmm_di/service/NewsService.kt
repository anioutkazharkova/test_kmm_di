package com.azharkova.test_kmm_di.service

import com.azharkova.test_kmm_di.data.NewsList
import com.azharkova.test_kmm_di.network.config.NetworkConfig
import com.azharkova.test_kmm_di.network.http.NetworkClient

class NewsService(private val httpClient: NetworkClient) {

    suspend fun loadNews(): Result<NewsList> {
        return httpClient.request(URL)
    }

    companion object {
        val  URL = "https://newsapi.org/v2/everything?q=science&apiKey=${NetworkConfig.apiKey}"
    }
}