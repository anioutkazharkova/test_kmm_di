package com.azharkova.otus_kmm.service

import com.azharkova.otus_kmm.data.NewsList
import com.azharkova.otus_kmm.network.config.NetworkConfig
import com.azharkova.otus_kmm.network.http.NetworkClient
import io.ktor.client.*

class NewsService(private val httpClient: NetworkClient) {

    suspend fun loadNews(): Result<NewsList> {
        return httpClient.request(URL)
    }

    companion object {
        val  URL = "https://newsapi.org/v2/everything?q=science&apiKey=${NetworkConfig.apiKey}"
    }
}