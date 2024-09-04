package com.vectrix.math

import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

class Matrix4(
    n00: Float = 0f, n01: Float = 0f, n02: Float = 0f, n03: Float = 0f,
    n10: Float = 0f, n11: Float = 0f, n12: Float = 0f, n13: Float = 0f,
    n20: Float = 0f, n21: Float = 0f, n22: Float = 0f, n23: Float = 0f,
    n30: Float = 0f, n31: Float = 0f, n32: Float = 0f, n33: Float = 0f
) {

    private val _values = floatArrayOf(
        n00, n01, n02, n03,
        n10, n11, n12, n13,
        n20, n21, n22, n23,
        n30, n31, n32, n33
    )

    val asFloatArray
        get() = _values

    var row0
        get() = Vector4(_values[0], _values[1], _values[2], _values[3])
        set(vector) {
            _values[0] = vector.x
            _values[1] = vector.y
            _values[2] = vector.z
            _values[3] = vector.w
        }

    var row1
        get() = Vector4(_values[4], _values[5], _values[6], _values[7])
        set(vector) {
            _values[4] = vector.x
            _values[5] = vector.y
            _values[6] = vector.z
            _values[7] = vector.w
        }

    var row2
        get() = Vector4(_values[8], _values[9], _values[10], _values[11])
        set(vector) {
            _values[8] = vector.x
            _values[9] = vector.y
            _values[10] = vector.z
            _values[11] = vector.w
        }

    var row3
        get() = Vector4(_values[12], _values[13], _values[14], _values[15])
        set(vector) {
            _values[12] = vector.x
            _values[13] = vector.y
            _values[14] = vector.z
            _values[15] = vector.w
        }

    var column0
        get() = Vector4(_values[0], _values[4], _values[8], _values[12])
        set(vector) {
            _values[0] = vector.x
            _values[4] = vector.y
            _values[8] = vector.z
            _values[12] = vector.w
        }

    var column1
        get() = Vector4(_values[1], _values[5], _values[9], _values[13])
        set(vector) {
            _values[1] = vector.x
            _values[5] = vector.y
            _values[9] = vector.z
            _values[13] = vector.w
        }

    var column2
        get() = Vector4(_values[2], _values[6], _values[10], _values[14])
        set(vector) {
            _values[2] = vector.x
            _values[6] = vector.y
            _values[10] = vector.z
            _values[14] = vector.w
        }

    var column3
        get() = Vector4(_values[3], _values[7], _values[11], _values[15])
        set(vector) {
            _values[3] = vector.x
            _values[7] = vector.y
            _values[11] = vector.z
            _values[15] = vector.w
        }

    operator fun get(row: Int, column: Int) = _values[row * 4 + column]
    operator fun set(row: Int, column: Int, value: Float) {
        _values[row * 4 + column] = value
    }

    operator fun plus(matrix: Matrix4) = Matrix4(
        _values[0] + matrix._values[0],
        _values[1] + matrix._values[1],
        _values[2] + matrix._values[2],
        _values[3] + matrix._values[3],
        _values[4] + matrix._values[4],
        _values[5] + matrix._values[5],
        _values[6] + matrix._values[6],
        _values[7] + matrix._values[7],
        _values[8] + matrix._values[8],
        _values[9] + matrix._values[9],
        _values[10] + matrix._values[10],
        _values[11] + matrix._values[11],
        _values[12] + matrix._values[12],
        _values[13] + matrix._values[13],
        _values[14] + matrix._values[14],
        _values[15] + matrix._values[15]
    )

    operator fun minus(matrix: Matrix4) = Matrix4(
        _values[0] - matrix._values[0],
        _values[1] - matrix._values[1],
        _values[2] - matrix._values[2],
        _values[3] - matrix._values[3],
        _values[4] - matrix._values[4],
        _values[5] - matrix._values[5],
        _values[6] - matrix._values[6],
        _values[7] - matrix._values[7],
        _values[8] - matrix._values[8],
        _values[9] - matrix._values[9],
        _values[10] - matrix._values[10],
        _values[11] - matrix._values[11],
        _values[12] - matrix._values[12],
        _values[13] - matrix._values[13],
        _values[14] - matrix._values[14],
        _values[15] - matrix._values[15]
    )

    operator fun times(scalar: Float) = Matrix4(
        _values[0] * scalar,
        _values[1] * scalar,
        _values[2] * scalar,
        _values[3] * scalar,
        _values[4] * scalar,
        _values[5] * scalar,
        _values[6] * scalar,
        _values[7] * scalar,
        _values[8] * scalar,
        _values[9] * scalar,
        _values[10] * scalar,
        _values[11] * scalar,
        _values[12] * scalar,
        _values[13] * scalar,
        _values[14] * scalar,
        _values[15] * scalar
    )

    operator fun times(vector: Vector4) = Vector4(
        _values[0] * vector.x + _values[1] * vector.y + _values[2] * vector.z + _values[3] * vector.w,
        _values[4] * vector.x + _values[5] * vector.y + _values[6] * vector.z + _values[7] * vector.w,
        _values[8] * vector.x + _values[9] * vector.y + _values[10] * vector.z + _values[11] * vector.w,
        _values[12] * vector.x + _values[13] * vector.y + _values[14] * vector.z + _values[15] * vector.w
    )

    operator fun times(matrix: Matrix4) = Matrix4(
        _values[0] * matrix._values[0] + _values[1] * matrix._values[4] + _values[2] * matrix._values[8] + _values[3] * matrix._values[12],
        _values[0] * matrix._values[1] + _values[1] * matrix._values[5] + _values[2] * matrix._values[9] + _values[3] * matrix._values[13],
        _values[0] * matrix._values[2] + _values[1] * matrix._values[6] + _values[2] * matrix._values[10] + _values[3] * matrix._values[14],
        _values[0] * matrix._values[3] + _values[1] * matrix._values[7] + _values[2] * matrix._values[11] + _values[3] * matrix._values[15],

        _values[4] * matrix._values[0] + _values[5] * matrix._values[4] + _values[6] * matrix._values[8] + _values[7] * matrix._values[12],
        _values[4] * matrix._values[1] + _values[5] * matrix._values[5] + _values[6] * matrix._values[9] + _values[7] * matrix._values[13],
        _values[4] * matrix._values[2] + _values[5] * matrix._values[6] + _values[6] * matrix._values[10] + _values[7] * matrix._values[14],
        _values[4] * matrix._values[3] + _values[5] * matrix._values[7] + _values[6] * matrix._values[11] + _values[7] * matrix._values[15],

        _values[8] * matrix._values[0] + _values[9] * matrix._values[4] + _values[10] * matrix._values[8] + _values[11] * matrix._values[12],
        _values[8] * matrix._values[1] + _values[9] * matrix._values[5] + _values[10] * matrix._values[9] + _values[11] * matrix._values[13],
        _values[8] * matrix._values[2] + _values[9] * matrix._values[6] + _values[10] * matrix._values[10] + _values[11] * matrix._values[14],
        _values[8] * matrix._values[3] + _values[9] * matrix._values[7] + _values[10] * matrix._values[11] + _values[11] * matrix._values[15],

        _values[12] * matrix._values[0] + _values[13] * matrix._values[4] + _values[14] * matrix._values[8] + _values[15] * matrix._values[12],
        _values[12] * matrix._values[1] + _values[13] * matrix._values[5] + _values[14] * matrix._values[9] + _values[15] * matrix._values[13],
        _values[12] * matrix._values[2] + _values[13] * matrix._values[6] + _values[14] * matrix._values[10] + _values[15] * matrix._values[14],
        _values[12] * matrix._values[3] + _values[13] * matrix._values[7] + _values[14] * matrix._values[11] + _values[15] * matrix._values[15]
    )

    operator fun div(scalar: Float) = Matrix4(
        _values[0] / scalar,
        _values[1] / scalar,
        _values[2] / scalar,
        _values[3] / scalar,
        _values[4] / scalar,
        _values[5] / scalar,
        _values[6] / scalar,
        _values[7] / scalar,
        _values[8] / scalar,
        _values[9] / scalar,
        _values[10] / scalar,
        _values[11] / scalar,
        _values[12] / scalar,
        _values[13] / scalar,
        _values[14] / scalar,
        _values[15] / scalar
    )

    fun translate(vector: Vector3) = Matrix4(
        _values[0], _values[1], _values[2], _values[3] + vector.x,
        _values[4], _values[5], _values[6], _values[7] + vector.y,
        _values[8], _values[9], _values[10], _values[11] + vector.z,
        _values[12], _values[13], _values[14], _values[15]
    )

    fun translate(vector: Vector4) = Matrix4(
        _values[0], _values[1], _values[2], _values[3] + vector.x,
        _values[4], _values[5], _values[6], _values[7] + vector.y,
        _values[8], _values[9], _values[10], _values[11] + vector.z,
        _values[12], _values[13], _values[14], _values[15] + vector.w
    )

    fun rotateX(angle: Float) = this * makeRotationX(angle)
    fun rotateY(angle: Float) = this * makeRotationY(angle)
    fun rotateZ(angle: Float) = this * makeRotationZ(angle)

    fun scale(scale: Float) = this * makeScale(scale)

    fun inverse(): Matrix4 {
        val m = _values
        val inv = FloatArray(16)
        val det: Float

        inv[0] = m[5] * m[10] * m[15] - m[5] * m[11] * m[14] - m[9] * m[6] * m[15] + m[9] * m[7] * m[14] + m[13] * m[6] * m[11] - m[13] * m[7] * m[10]
        inv[4] = -m[4] * m[10] * m[15] + m[4] * m[11] * m[14] + m[8] * m[6] * m[15] - m[8] * m[7] * m[14] - m[12] * m[6] * m[11] + m[12] * m[7] * m[10]
        inv[8] = m[4] * m[9] * m[15] - m[4] * m[11] * m[13] - m[8] * m[5] * m[15] + m[8] * m[7] * m[13] + m[12] * m[5] * m[11] - m[12] * m[7] * m[9]
        inv[12] = -m[4] * m[9] * m[14] + m[4] * m[10] * m[13] + m[8] * m[5] * m[14] - m[8] * m[6] * m[13] - m[12] * m[5] * m[10] + m[12] * m[6] * m[9]
        inv[1] = -m[1] * m[10] * m[15] + m[1] * m[11] * m[14] + m[9] * m[2] * m[15] - m[9] * m[3] * m[14] - m[13] * m[2] * m[11] + m[13] * m[3] * m[10]
        inv[5] = m[0] * m[10] * m[15] - m[0] * m[11] * m[14] - m[8] * m[2] * m[15] + m[8] * m[3] * m[14] + m[12] * m[2] * m[11] - m[12] * m[3] * m[10]
        inv[9] = -m[0] * m[9] * m[15] + m[0] * m[11] * m[13] + m[8] * m[1] * m[15] - m[8] * m[3] * m[13] - m[12] * m[1] * m[11] + m[12] * m[3] * m[9]
        inv[13] = m[0] * m[9] * m[14] - m[0] * m[10] * m[13] - m[8] * m[1] * m[14] + m[8] * m[2] * m[13] + m[12] * m[1] * m[10] - m[12] * m[2] * m[9]
        inv[2] = m[1] * m[6] * m[15] - m[1] * m[7] * m[14] - m[5] * m[2] * m[15] + m[5] * m[3] * m[14] + m[13] * m[2] * m[7] - m[13] * m[3] * m[6]
        inv[6] = -m[0] * m[6] * m[15] + m[0] * m[7] * m[14] + m[4] * m[2] * m[15] - m[4] * m[3] * m[14] - m[12] * m[2] * m[7] + m[12] * m[3] * m[6]
        inv[10] = m[0] * m[5] * m[15] - m[0] * m[7] * m[13] - m[4] * m[1] * m[15] + m[4] * m[3] * m[13] + m[12] * m[1] * m[7] - m[12] * m[3] * m[5]
        inv[14] = -m[0] * m[5] * m[14] + m[0] * m[6] * m[13] + m[4] * m[1] * m[14] - m[4] * m[2] * m[13] - m[12] * m[1] * m[6] + m[12] * m[2] * m[5]
        inv[3] = -m[1] * m[6] * m[11] + m[1] * m[7] * m[10] + m[5] * m[2] * m[11] - m[5] * m[3] * m[10] - m[9] * m[2] * m[7] + m[9] * m[3] * m[6]
        inv[7] = m[0] * m[6] * m[11] - m[0] * m[7] * m[10] - m[4] * m[2] * m[11] + m[4] * m[3] * m[10] + m[8] * m[2] * m[7] - m[8] * m[3] * m[6]
        inv[11] = -m[0] * m[5] * m[11] + m[0] * m[7] * m[9] + m[4] * m[1] * m[11] - m[4] * m[3] * m[9] - m[8] * m[1] * m[7] + m[8] * m[3] * m[5]
        inv[15] = m[0] * m[5] * m[10] - m[0] * m[6] * m[9] - m[4] * m[1] * m[10] + m[4] * m[2] * m[9] + m[8] * m[1] * m[6] - m[8] * m[2] * m[5]

        det = m[0] * inv[0] + m[1] * inv[4] + m[2] * inv[8] + m[3] * inv[12]

        if (det == 0f) throw ArithmeticException("Matrix is not invertible")

        val invDet = 1.0f / det
        for (i in 0..15) inv[i] *= invDet

        return Matrix4(
            inv[0], inv[1], inv[2], inv[3],
            inv[4], inv[5], inv[6], inv[7],
            inv[8], inv[9], inv[10], inv[11],
            inv[12], inv[13], inv[14], inv[15]
        )
    }

    companion object {
        fun identity() = Matrix4(n00 = 1f, n11 = 1f, n22 = 1f, n33 = 1f)

        fun makeRotationX(angle: Float): Matrix4 {
            val c = cos(angle)
            val s = sin(angle)

            return Matrix4(
                1f, 0f, 0f, 0f,
                0f, c, -s, 0f,
                0f, s, c, 0f,
                0f, 0f, 0f, 1f
            )
        }

        fun makeRotationY(angle: Float): Matrix4 {
            val c = cos(angle)
            val s = sin(angle)

            return Matrix4(
                c, 0f, s, 0f,
                0f, 1f, 0f, 0f,
                -s, 0f, c, 0f,
                0f, 0f, 0f, 1f
            )
        }

        fun makeRotationZ(angle: Float): Matrix4 {
            val c = cos(angle)
            val s = sin(angle)

            return Matrix4(
                c, -s, 0f, 0f,
                s, c, 0f, 0f,
                0f, 0f, 1f, 0f,
                0f, 0f, 0f, 1f
            )
        }

        fun makeRotation(axis: Vector3, angle: Float): Matrix4 {
            val c = cos(angle)
            val s = sin(angle)
            val d = 1f - c

            val x = axis.x * d
            val y = axis.y * d
            val z = axis.z * d

            val axay = x * axis.y
            val axaz = x * axis.z
            val ayaz = y * axis.z

            return Matrix4(
                c + x * axis.x, axay - s * axis.z, axaz + s * axis.y, 0f,
                axay + s * axis.z, c + y * axis.y, ayaz - s * axis.x, 0f,
                axaz - s * axis.y, ayaz + s * axis.x, c + z * axis.z, 0f,
                0f, 0f, 0f, 1f
            )
        }

        fun makeScale(scale: Float) = Matrix4(n00 = scale, n11 = scale, n22 = scale, n33 = 1f)

        fun perspectiveProjection(
            fov: Float,
            nearPlane: Float,
            farPlane: Float,
            aspectRatio: Float
        ): Matrix4 {
            val yScale = 1f / tan(Math.toRadians(fov.toDouble() / 2)).toFloat()
            val xScale = yScale / aspectRatio
            val frustumLength = farPlane - nearPlane

            return Matrix4(
                xScale, 0f, 0f, 0f,
                0f, yScale, 0f, 0f,
                0f, 0f, -((farPlane + nearPlane) / frustumLength), -((2 * nearPlane * farPlane) / frustumLength),
                0f, 0f, -1f, 0f
            )
        }

        fun orthogonalProject(
            left: Float,
            right: Float,
            bottom: Float,
            top: Float,
            near: Float,
            far: Float
        ): Matrix4 {
            val width = right - left
            val height = top - bottom
            val depth = far - near

            return Matrix4(
                2f / width, 0f, 0f, 0f,
                0f, 2f / height, 0f, 0f,
                0f, 0f, -2f / depth, 0f,
                -(right + left) / width, -(top + bottom) / height, -(far + near) / depth, 1f
            )
        }
    }
}
