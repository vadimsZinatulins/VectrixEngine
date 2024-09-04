package com.vectrix.entity

data class Entity(
    val components: MutableList<Component> = mutableListOf()
) {
    inline fun <reified T : Component> getComponent(): T? {
        return components.find { it is T } as T?
    }

    inline fun <reified T : Component> hasComponent(): Boolean {
        return components.any { it is T }
    }

    fun <T : Component> addComponent(component: T) {
        component.attachEntity(this)
        components.add(component)
    }

    inline fun <reified T : Component> removeComponent() {
        components.removeIf { it is T }
    }
}