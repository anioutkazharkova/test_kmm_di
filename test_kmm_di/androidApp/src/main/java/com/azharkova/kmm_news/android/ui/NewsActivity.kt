package com.azharkova.news.ui

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.azharkova.kmm_news.android.R
import com.azharkova.news.adapter.NewsAdapter
import com.azharkova.otus_kmm.*

import com.azharkova.otus_kmm.data.NewsList
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance

class NewsActivity : AppCompatActivity(), INewsView {
    private val presenter: INewsPresenter by lazy {
        val presenter = NewsPresenter()
        presenter.attach(this)
        presenter
    }

    private var listView: RecyclerView? = null


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
        presenter.loadNews()
    }

}
