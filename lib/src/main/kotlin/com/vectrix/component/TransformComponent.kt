package com.vectrix.component

import com.vectrix.entity.Component
import com.vectrix.math.Matrix4
import com.vectrix.math.Vector3

class TransformComponent(
    val position: Vector3 = Vector3(),
    val rotation: Vector3 = Vector3(),
    val scale: Float = 1f
) : Component() {
    val transformation: Matrix4
        get() {
            var matrix = Matrix4.identity()

            matrix = matrix.translate(position)
            matrix = matrix.rotateX(rotation.x)
            matrix = matrix.rotateY(rotation.y)
            matrix = matrix.rotateZ(rotation.z)
            matrix = matrix.scale(scale)

            return matrix
        }
}