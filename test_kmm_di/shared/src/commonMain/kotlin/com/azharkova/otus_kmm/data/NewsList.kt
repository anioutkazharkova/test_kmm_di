package com.azharkova.otus_kmm.data

@kotlinx.serialization.Serializable
data class NewsList(
    var articles: List<NewsItem>? = null
)