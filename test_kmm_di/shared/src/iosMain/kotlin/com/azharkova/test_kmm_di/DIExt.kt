package com.azharkova.test_kmm_di

import DIFabric
import KodeinDI
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import kotlin.reflect.KClass

fun<T: Any> DIFabric.createType(type: ObjCClass): KClass<T>? {
    return getOriginalKotlinClass(type) as? KClass<T>
}

/*
fun <T : Any> DIFabric.resolve(type: ObjCClass): T? {
    val clazz = createType<T>(type)
    if (clazz != null) {
        return resolveDirect() as? T
    }
    return null
}*/