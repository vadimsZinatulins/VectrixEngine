package com.vectrix.resource

interface ResourceLoader<T : Resource> {
    fun load(params: Map<String, Any>): T
}