package com.azharkova.test_kmm_di

import KodeinDI
import com.azharkova.test_kmm_di.network.uiDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.kodein.di.DI
import org.kodein.di.DIAware

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

open class BasePresenterDI : IPresenter, DIAware {
    var view: IView? = null
    val job = SupervisorJob()
    override val di: DI = KodeinDI.shared.di

    protected var scope: CoroutineScope = CoroutineScope(uiDispatcher + job)

    override fun attach(view: IView) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }
}