package com.azharkova.test_kmm_di

interface IPresenter {
    fun attach(view: IView)

    fun detach()
}