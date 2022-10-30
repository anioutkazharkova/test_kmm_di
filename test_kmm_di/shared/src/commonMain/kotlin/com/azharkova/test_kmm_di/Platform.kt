package com.azharkova.test_kmm_di

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform