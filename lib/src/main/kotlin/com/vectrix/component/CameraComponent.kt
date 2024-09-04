package com.vectrix.component

import com.vectrix.entity.Component
import com.vectrix.math.Matrix4
import com.vectrix.math.Vector3

class CameraComponent(
    var fov: Float = 70f,
    var near: Float = 0.1f,
    var far: Float = 1000f,
    var aspectRatio: Float = 800f / 600f
) : Component() {
    val projection: Matrix4
        get() = Matrix4.perspectiveProjection(fov, near, far, aspectRatio)

    fun genViewMatrix(transform: TransformComponent): Matrix4 {
        var viewMatrix = Matrix4.identity()

        viewMatrix = viewMatrix.rotateX(Math.toRadians(transform.rotation.x.toDouble()).toFloat())
        viewMatrix = viewMatrix.rotateY(Math.toRadians(transform.rotation.y.toDouble()).toFloat())
        viewMatrix = viewMatrix.rotateZ(Math.toRadians(transform.rotation.z.toDouble()).toFloat())

        viewMatrix = viewMatrix.translate(transform.position.negate())

        return viewMatrix
    }
}