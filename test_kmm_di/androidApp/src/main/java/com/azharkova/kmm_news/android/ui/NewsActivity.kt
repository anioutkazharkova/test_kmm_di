package com.azharkova.news.ui

import DIFabric
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.azharkova.kmm_news.android.R
import com.azharkova.news.adapter.NewsAdapter
import com.azharkova.test_kmm_di.*

import com.azharkova.test_kmm_di.data.NewsList

class NewsActivity : AppCompatActivity(), INewsView {
    //private val presenter: INewsPresenter by DIFabric.resolve<INewsPresenter>()
//private  val presenter:INewsPresenter by lazy { DIFabric.presenter }
    private var listView: RecyclerView? = null
//private val presenter: INewsPresenter by lazy { NewsPresenterDI() }

    private val presenter: INewsPresenter? by lazy {
        ConfigFactory.shared.createPresenter(this) as? INewsPresenter
    }
    //private val presenter: INewsPresenter? by lazy { DIFabric.resolveDirect() }
    private var adapter: NewsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        listView = findViewById<RecyclerView>(R.id.news_list)
        listView?.layoutManager = LinearLayoutManager(this)

    }

    override fun setupData(data: NewsList) {
        if (adapter == null){
            adapter = NewsAdapter()
        }
        listView?.adapter = adapter
        adapter?.update(data.articles.orEmpty())
    }

    override fun onResume() {
        super.onResume()
        presenter?.attach(this)
        presenter?.loadNews()
    }

    override fun onPause() {
        super.onPause()
        presenter?.detach()
    }

}
