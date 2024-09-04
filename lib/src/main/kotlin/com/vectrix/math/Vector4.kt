package com.vectrix.math

import kotlin.math.sqrt

class Vector4(
    x: Float = 0f,
    y: Float = 0f,
    z: Float = 0f,
    w: Float = 0f
) {
    private val _values = floatArrayOf(x, y, z, w)

    val asFloatArray
        get() = _values
    
    val asVector3
        get() = Vector3(_values[0], _values[1], _values[2])

    var x
        get() = _values[0]
        set(scalar) {
            _values[0] = scalar
        }

    var y
        get() = _values[1]
        set(scalar) {
            _values[1] = scalar
        }

    var z
        get() = _values[2]
        set(scalar) {
            _values[2] = scalar
        }

    var w
        get() = _values[3]
        set(scalar) {
            _values[3] = scalar
        }

    operator fun get(index: Int) = _values[index]
    operator fun set(index: Int, scalar: Float) {
        _values[index] = scalar
    }

    operator fun plus(vector: Vector4) = Vector4(
        _values[0] + vector._values[0],
        _values[1] + vector._values[1],
        _values[2] + vector._values[2],
        _values[3] + vector._values[3]
    )

    operator fun minus(vector: Vector4) = Vector4(
        _values[0] - vector._values[0],
        _values[1] - vector._values[1],
        _values[2] - vector._values[2],
        _values[3] - vector._values[3]
    )

    operator fun times(scalar: Float) = Vector4(
        _values[0] * scalar,
        _values[1] * scalar,
        _values[2] * scalar,
        _values[3] * scalar
    )

    operator fun div(scalar: Float) = Vector4(
        _values[0] / scalar,
        _values[1] / scalar,
        _values[2] / scalar,
        _values[3] / scalar
    )

    fun squaredMagnitude() =
        _values[0] * _values[0] + _values[1] * _values[1] + _values[2] * _values[2] + _values[3] * _values[3]

    fun magnitude() = sqrt(squaredMagnitude())
    fun normalized() = magnitude().let { if (it == 0f) Vector4() else this / it }
}