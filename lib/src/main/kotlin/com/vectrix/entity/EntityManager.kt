package com.vectrix.entity

class EntityManager {
    private val entities: MutableList<Entity> = mutableListOf()

    fun newEntity(): Entity {
        val entity = Entity()
        entities.add(entity)
        return entity
    }

    fun deleteEntity(entity: Entity) {
        entities.remove(entity)
    }

    fun update(deltaTime: Double) {
        entities.forEach { entity ->
            entity.components.forEach { component ->
                component.update(deltaTime)
            }
        }
    }
}