package com.azharkova.test_kmm_di

import DIFabric
import KodeinDI
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.component.get
import kotlin.reflect.KClass

fun<T: Any> KoinDIFabric.createType(type: ObjCClass): KClass<T>? {
    return getOriginalKotlinClass(type) as? KClass<T>
}


fun <T : Any> KoinDIFabric.resolve(type: ObjCClass): T? {
    val clazz = createType<T>(type)
    if (clazz != null) {
        return this.koinDI.getKoin().get(clazz) as? T
    }
    return null
}

