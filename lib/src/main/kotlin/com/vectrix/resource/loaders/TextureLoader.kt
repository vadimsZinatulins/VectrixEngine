package com.vectrix.resource.loaders

import com.vectrix.resource.ResourceLoader
import com.vectrix.resource.resources.TextureRes
import org.lwjgl.opengl.GL11.*
import org.lwjgl.opengl.GL30.glGenerateMipmap
import org.lwjgl.stb.STBImage.*
import org.lwjgl.system.MemoryStack
import java.nio.ByteBuffer

class TextureLoader : ResourceLoader<TextureRes> {
    override fun load(params: Map<String, Any>): TextureRes = MemoryStack.stackPush().use { stack ->
        val path = params[PARAM_NAME] as String? ?: throw IllegalArgumentException("Texture path not specified")

        val w = stack.ints(0)
        val h = stack.ints(0)
        val c = stack.ints(0)

        val content = javaClass.getResource("/textures/$path")?.readBytes()
            ?: throw IllegalArgumentException("Texture not found: $path")

        val buffer = stack.malloc(content.size).put(content).flip() as ByteBuffer

        stbi_load_from_memory(buffer, w, h, c, 0)?.let { buffer ->
            val width = w.get()
            val height = h.get()
            val channels = c.get()

            val textureId = glGenTextures()

            glBindTexture(GL_TEXTURE_2D, textureId)

            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, params?.get(PARAM_WRAP_S) as? Int ?: GL_REPEAT)
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, params?.get(PARAM_WRAP_T) as? Int ?: GL_REPEAT)
            glTexParameteri(
                GL_TEXTURE_2D,
                GL_TEXTURE_MIN_FILTER,
                params?.get(PARAM_MIN_FILTER) as? Int ?: GL_LINEAR_MIPMAP_LINEAR
            )
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, params?.get(PARAM_MAG_FILTER) as? Int ?: GL_LINEAR)

            if (channels == 4) {
                glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer)
            } else {
                glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0, GL_RGB, GL_UNSIGNED_BYTE, buffer)
            }

            glGenerateMipmap(GL_TEXTURE_2D)

            stbi_image_free(buffer)

            TextureRes(textureId, width, height)
        } ?: throw RuntimeException("Failed to load texture $path. ${stbi_failure_reason()}, ${nstbi_failure_reason()}")
    }

    companion object {
        const val PARAM_NAME = "path"
        const val PARAM_WRAP_S = "wrap_s"
        const val PARAM_WRAP_T = "wrap_t"
        const val PARAM_MIN_FILTER = "min_filter"
        const val PARAM_MAG_FILTER = "mag_filter"
    }
}