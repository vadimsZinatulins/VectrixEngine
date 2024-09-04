package com.vectrix.component

import com.vectrix.core.Application
import com.vectrix.entity.Component
import com.vectrix.render.StaticRenderRequest
import com.vectrix.render.StaticRenderer
import com.vectrix.resource.resources.ModelRes
import com.vectrix.resource.resources.TextureRes

class StaticRendererComponent(
    val modelRes: ModelRes,
    val textureRes: TextureRes,
    val transform: TransformComponent
) : Component() {
    override fun update(deltaTime: Double) {
        Application.getRenderer<StaticRenderer>()?.process(textureRes, StaticRenderRequest(modelRes, transform))
    }
}
