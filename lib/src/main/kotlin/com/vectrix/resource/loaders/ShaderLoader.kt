package com.vectrix.resource.loaders

import com.vectrix.resource.ResourceLoader
import com.vectrix.resource.resources.ShaderRes
import org.lwjgl.opengl.GL20.*

class ShaderLoader : ResourceLoader<ShaderRes> {
    override fun load(params: Map<String, Any>): ShaderRes {
        val vertexShaderPath = params[PARAM_VERTEX_SHADER_PATH] as String
        val fragmentShaderPath = params[PARAM_FRAGMENT_SHADER_PATH] as String

        val vertexShaderId = loadShader(vertexShaderPath, GL_VERTEX_SHADER)
        val fragmentShaderId = loadShader(fragmentShaderPath, GL_FRAGMENT_SHADER)

        return ShaderRes(vertexShaderId, fragmentShaderId)
    }

    private fun loadShader(path: String, type: Int) = glCreateShader(type).also {
        glShaderSource(it, javaClass.getResource("/shaders/$path")?.readText().toString())
        glCompileShader(it)

        if (glGetShaderi(it, GL_COMPILE_STATUS) == GL_FALSE) {
            throw RuntimeException("Failed to compile shader $path: ${glGetShaderInfoLog(it)}")
        }
    }

    companion object {
        const val PARAM_VERTEX_SHADER_PATH = "vertexShaderPath"
        const val PARAM_FRAGMENT_SHADER_PATH = "fragmentShaderPath"
    }
}