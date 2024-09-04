package com.vectrix.resource.loaders

import com.vectrix.math.Vector3
import com.vectrix.resource.ResourceLoader
import com.vectrix.resource.resources.ModelRes

private fun takeLastN(input: String, count: Int) = input.split(" ").takeLast(count).map { it.toFloat() }

class ModelLoader : ResourceLoader<ModelRes> {
    override fun load(params: Map<String, Any>): ModelRes {
        val name = params[PARAM_MODEL_NAME] as String? ?: throw IllegalArgumentException("Model path not provided")

        val content = javaClass.getResource("/models/$name.obj")?.readText()
            ?: throw IllegalArgumentException("Model not found")

        val lines = content.split("\n")

        val vertexStartLine = lines.indexOfFirst { it.startsWith("v ") }
        val vertexEndLine = lines.indexOfLast { it.startsWith("v ") }
        val vertices = mutableListOf<Vector3>()

        (vertexStartLine until vertexEndLine + 1).forEach {
            val values = takeLastN(lines[it], 3)
            val vertex = Vector3(values[0], values[1], values[2])

            vertices.add(vertex)
        }

        val textureStartLine = lines.indexOfFirst { it.startsWith("vt ") }
        val textureEndLine = lines.indexOfLast { it.startsWith("vt ") }
        val textures = mutableListOf<Vector3>()

        (textureStartLine until textureEndLine + 1).forEach {
            val values = takeLastN(lines[it], 2)
            val texture = Vector3(values[0], values[1], 0f)

            textures.add(texture)
        }

        val normalStartLine = lines.indexOfFirst { it.startsWith("vn ") }
        val normalEndLine = lines.indexOfLast { it.startsWith("vn ") }
        val normals = mutableListOf<Vector3>()

        (normalStartLine until normalEndLine + 1).forEach {
            val values = takeLastN(lines[it], 3)
            val normal = Vector3(values[0], values[1], values[2])

            normals.add(normal)
        }

        val textureArray = FloatArray(vertices.size * 2)
        val normalsArray = FloatArray(vertices.size * 3)

        val faceStartLine = lines.indexOfFirst { it.startsWith("f ") }
        val faceEndLine = lines.indexOfLast { it.startsWith("f ") }
        val indices = mutableListOf<Int>()

        (faceStartLine until faceEndLine + 1).forEach {
            val faces = lines[it].split(" ").drop(1).map { face -> face.split("/").map(String::trim) }
            faces.forEach { face ->
                val vertexIndex = face[0].toInt() - 1
                val textureIndex = face[1].toInt() - 1
                val normalIndex = face[2].toInt() - 1

                indices.add(vertexIndex)

                val texture = textures[textureIndex]
                textureArray[vertexIndex * 2 + 0] = texture.x
                textureArray[vertexIndex * 2 + 1] = 1f - texture.y

                val normal = normals[normalIndex]
                normalsArray[vertexIndex * 3 + 0] = normal.x
                normalsArray[vertexIndex * 3 + 1] = normal.y
                normalsArray[vertexIndex * 3 + 2] = normal.z
            }
        }

        val verticesArray = FloatArray(vertices.size * 3)

        (0 until vertices.size).forEach {
            val vertex = vertices[it]
            verticesArray[it * 3 + 0] = vertex.x
            verticesArray[it * 3 + 1] = vertex.y
            verticesArray[it * 3 + 2] = vertex.z
        }

        return ModelRes(verticesArray, textureArray, normalsArray, indices.toIntArray())
    }

    companion object {
        const val PARAM_MODEL_NAME = "modelName"
    }
}