package com.vectrix.resource.resources

import com.vectrix.resource.Resource
import org.lwjgl.opengl.GL11.glDeleteTextures

class TextureRes(
    val id: Int,
    val width: Int,
    val height: Int
) : Resource {
    override fun dispose() {
        glDeleteTextures(id)
    }
}