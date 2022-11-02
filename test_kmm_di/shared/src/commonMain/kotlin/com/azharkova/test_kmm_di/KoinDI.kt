package com.azharkova.test_kmm_di
import com.azharkova.test_kmm_di.network.http.NetworkClient
import com.azharkova.test_kmm_di.service.NewsService
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import kotlin.reflect.KClass

class KoinDI : KoinComponent {
   val serviceModule = module {
       single { NetworkClient() }
       single { NewsService(get()) }
   }

    val presenterModule = module {
        factory<NewsPresenter> { NewsPresenter(get()) }
    }

    fun start() = startKoin {
        modules(listOf(serviceModule, presenterModule))
    }
}

class KoinDIFabric {
    companion object {
        val instance = KoinDIFabric()
    }
   val koinDI: KoinDI by lazy {
        KoinDI()
    }

    init {
        koinDI.start()
    }

}

fun <T : Any> KoinDIFabric.resolve(clazz: KClass<*>): T? {
    if (clazz != null) {
        return this.koinDI.getKoin().get(clazz) as? T
    }
    return null
}