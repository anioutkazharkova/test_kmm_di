package com.azharkova.otus_kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform