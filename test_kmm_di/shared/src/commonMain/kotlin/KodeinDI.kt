import com.azharkova.test_kmm_di.NewsPresenter
import com.azharkova.test_kmm_di.NewsPresenterDI
import com.azharkova.test_kmm_di.network.http.NetworkClient
import com.azharkova.test_kmm_di.service.NewsService
import org.kodein.di.*
import kotlin.reflect.KClass

class KodeinDI {
    companion object {
        val shared = KodeinDI()
    }

    val serviceModule = DI.Module("services") {
        bindSingleton { NetworkClient() }
        bindSingleton { NewsService(instance()) }
    }

    val presenterModule = DI.Module("presenter") {
        bindProvider{ NewsPresenter(instance())}
    }

    val presenterDIModule = DI.Module("presenterDI") {
        bindProvider { NewsPresenterDI() }
    }

    val di = DI {
        import(serviceModule)
        import(presenterModule)
        //import(presenterDIModule)

    }
}

object DIFabric  {
     val di: DI by lazy {
        KodeinDI().di
    }

    val diDirect = di.direct

    inline fun <reified T> resolve(): LazyDelegate<T> {
        return di.instance()
    }

    inline fun<reified  T> resolveDirect():T? {
        return diDirect.instance()
    }

}


