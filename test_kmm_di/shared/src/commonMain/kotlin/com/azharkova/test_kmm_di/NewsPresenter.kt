package com.azharkova.test_kmm_di

import com.azharkova.test_kmm_di.data.NewsList
import com.azharkova.test_kmm_di.network.ioDispatcher
import com.azharkova.test_kmm_di.service.NewsService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.kodein.di.instance


class NewsPresenter(private val newsService: NewsService) : BasePresenter(), INewsPresenter {
    var newsFlow = MutableStateFlow<NewsList?>(null)

   override fun loadNews() {
        scope.launch {
            val result = withContext(ioDispatcher) {
                newsService.loadNews()
            }
            result.getOrNull()?.let {
                (view as? INewsView)?.setupData(it)
                newsFlow.tryEmit(it)
            }
        }
    }
}

class NewsPresenterDI() : BasePresenterDI(), INewsPresenter {
    var newsFlow = MutableStateFlow<NewsList?>(null)
    val newsService by di.instance<NewsService>()

    override fun loadNews() {
        scope.launch {
            val result = withContext(ioDispatcher) {
                newsService.loadNews()
            }
            result.getOrNull()?.let {
                (view as? INewsView)?.setupData(it)
                newsFlow.tryEmit(it)
            }
        }
    }
}