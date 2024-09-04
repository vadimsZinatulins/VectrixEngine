package com.vectrix.render

import com.vectrix.math.Matrix4
import com.vectrix.math.Vector3
import com.vectrix.resource.ResourceManager
import com.vectrix.resource.loaders.ShaderLoader
import com.vectrix.resource.resources.ShaderRes
import org.lwjgl.opengl.GL20.*

abstract class ShaderProgram(
    vertexShaderPath: String,
    fragmentShaderPath: String
) {
    private val programId: Int = glCreateProgram().also {
        val shaderRes = ResourceManager.loadResource<ShaderRes>(
            mapOf(
                ShaderLoader.PARAM_VERTEX_SHADER_PATH to vertexShaderPath,
                ShaderLoader.PARAM_FRAGMENT_SHADER_PATH to fragmentShaderPath
            )
        )

        glAttachShader(it, shaderRes.vertexShaderId)
        glAttachShader(it, shaderRes.fragmentShaderId)

        glLinkProgram(it)
        glValidateProgram(it)

        shaderRes.dispose()
    }

    fun use(action: () -> Unit) {
        glUseProgram(programId)

        action()

        glUseProgram(0)
    }

    fun cleanup() {
        glDeleteProgram(programId)
    }

    protected fun getUniformLocation(name: String) = glGetUniformLocation(programId, name)

    protected fun loadFloat(location: Int, value: Float) = glUniform1f(location, value)
    protected fun loadVector(location: Int, value: Vector3) = glUniform3f(location, value.x, value.y, value.z)
    protected fun loadBoolean(location: Int, value: Boolean) = glUniform1i(location, if (value) 1 else 0)
    protected fun loadMatrix(location: Int, value: Matrix4) = glUniformMatrix4fv(location, true, value.asFloatArray)
}