package com.vectrix.resource

import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass

object ResourceManager {
    val _cache = ConcurrentHashMap<Pair<KClass<*>, String>, Resource>()
    val _loaders = ConcurrentHashMap<KClass<*>, ResourceLoader<Resource>>()

    fun <T : Resource> registerLoader(clazz: KClass<T>, loader: ResourceLoader<T>) {
        _loaders[clazz] = loader as ResourceLoader<Resource>
    }

    inline fun <reified T : Resource> loadResource(
        params: Map<String, Any>,
        identifier: String? = null,
        cacheResource: Boolean = false
    ): T {
        if (cacheResource) {
            if (identifier == null) {
                throw IllegalArgumentException("Identifier must be provided when caching resource")
            }
            val key = T::class to identifier
            val cached = _cache[key] as T?

            if (cached != null) {
                return cached
            }
        }

        val loader = _loaders[T::class] ?: throw IllegalArgumentException("No loader registered for type ${T::class}")
        val resource = loader.load(params)

        if (cacheResource) {
            if (identifier == null) {
                throw IllegalArgumentException("Identifier must be provided when caching resource")
            }

            val key = T::class to identifier

            _cache[key] = resource
        }

        return resource as T
    }
}