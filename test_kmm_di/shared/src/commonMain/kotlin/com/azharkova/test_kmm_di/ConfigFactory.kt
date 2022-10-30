package com.azharkova.test_kmm_di

import DIFabric


interface  IConfigFactory {
    fun createPresenter():IPresenter?
}

class NewsConfig : IConfigFactory {
    override fun createPresenter(): IPresenter? {
        return DIFabric.resolveDirect<NewsPresenter>() as? INewsPresenter
    }
}
class ConfigFactory {
    companion object {
        val shared = ConfigFactory()
    }

    fun createPresenter(view: IView): IPresenter? {
        if (view is INewsView) {
            return NewsConfig().createPresenter()
        }
        return null
    }
}