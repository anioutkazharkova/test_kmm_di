package com.azharkova.test_kmm_di.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


actual val uiDispatcher: CoroutineDispatcher = Dispatchers.Main
actual val ioDispatcher: CoroutineDispatcher = Dispatchers.IO