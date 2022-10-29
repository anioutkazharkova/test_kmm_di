package com.azharkova.otus_kmm

import com.azharkova.otus_kmm.network.http.NetworkClient
import com.azharkova.otus_kmm.service.NewsService
import org.kodein.di.*
import org.kodein.di.DI

object DI {
    val httpClient: NetworkClient by lazy {
        NetworkClient()
    }

    val newsService: NewsService by lazy {
        NewsService(httpClient)
    }
}
