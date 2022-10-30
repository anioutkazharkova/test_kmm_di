package com.azharkova.test_kmm_di.network

import kotlinx.coroutines.CoroutineDispatcher

expect val uiDispatcher: CoroutineDispatcher
expect val ioDispatcher: CoroutineDispatcher