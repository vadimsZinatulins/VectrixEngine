package com.vectrix.scene

import com.vectrix.core.Application
import java.util.*

object SceneManager {
    private val scenes: Stack<Scene> = Stack()

    fun pushScene(scene: Scene) {
        Application.postTask {
            scenes.push(scene.apply { onEnter() })
        }
    }

    fun popScene() {
        Application.postTask { scenes.pop().onExit() }
    }

    fun swapScene(scene: Scene) {
        Application.postTask {
            scenes.pop().onExit()
            scenes.push(scene.apply { onEnter() })
        }
    }

    fun currentScene(): Scene? {
        return scenes.lastOrNull()
    }
}