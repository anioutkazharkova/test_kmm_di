package com.azharkova.test_kmm_di.data

@kotlinx.serialization.Serializable
data class NewsList(
    var articles: List<NewsItem>? = null
)