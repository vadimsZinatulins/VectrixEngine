package com.vectrix.render

import com.vectrix.math.Matrix4

class StaticShader : ShaderProgram(
    "staticShader.vert",
    "staticShader.frag"
) {
    private val transformationMatrixLocation = getUniformLocation("transformationMatrix")
    private val projectionMatrixLocation = getUniformLocation("projectionMatrix")
    private val viewMatrixLocation = getUniformLocation("viewMatrix")

    fun loadTransformationMatrix(matrix: Matrix4) {
        loadMatrix(transformationMatrixLocation, matrix)
    }

    fun loadProjectionMatrix(matrix: Matrix4) {
        loadMatrix(projectionMatrixLocation, matrix)
    }

    fun loadViewMatrix(matrix: Matrix4) {
        loadMatrix(viewMatrixLocation, matrix)
    }
}