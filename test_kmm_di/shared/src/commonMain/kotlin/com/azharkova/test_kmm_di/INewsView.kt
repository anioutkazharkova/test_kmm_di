package com.azharkova.test_kmm_di

import com.azharkova.test_kmm_di.data.NewsList

interface INewsView : IView {
    fun setupData(data: NewsList)
}