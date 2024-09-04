package com.vectrix.entity

abstract class Component {
    private var _entity: Entity? = null

    val entity: Entity
        get() = _entity ?: throw IllegalStateException("Component is not attached to an entity")

    internal fun attachEntity(entity: Entity) {
        _entity = entity
    }

    open fun update(deltaTime: Double) {}
}