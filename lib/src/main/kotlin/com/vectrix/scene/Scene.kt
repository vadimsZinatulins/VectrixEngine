package com.vectrix.scene

import com.vectrix.entity.EntityManager

abstract class Scene (
    val persistentEntityManager: EntityManager = EntityManager()
) {
    val entityManager: EntityManager = EntityManager()

    open fun onEnter() {}
    open fun onExit() {}
}