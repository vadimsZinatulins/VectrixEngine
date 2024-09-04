package com.vectrix.math

import kotlin.math.sqrt

class Vector3(
    x: Float = 0f,
    y: Float = 0f,
    z: Float = 0f
) {
    private val _values = floatArrayOf(x, y, z)

    val asFloatArray
        get() = _values
    
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

    operator fun get(index: Int) = _values[index]
    operator fun set(index: Int, scalar: Float) {
        _values[index] = scalar
    }

    fun negate() = Vector3(-_values[0], -_values[1], -_values[2])

    operator fun plus(vector: Vector3) = Vector3(
        _values[0] + vector._values[0],
        _values[1] + vector._values[1],
        _values[2] + vector._values[2]
    )

    operator fun minus(vector: Vector3) = Vector3(
        _values[0] - vector._values[0],
        _values[1] - vector._values[1],
        _values[2] - vector._values[2]
    )

    operator fun times(scalar: Float) = Vector3(
        _values[0] * scalar,
        _values[1] * scalar,
        _values[2] * scalar
    )

    operator fun div(scalar: Float) = Vector3(
        _values[0] / scalar,
        _values[1] / scalar,
        _values[2] / scalar
    )

    fun squaredMagnitude() = _values[0] * _values[0] + _values[1] * _values[1] + _values[2] * _values[2]
    fun magnitude() = sqrt(squaredMagnitude())
    fun normalized() = magnitude().let { if (it == 0f) Vector3() else this / it }

    infix fun dot(vector: Vector3) =
        _values[0] * vector._values[0] + _values[1] * vector._values[1] + _values[2] * vector._values[2]

    infix fun cross(vector: Vector3) = Vector3(
        _values[1] * vector._values[2] - _values[2] * vector._values[1],
        _values[2] * vector._values[0] - _values[0] * vector._values[2],
        _values[0] * vector._values[1] - _values[1] * vector._values[0]
    )

    infix fun project(vector: Vector3) = vector * ((this dot vector) / (vector dot vector))
    infix fun reject(vector: Vector3) = this - vector * ((this dot vector) / (vector dot vector))
}
