package com.vectrix.resource.resources

import com.vectrix.resource.Resource
import org.lwjgl.opengl.GL20.glDeleteShader

class ShaderRes(
    val vertexShaderId: Int,
    val fragmentShaderId: Int,
): Resource {
    override fun dispose() {
        glDeleteShader(vertexShaderId)
        glDeleteShader(fragmentShaderId)
    }
}