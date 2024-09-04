package com.vectrix.core

import com.vectrix.render.IRenderer
import com.vectrix.scene.SceneManager
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.opengl.GL.createCapabilities
import org.lwjgl.opengl.GL11.*
import org.lwjgl.system.MemoryUtil.NULL
import java.util.*
import kotlin.reflect.typeOf

abstract class Application {
    private val windowManager = WindowManager()

    fun run() {
        init()
        loop()
        close()
    }

    protected open fun setup() {}
    protected open fun cleanup() {}

    protected val setResolution get() = windowManager::setResolution
    protected val setTitle get() = windowManager::setTitle

    private fun init() {
        if (!glfwInit()) {
            throw IllegalStateException("Failed to initialize GLFW")
        }

        windowManager.open()

        setup()
    }

    private fun loop() {
        val targetFps = 60.0
        val targetFrameTime = 1.0 / targetFps
        var lastFrame = glfwGetTime()

        while (!glfwWindowShouldClose(windowManager.handle)) {
            val startFrame = glfwGetTime()
            val deltaTime = startFrame - lastFrame
            lastFrame = startFrame

            glfwPollEvents()

            SceneManager.currentScene()?.persistentEntityManager?.update(deltaTime)
            SceneManager.currentScene()?.entityManager?.update(deltaTime)

            TaskManager.update()

            Renderer.render()

            glfwSwapBuffers(windowManager.handle)

            val duration = glfwGetTime() - startFrame
            if (duration < targetFrameTime) {
                Thread.sleep(((targetFrameTime - duration) * 1000).toLong())
            }
        }
    }

    private fun close() {
        windowManager.close()

        cleanup()

        glfwTerminate()
    }

    private class WindowManager {
        private var width = 1280
        private var height = 780

        private var title = "Basic Engine"

        private var window = NULL

        val handle get() = window

        fun setResolution(width: Int, height: Int) {
            this.width = width
            this.height = height
        }

        fun setTitle(title: String) {
            this.title = title
        }

        fun open() {
            glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3)
            glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3)
            glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE)

            window = glfwCreateWindow(width, height, title, NULL, NULL)

            if (window == NULL) {
                throw IllegalStateException("Failed to create GLFW window")
            }

            glfwMakeContextCurrent(window)
            createCapabilities()

            glfwSetFramebufferSizeCallback(window) { _, width, height ->
                glViewport(0, 0, width, height)
            }
        }

        fun close() {
            if (window != NULL) {
                glfwDestroyWindow(window)

                window = NULL
            }
        }
    }

    private object TaskManager {
        private val tasks: Queue<() -> Unit> = LinkedList()

        fun postTask(task: () -> Unit) {
            tasks.add(task)
        }

        fun update() {
            while (tasks.isNotEmpty()) {
                tasks.poll().invoke()
            }
        }
    }

    private object Renderer {
        private val renderers: MutableList<IRenderer> = mutableListOf()

        fun setClearColor(r: Float, g: Float, b: Float, a: Float) = glClearColor(r, g, b, a)
        fun registerRenderer(renderer: IRenderer) = renderers.add(renderer)
        fun <T> getRenderer(clazz: Class<T>) = renderers.find { it::class.java == clazz }

        fun render() {
            glEnable(GL_DEPTH_TEST)
            glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT)

            renderers.forEach(IRenderer::render)
        }
    }

    companion object {
        fun postTask(task: () -> Unit) = TaskManager.postTask(task)

        fun registerRenderer(renderer: IRenderer) = Renderer.registerRenderer(renderer)
        inline fun <reified T : IRenderer> getRenderer(): T = getRenderer(T::class.java) as T
        fun <T> getRenderer(clazz: Class<T>) = Renderer.getRenderer(clazz)
        fun setClearColor(r: Float, g: Float, b: Float, a: Float) = Renderer.setClearColor(r, g, b, a)
    }
}