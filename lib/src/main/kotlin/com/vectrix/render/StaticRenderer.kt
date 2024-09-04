package com.vectrix.render

import com.vectrix.component.CameraComponent
import com.vectrix.component.TransformComponent
import com.vectrix.entity.Entity
import com.vectrix.math.Matrix4
import com.vectrix.resource.resources.ModelRes
import com.vectrix.resource.resources.TextureRes
import org.lwjgl.opengl.GL13.*
import org.lwjgl.opengl.GL30.glBindVertexArray

data class StaticRenderRequest(
    val model: ModelRes,
    val transform: TransformComponent
)

typealias StaticRenderQueue = MutableList<StaticRenderRequest>
typealias StaticRenderMap = MutableMap<TextureRes, StaticRenderQueue>

class StaticRenderer : IRenderer {
    private val shader = StaticShader()

    private val staticRenderEntities: StaticRenderMap = mutableMapOf()

    public var camera: Entity? = null
        set(value) = shader.use {
            value?.let { entity ->
                entity.getComponent<CameraComponent>()?.projection?.let { projection ->
                    shader.loadProjectionMatrix(projection)
                }
            }
            field = value
        }

    override fun process(vararg args: Any) {
        val textureRes = args[0] as TextureRes
        val request = args[1] as StaticRenderRequest

        val entityList = staticRenderEntities[textureRes] ?: mutableListOf()
        staticRenderEntities[textureRes] = entityList.apply { add(request) }
    }

    override fun render() = shader.use {
        val viewMatrix = camera?.let { cam ->
            cam.getComponent<CameraComponent>()!!.genViewMatrix(cam.getComponent<TransformComponent>()!!)
        } ?: Matrix4.identity()

        shader.loadViewMatrix(viewMatrix)

        staticRenderEntities.forEach { (textureRes, requestList) ->
            glActiveTexture(GL_TEXTURE0)
            glBindTexture(GL_TEXTURE_2D, textureRes.id)

            requestList.forEach { request ->
                glBindVertexArray(request.model.vaoId)
                shader.loadTransformationMatrix(request.transform.transformation)

                glDrawElements(GL_TRIANGLES, request.model.vertexCount, GL_UNSIGNED_INT, 0)
            }
        }

        staticRenderEntities.clear()
    }
}