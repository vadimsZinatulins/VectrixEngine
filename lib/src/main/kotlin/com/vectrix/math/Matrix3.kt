package com.vectrix.math

import kotlin.math.cos
import kotlin.math.sin

class Matrix3(
    n00: Float = 0f, n01: Float = 0f, n02: Float = 0f,
    n10: Float = 0f, n11: Float = 0f, n12: Float = 0f,
    n20: Float = 0f, n21: Float = 0f, n22: Float = 0f
) {
    private val _values = floatArrayOf(
        n00, n01, n02,
        n10, n11, n12,
        n20, n21, n22,
    )

    val asFloatArray
        get() = _values

    var row0
        get() = Vector3(_values[0], _values[1], _values[2])
        set(vector) {
            _values[0] = vector.x
            _values[1] = vector.y
            _values[2] = vector.z
        }

    var row1
        get() = Vector3(_values[3], _values[4], _values[5])
        set(vector) {
            _values[3] = vector.x
            _values[4] = vector.y
            _values[5] = vector.z
        }

    var row2
        get() = Vector3(_values[6], _values[7], _values[8])
        set(vector) {
            _values[6] = vector.x
            _values[7] = vector.y
            _values[8] = vector.z
        }

    var column0
        get() = Vector3(_values[0], _values[3], _values[6])
        set(vector) {
            _values[0] = vector.x
            _values[3] = vector.y
            _values[6] = vector.z
        }

    var column1
        get() = Vector3(_values[1], _values[4], _values[7])
        set(vector) {
            _values[1] = vector.x
            _values[4] = vector.y
            _values[7] = vector.z
        }

    var column2
        get() = Vector3(_values[2], _values[5], _values[8])
        set(vector) {
            _values[2] = vector.x
            _values[5] = vector.y
            _values[8] = vector.z
        }

    operator fun get(row: Int, column: Int) = _values[row * 3 + column]
    operator fun set(row: Int, column: Int, value: Float) {
        _values[row * 3 + column] = value
    }

    operator fun plus(matrix3: Matrix3) = Matrix3(
        _values[0] + matrix3._values[0], _values[1] + matrix3._values[1], _values[2] + matrix3._values[2],
        _values[3] + matrix3._values[3], _values[4] + matrix3._values[4], _values[5] + matrix3._values[5],
        _values[6] + matrix3._values[6], _values[7] + matrix3._values[7], _values[8] + matrix3._values[8]
    )

    operator fun minus(matrix3: Matrix3) = Matrix3(
        _values[0] - matrix3._values[0], _values[1] - matrix3._values[1], _values[2] - matrix3._values[2],
        _values[3] - matrix3._values[3], _values[4] - matrix3._values[4], _values[5] - matrix3._values[5],
        _values[6] - matrix3._values[6], _values[7] - matrix3._values[7], _values[8] - matrix3._values[8]
    )

    operator fun times(scalar: Float) = Matrix3(
        _values[0] * scalar, _values[1] * scalar, _values[2] * scalar,
        _values[3] * scalar, _values[4] * scalar, _values[5] * scalar,
        _values[6] * scalar, _values[7] * scalar, _values[8] * scalar
    )

    operator fun times(vector: Vector3) = Vector3(
        _values[0] * vector.x + _values[1] * vector.y + _values[2] * vector.z,
        _values[3] * vector.x + _values[4] * vector.y + _values[5] * vector.z,
        _values[6] * vector.x + _values[7] * vector.y + _values[8] * vector.z
    )

    operator fun times(matrix: Matrix3) = Matrix3(
        // First row
        _values[0] * matrix._values[0] + _values[1] * matrix._values[3] + _values[2] * matrix._values[6],
        _values[0] * matrix._values[1] + _values[1] * matrix._values[4] + _values[2] * matrix._values[7],
        _values[0] * matrix._values[2] + _values[1] * matrix._values[5] + _values[2] * matrix._values[8],

        // Second row
        _values[3] * matrix._values[0] + _values[4] * matrix._values[3] + _values[5] * matrix._values[6],
        _values[3] * matrix._values[1] + _values[4] * matrix._values[4] + _values[5] * matrix._values[7],
        _values[3] * matrix._values[2] + _values[4] * matrix._values[5] + _values[5] * matrix._values[8],

        // Third row
        _values[6] * matrix._values[0] + _values[7] * matrix._values[3] + _values[8] * matrix._values[6],
        _values[6] * matrix._values[1] + _values[7] * matrix._values[4] + _values[8] * matrix._values[7],
        _values[6] * matrix._values[2] + _values[7] * matrix._values[5] + _values[8] * matrix._values[8],
    )

    operator fun div(scalar: Float) = Matrix3(
        _values[0] / scalar, _values[1] / scalar, _values[2] / scalar,
        _values[3] / scalar, _values[4] / scalar, _values[5] / scalar,
        _values[6] / scalar, _values[7] / scalar, _values[8] / scalar
    )

    fun determinant(): Float {
        val a = column0.x
        val b = column0.y
        val c = column0.z

        val d = column1.x
        val e = column1.y
        val f = column1.z

        val g = column2.x
        val h = column2.y
        val i = column2.z

        return a * (e * i - f * h) -
            b * (d * i - f * g) +
            c * (d * h - e * g)
    }

    fun inverse(): Matrix3 {
        val det = determinant()

        val n00 = (_values[4] * _values[8] - _values[5] * _values[7]) / det
        val n01 = (_values[3] * _values[8] - _values[5] * _values[6]) / det
        val n02 = (_values[3] * _values[7] - _values[4] * _values[6]) / det

        val n10 = (_values[1] * _values[8] - _values[2] * _values[7]) / det
        val n11 = (_values[0] * _values[8] - _values[2] * _values[6]) / det
        val n12 = (_values[0] * _values[7] - _values[1] * _values[6]) / det

        val n20 = (_values[1] * _values[5] - _values[2] * _values[4]) / det
        val n21 = (_values[0] * _values[5] - _values[2] * _values[3]) / det
        val n22 = (_values[0] * _values[4] - _values[1] * _values[3]) / det

        return Matrix3(
            n00, -n10, n20,
            -n01, n11, -n21,
            n02, -n12, n22
        )
    }

    companion object {
        fun identity() = Matrix3(n00 = 1f, n11 = 1f, n22 = 1f)

        fun makeRotationX(angle: Float): Matrix3 {
            val c = cos(angle)
            val s = sin(angle)

            return Matrix3(
                1f, 0f, 0f,
                0f, c, -s,
                0f, s, c
            )
        }

        fun makeRotationY(angle: Float): Matrix3 {
            val c = cos(angle)
            val s = sin(angle)

            return Matrix3(
                c, 0f, s,
                0f, 1f, 0f,
                -s, 0f, c
            )
        }

        fun makeRotationZ(angle: Float): Matrix3 {
            val c = cos(angle)
            val s = sin(angle)

            return Matrix3(
                c, -s, 0f,
                s, c, 0f,
                0f, 0f, 1f
            )
        }

        fun makeRotation(axis: Vector3, angle: Float): Matrix3 {
            val c = cos(angle)
            val s = sin(angle)
            val d = 1f - c

            val x = axis.x * d
            val y = axis.y * d
            val z = axis.z * d

            val axay = x * axis.y
            val axaz = x * axis.z
            val ayaz = y * axis.z

            return Matrix3(
                c + x * axis.x, axay - s * axis.z, axaz + s * axis.y,
                axay + s * axis.z, c + y * axis.y, ayaz - s * axis.x,
                axaz - s * axis.y, ayaz + s * axis.x, c + z * axis.z
            )
        }

        fun makeScale(
            scaleX: Float,
            scaleY: Float,
            scaleZ: Float,
        ) = Matrix3(n00 = scaleX, n11 = scaleY, n22 = scaleZ)

        fun makeScale(
            scale: Float,
            axis: Vector3
        ): Matrix3 {
            val s = scale - 1f

            val x = axis.x * s
            val y = axis.y * s
            val z = axis.z * s

            val axay = x * axis.y
            val axaz = x * axis.z
            val ayaz = y * axis.z

            return Matrix3(
                x * axis.x + 1f, axay, axaz,
                axay, y * axis.y + 1f, ayaz,
                axaz, ayaz, z * axis.z + 1f
            )
        }
    }
}
