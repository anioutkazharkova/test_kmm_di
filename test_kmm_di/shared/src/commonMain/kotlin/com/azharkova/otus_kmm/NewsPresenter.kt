package com.azharkova.otus_kmm

import com.azharkova.otus_kmm.data.NewsList
import com.azharkova.otus_kmm.network.ioDispatcher
import com.azharkova.otus_kmm.network.uiDispatcher
import com.azharkova.otus_kmm.service.NewsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsPresenter() : BasePresenter(), INewsPresenter {
    var newsFlow = MutableStateFlow<NewsList?>(null)
  val newsService: NewsService by lazy {
        DI.newsService
    }

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

open class BasePresenter : IPresenter {
    var view: IView? = null
    val job = SupervisorJob()
    protected var scope: CoroutineScope = CoroutineScope(uiDispatcher + job)

    override fun attach(view: IView) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }
}

interface IView {

}

interface IPresenter {
    fun attach(view: IView)

    fun detach()
}

interface  INewsPresenter : IPresenter{
    fun loadNews()
}

interface INewsView : IView {
    fun setupData(data: NewsList)
}