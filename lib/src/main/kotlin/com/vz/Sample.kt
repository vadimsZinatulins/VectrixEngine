package com.vz

import com.vectrix.component.CameraComponent
import com.vectrix.component.StaticRendererComponent
import com.vectrix.component.TransformComponent
import com.vectrix.core.Application
import com.vectrix.math.Vector3
import com.vectrix.render.StaticRenderer
import com.vectrix.resource.ResourceManager
import com.vectrix.resource.loaders.ModelLoader
import com.vectrix.resource.loaders.ShaderLoader
import com.vectrix.resource.loaders.TextureLoader
import com.vectrix.resource.resources.ModelRes
import com.vectrix.resource.resources.ShaderRes
import com.vectrix.resource.resources.TextureRes
import com.vectrix.scene.Scene
import com.vectrix.scene.SceneManager

class MainScene : Scene() {
    override fun onEnter() {
        entityManager.newEntity().apply {
            val transform = TransformComponent(
                position = Vector3(0.0f, 2.0f, 25f),
                rotation = Vector3(0.0f, 90.0f, 0.0f),
            )

            val camera = CameraComponent()

            addComponent(transform)
            addComponent(camera)

            Application.getRenderer<StaticRenderer>().camera = this
        }

        entityManager.newEntity().apply {
            val transform = TransformComponent(
                position = Vector3(0.0f, -2.5f, -15f)
            )

            val model = ResourceManager.loadResource<ModelRes>(mapOf(
                ModelLoader.PARAM_MODEL_NAME to "stall"
            ), "stall", cacheResource = true)

            val texture = ResourceManager.loadResource<TextureRes>(mapOf(
                TextureLoader.PARAM_NAME to "stall.png"
            ), "stall", cacheResource = true)

            val renderer = StaticRendererComponent(model, texture, transform)

            addComponent(transform)
            addComponent(renderer)
        }
    }

    override fun onExit() {
    }
}

class SampleGame : Application() {
    init {
        setResolution(1280, 720)
        setTitle("Sample Game")
    }

    override fun setup() {
        setClearColor(0.0f, 0.0f, 0.5f, 1.0f)

        ResourceManager.registerLoader(ShaderRes::class, ShaderLoader())
        ResourceManager.registerLoader(ModelRes::class, ModelLoader())
        ResourceManager.registerLoader(TextureRes::class, TextureLoader())

        registerRenderer(StaticRenderer())

        SceneManager.pushScene(MainScene())
    }

    override fun cleanup() {
    }
}

fun main() {
    SampleGame().run()
}