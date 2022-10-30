package com.azharkova.test_kmm_di

import com.azharkova.test_kmm_di.network.http.NetworkClient
import com.azharkova.test_kmm_di.service.NewsService

object DI {
    val httpClient: NetworkClient by lazy {
        NetworkClient()
    }

    val newsService: NewsService by lazy {
        NewsService(httpClient)
    }
}
