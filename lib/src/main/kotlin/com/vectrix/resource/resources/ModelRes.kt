package com.vectrix.resource.resources

import com.vectrix.resource.Resource
import org.lwjgl.BufferUtils
import org.lwjgl.opengl.GL30.*

class ModelRes(
    vertices: FloatArray,
    textureCoords: FloatArray? = null,
    normals: FloatArray? = null,
    indices: IntArray? = null
) : Resource {

    val vaoId: Int = glGenVertexArrays()
    val vbos = mutableListOf<Int>()

    val vertexCount = indices?.size ?: (vertices.size / 3)

    init {
        use {
            var index = 0
            bindVertexAttribute(index++, 3, vertices)
            textureCoords?.let { bindVertexAttribute(index++, 2, it) }
            normals?.let { bindVertexAttribute(index++, 3, it) }
            indices?.let { bindIndices(it) }
        }
    }

    fun use(action: (numVertices: Int) -> Unit) {
        glBindVertexArray(vaoId)
        action(vertexCount)
        glBindVertexArray(0)
    }

    override fun dispose() {
        vbos.forEach(::glDeleteBuffers)

        glDeleteVertexArrays(vaoId)
    }

    private fun bindVertexAttribute(index: Int, size: Int, data: FloatArray) {
        val buffer = createFloatBuffer(data)

        glGenBuffers().also {
            vbos.add(it)

            glBindBuffer(GL_ARRAY_BUFFER, it)

            glBufferData(GL_ARRAY_BUFFER, buffer, GL_STATIC_DRAW)
            glVertexAttribPointer(index, size, GL_FLOAT, false, 0, 0)
            glEnableVertexAttribArray(index)
        }
    }

    private fun bindIndices(indices: IntArray) {
        val buffer = createIntBuffer(indices)

        glGenBuffers().also {
            vbos.add(it)

            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, it)
            glBufferData(GL_ELEMENT_ARRAY_BUFFER, buffer, GL_STATIC_DRAW)
        }
    }

    private fun createFloatBuffer(data: FloatArray) = BufferUtils.createFloatBuffer(data.size).apply {
        put(data)
        flip()
    }

    private fun createIntBuffer(data: IntArray) = BufferUtils.createIntBuffer(data.size).apply {
        put(data)
        flip()
    }
}