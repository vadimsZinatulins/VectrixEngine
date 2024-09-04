package com.vdm.vectrix

import com.vectrix.math.Matrix3
import com.vectrix.math.Vector3
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Matrix3Test {
    private val tolerance = 0.0001f

    @Test
    fun `test identity creation`() {
        val testSample = Matrix3.identity()

        val expected = Matrix3(
            1f, 0f, 0f,
            0f, 1f, 0f,
            0f, 0f, 1f
        )

        assertEquality(expected, testSample)
    }

    @Test
    fun `test addition`() {
        val a = Matrix3(
            1f, 2f, 3f,
            4f, 5f, 6f,
            7f, 8f, 9f
        )

        val b = Matrix3(
            1f, 2f, 3f,
            4f, 5f, 6f,
            7f, 8f, 9f
        )

        val expected = Matrix3(
            2f, 4f, 6f,
            8f, 10f, 12f,
            14f, 16f, 18f
        )

        val result = a + b

        assertEquality(expected, result)
    }

    @Test
    fun `test subtraction`() {
        val a = Matrix3(
            1f, 2f, 3f,
            4f, 5f, 6f,
            7f, 8f, 9f
        )

        val b = Matrix3(
            1f, 2f, 3f,
            4f, 5f, 6f,
            7f, 8f, 9f
        )

        val expected = Matrix3()

        val result = a - b

        assertEquality(expected, result)
    }

    @Test
    fun `test matrix x scalar multiplication`() {
        val a = Matrix3(
            5f, 8f, -4f,
            6f, 9f, -5f,
            4f, 7f, -2f
        )

        val b = 2f

        val expected = Matrix3(
            10f, 16f, -8f,
            12f, 18f, -10f,
            8f, 14f, -4f
        )

        val result = a * b

        assertEquality(expected, result)
    }

    @Test
    fun `test matrix x vector multiplication`() {
        val a = Matrix3(
            5f, 8f, -4f,
            6f, 9f, -5f,
            4f, 7f, -2f
        )

        val b = Vector3(2f, 3f, 4f)

        val expected = Vector3(
            5f * 2f + 8f * 3f + (-4f) * 4f,
            6f * 2f + 9f * 3f + (-5f) * 4f,
            4f * 2f + 7f * 3f + (-2f) * 4f
        )

        val result = a * b

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test matrix x matrix multiplication`() {
        val a = Matrix3(
            5f, 8f, -4f,
            6f, 9f, -5f,
            4f, 7f, -2f
        )

        val b = Matrix3(
            -17f / 3f, 4f, 4f / 3f,
            8f / 3f, -2f, -1f / 3f,
            -2f, 1f, 1f
        )

        val expected = Matrix3.identity()

        val result = a * b

        assertEquality(expected, result)
    }

    @Test
    fun `test determinant`() {
        val testSample = Matrix3(
            5f, 8f, -4f,
            6f, 9f, -5f,
            4f, 7f, -2f
        )

        val expected = -3f

        val result = testSample.determinant()

        assertEquals(expected, result, tolerance)
    }

    @Test
    fun `test inverse`() {
        val testSample = Matrix3(
            5f, 8f, -4f,
            6f, 9f, -5f,
            4f, 7f, -2f
        )

        val expected = Matrix3(
            -17f / 3f, 4f, 4f / 3f,
            8f / 3f, -2f, -1f / 3f,
            -2f, 1f, 1f
        )

        val result = testSample.inverse()

        assertEquality(expected, result)
        assertEquality(testSample, result.inverse())
    }

    @Test
    fun `test 90 degree clockwise rotation on X axis variation A`() {
        val testSample = Vector3(0f, 1f, 0f)

        val expected = Vector3(0f, 0f, -1f)

        val result = Matrix3.makeRotationX(Math.toRadians(-90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 90 degree clockwise rotation on X axis variation B`() {
        val testSample = Vector3(0f, 1f, 1f)

        val expected = Vector3(0f, 1f, -1f)

        val result = Matrix3.makeRotationX(Math.toRadians(-90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 90 degree clockwise rotation on X axis variation C`() {
        val testSample = Vector3(1f, 0f, 1f)

        val expected = Vector3(1f, 1f, 0f)

        val result = Matrix3.makeRotationX(Math.toRadians(-90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 180 degree clockwise rotation on X axis variation A`() {
        val testSample = Vector3(0f, 1f, 0f)

        val expected = Vector3(0f, -1f, 0f)

        val result = Matrix3.makeRotationX(Math.toRadians(-180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 180 degree clockwise rotation on X axis variation B`() {
        val testSample = Vector3(0f, 1f, 1f)

        val expected = Vector3(0f, -1f, -1f)

        val result = Matrix3.makeRotationX(Math.toRadians(-180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 180 degree clockwise rotation on X axis variation C`() {
        val testSample = Vector3(1f, 1f, 1f)

        val expected = Vector3(1f, -1f, -1f)

        val result = Matrix3.makeRotationX(Math.toRadians(-180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 270 degree clockwise rotation on X axis variation A`() {
        val testSample = Vector3(0f, 1f, 0f)

        val expected = Vector3(0f, 0f, 1f)

        val result = Matrix3.makeRotationX(Math.toRadians(-270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 270 degree clockwise rotation on X axis variation B`() {
        val testSample = Vector3(0f, 0f, 1f)

        val expected = Vector3(0f, -1f, 0f)

        val result = Matrix3.makeRotationX(Math.toRadians(-270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 270 degree clockwise rotation on X axis variation C`() {
        val testSample = Vector3(1f, 1f, 0f)

        val expected = Vector3(1f, 0f, 1f)

        val result = Matrix3.makeRotationX(Math.toRadians(-270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 90 degree counterclockwise rotation on X axis variation A`() {
        val testSample = Vector3(0f, 1f, 0f)

        val expected = Vector3(0f, 0f, 1f)

        val result = Matrix3.makeRotationX(Math.toRadians(90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 90 degree counterclockwise rotation on X axis variation B`() {
        val testSample = Vector3(1f, 0f, 1f)

        val expected = Vector3(1f, -1f, 0f)

        val result = Matrix3.makeRotationX(Math.toRadians(90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 90 degree counterclockwise rotation on X axis variation C`() {
        val testSample = Vector3(0f, 1f, 1f)

        val expected = Vector3(0f, -1f, 1f)

        val result = Matrix3.makeRotationX(Math.toRadians(90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 180 degree counterclockwise rotation on X axis variation A`() {
        val testSample = Vector3(0f, 1f, 0f)

        val expected = Vector3(0f, -1f, 0f)

        val result = Matrix3.makeRotationX(Math.toRadians(180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 180 degree counterclockwise rotation on X axis variation B`() {
        val testSample = Vector3(1f, 1f, 1f)

        val expected = Vector3(1f, -1f, -1f)

        val result = Matrix3.makeRotationX(Math.toRadians(180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 180 degree counterclockwise rotation on X axis variation C`() {
        val testSample = Vector3(0f, 1f, -1f)

        val expected = Vector3(0f, -1f, 1f)

        val result = Matrix3.makeRotationX(Math.toRadians(180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 270 degree counterclockwise rotation on X axis variation A`() {
        val testSample = Vector3(0f, 1f, 0f)

        val expected = Vector3(0f, 0f, -1f)

        val result = Matrix3.makeRotationX(Math.toRadians(270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 270 degree counterclockwise rotation on X axis variation B`() {
        val testSample = Vector3(1f, 0f, 1f)

        val expected = Vector3(1f, 1f, 0f)

        val result = Matrix3.makeRotationX(Math.toRadians(270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 270 degree counterclockwise rotation on X axis variation C`() {
        val testSample = Vector3(0f, 1f, -1f)

        val expected = Vector3(0f, -1f, -1f)

        val result = Matrix3.makeRotationX(Math.toRadians(270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test arbitrary degree rotation on X axis variation A`() {
        val testSample = Vector3(0f, 1f, 0f)

        val expected = Vector3(0f, 0.70711f, 0.70711f)

        val result = Matrix3.makeRotationX(Math.toRadians(45.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test arbitrary degree rotation on X axis variation B`() {
        val testSample = Vector3(1f, 0f, 1f)

        val expected = Vector3(1f, 0.70711f, 0.70711f)

        val result = Matrix3.makeRotationX(Math.toRadians(-45.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test arbitrary degree rotation on X axis variation C`() {
        val testSample = Vector3(1f, 1f, 1f)

        val expected = Vector3(1f, 0.36603f, 1.36603f)

        val result = Matrix3.makeRotationX(Math.toRadians(30.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 90 degree clockwise rotation on Y axis variation A`() {
        val testSample = Vector3(1f, 0f, 0f)

        val expected = Vector3(0f, 0f, 1f)

        val result = Matrix3.makeRotationY(Math.toRadians(-90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 90 degree clockwise rotation on Y axis variation B`() {
        val testSample = Vector3(0f, 1f, 1f)

        val expected = Vector3(-1f, 1f, 0f)

        val result = Matrix3.makeRotationY(Math.toRadians(-90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 90 degree clockwise rotation on Y axis variation C`() {
        val testSample = Vector3(1f, 1f, 1f)

        val expected = Vector3(-1f, 1f, 1f)

        val result = Matrix3.makeRotationY(Math.toRadians(-90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 180 degree clockwise rotation on Y axis variation A`() {
        val testSample = Vector3(1f, 0f, 0f)

        val expected = Vector3(-1f, 0f, 0f)

        val result = Matrix3.makeRotationY(Math.toRadians(-180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 180 degree clockwise rotation on Y axis variation B`() {
        val testSample = Vector3(0f, 1f, 1f)

        val expected = Vector3(0f, 1f, -1f)

        val result = Matrix3.makeRotationY(Math.toRadians(-180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 180 degree clockwise rotation on Y axis variation C`() {
        val testSample = Vector3(1f, 1f, 1f)

        val expected = Vector3(-1f, 1f, -1f)

        val result = Matrix3.makeRotationY(Math.toRadians(-180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 270 degree clockwise rotation on Y axis variation A`() {
        val testSample = Vector3(1f, 0f, 0f)

        val expected = Vector3(0f, 0f, -1f)

        val result = Matrix3.makeRotationY(Math.toRadians(-270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 270 degree clockwise rotation on Y axis variation B`() {
        val testSample = Vector3(0f, 1f, 1f)

        val expected = Vector3(1f, 1f, 0f)

        val result = Matrix3.makeRotationY(Math.toRadians(-270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 270 degree clockwise rotation on Y axis variation C`() {
        val testSample = Vector3(1f, 1f, 1f)

        val expected = Vector3(1f, 1f, -1f)

        val result = Matrix3.makeRotationY(Math.toRadians(-270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 90 degree counterclockwise rotation on Y axis variation A`() {
        val testSample = Vector3(1f, 0f, 0f)

        val expected = Vector3(0f, 0f, -1f)

        val result = Matrix3.makeRotationY(Math.toRadians(90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 90 degree counterclockwise rotation on Y axis variation B`() {
        val testSample = Vector3(0f, 1f, 1f)

        val expected = Vector3(1f, 1f, 0f)

        val result = Matrix3.makeRotationY(Math.toRadians(90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 90 degree counterclockwise rotation on Y axis variation C`() {
        val testSample = Vector3(1f, 1f, 1f)

        val expected = Vector3(1f, 1f, -1f)

        val result = Matrix3.makeRotationY(Math.toRadians(90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 180 degree counterclockwise rotation on Y axis variation A`() {
        val testSample = Vector3(1f, 0f, 0f)

        val expected = Vector3(-1f, 0f, 0f)

        val result = Matrix3.makeRotationY(Math.toRadians(180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 180 degree counterclockwise rotation on Y axis variation B`() {
        val testSample = Vector3(0f, 1f, 1f)

        val expected = Vector3(0f, 1f, -1f)

        val result = Matrix3.makeRotationY(Math.toRadians(180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 180 degree counterclockwise rotation on Y axis variation C`() {
        val testSample = Vector3(1f, 1f, 1f)

        val expected = Vector3(-1f, 1f, -1f)

        val result = Matrix3.makeRotationY(Math.toRadians(180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 270 degree counterclockwise rotation on Y axis variation A`() {
        val testSample = Vector3(1f, 0f, 0f)

        val expected = Vector3(0f, 0f, 1f)

        val result = Matrix3.makeRotationY(Math.toRadians(270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 270 degree counterclockwise rotation on Y axis variation B`() {
        val testSample = Vector3(0f, 1f, 1f)

        val expected = Vector3(-1f, 1f, 0f)

        val result = Matrix3.makeRotationY(Math.toRadians(270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 270 degree counterclockwise rotation on Y axis variation C`() {
        val testSample = Vector3(1f, 1f, 1f)

        val expected = Vector3(-1f, 1f, 1f)

        val result = Matrix3.makeRotationY(Math.toRadians(270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test arbitrary degree rotation on Y axis variation A`() {
        val testSample = Vector3(1f, 0f, 0f)

        val expected = Vector3(0.70711f, 0f, -0.70711f)

        val result = Matrix3.makeRotationY(Math.toRadians(45.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test arbitrary degree rotation on Y axis variation B`() {
        val testSample = Vector3(0f, 1f, 1f)

        val expected = Vector3(0.86603f, 1f, 0.5f)

        val result = Matrix3.makeRotationY(Math.toRadians(60.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test arbitrary degree rotation on Y axis variation C`() {
        val testSample = Vector3(1f, 1f, 1f)

        val expected = Vector3(1.36603f, 1f, 0.36603f)

        val result = Matrix3.makeRotationY(Math.toRadians(30.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test 90 degree counter clockwise rotation on Z axis variation A`() {
        val testSample = Vector3(1f, 0f, 0f)

        val expected = Vector3(0f, 1f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 90 degree counter clockwise rotation on Z axis variation B`() {
        val testSample = Vector3(0.5f, 2.3f, 0f)

        val expected = Vector3(-2.3f, 0.5f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 90 degree counter clockwise rotation on Z axis variation C`() {
        val testSample = Vector3(-1.2f, 3.7f, 0f)

        val expected = Vector3(-3.7f, -1.2f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 180 degree counter clockwise rotation on Z axis variation A`() {
        val testSample = Vector3(1f, 0f, 0f)

        val expected = Vector3(-1f, 0f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 180 degree counter clockwise rotation on Z axis variation B`() {
        val testSample = Vector3(0f, 1f, 0f)

        val expected = Vector3(0f, -1f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 180 degree counter clockwise rotation on Z axis variation C`() {
        val testSample = Vector3(1.5f, -2.5f, 0f)

        val expected = Vector3(-1.5f, 2.5f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 270 degree counter clockwise rotation on Z axis variation A`() {
        val testSample = Vector3(1f, 0f, 0f)

        val expected = Vector3(0f, -1f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 270 degree counter clockwise rotation on Z axis variation B`() {
        val testSample = Vector3(0f, 1f, 0f)

        val expected = Vector3(1f, 0f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 270 degree counter clockwise rotation on Z axis variation C`() {
        val testSample = Vector3(-1.2f, 3.7f, 0f)

        val expected = Vector3(3.7f, 1.2f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 90 degree clockwise rotation on Z axis variation A`() {
        val testSample = Vector3(1f, 0f, 0f)

        val expected = Vector3(0f, -1f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(-90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 90 degree clockwise rotation on Z axis variation B`() {
        val testSample = Vector3(0f, 1f, 0f)

        val expected = Vector3(1f, 0f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(-90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 90 degree clockwise rotation on Z axis variation C`() {
        val testSample = Vector3(-2.4f, 3.6f, 0f)

        val expected = Vector3(3.6f, 2.4f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(-90.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 180 degree clockwise rotation on Z axis variation A`() {
        val testSample = Vector3(1f, 0f, 0f)

        val expected = Vector3(-1f, 0f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(-180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 180 degree clockwise rotation on Z axis variation B`() {
        val testSample = Vector3(0f, 1f, 0f)

        val expected = Vector3(0f, -1f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(-180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 180 degree clockwise rotation on Z axis variation C`() {
        val testSample = Vector3(1.2f, -0.7f, 0f)

        val expected = Vector3(-1.2f, 0.7f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(-180.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 270 degree clockwise rotation on Z axis variation A`() {
        val testSample = Vector3(1f, 0f, 0f)

        val expected = Vector3(0f, 1f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(-270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 270 degree clockwise rotation on Z axis variation B`() {
        val testSample = Vector3(0f, 1f, 0f)

        val expected = Vector3(-1f, 0f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(-270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test 270 degree clockwise rotation on Z axis variation C`() {
        val testSample = Vector3(-1.4f, 2.1f, 0f)

        val expected = Vector3(-2.1f, -1.4f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(-270.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test arbitrary degree rotation on Z axis variation A`() {
        val testSample = Vector3(0f, 1f, 0f)

        val expected = Vector3(-0.70711f, 0.70711f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(45.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test arbitrary degree rotation on Z axis variation B`() {
        val testSample = Vector3(1f, 0f, 0f)

        val expected = Vector3(-0.5f, 0.86603f, 0f)

        val result = Matrix3.makeRotationZ(Math.toRadians(120.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test arbitrary degree rotation on Z axis variation C`() {
        val testSample = Vector3(0.5f, 1f, 1f)

        val expected = Vector3(1.11603f, 0.06699f, 1f)

        val result = Matrix3.makeRotationZ(Math.toRadians(-60.0).toFloat()) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test arbitrary degree rotation an arbitrary axis variation A`() {
        val testSample = Vector3(1f, 0f, 0f)

        val expected = Vector3(0f, 1f, 0f)

        val result = Matrix3.makeRotation(
            Vector3(0f, 0f, 1f),
            Math.toRadians(90.0).toFloat()
        ) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test arbitrary degree rotation an arbitrary axis variation B`() {
        val testSample = Vector3(0.5f, 1f, 1f)

        val expected = Vector3(0.38706f, 1.03518f, 1.0142f)

        val result = Matrix3.makeRotation(
            Vector3(0.267261f, 0.534522f, 0.801784f),
            Math.toRadians(23.0).toFloat()
        ) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test arbitrary degree rotation an arbitrary axis variation C`() {
        val testSample = Vector3(1.5f, 0.23f, 1f)

        val expected = Vector3(1.35521f, -1.20137f, -0.15173f)

        val result = Matrix3.makeRotation(
            Vector3(0.965609f, 0.0965609f, -0.241402f),
            Math.toRadians(87.0).toFloat()
        ) * testSample

        assertEquals(expected.x, result.x, tolerance)
        assertEquals(expected.y, result.y, tolerance)
        assertEquals(expected.z, result.z, tolerance)
    }

    @Test
    fun `test scaling`() {
        val scaleX = 2.0f
        val scaleY = 3.0f
        val scaleZ = 4.0f

        val testSample = Matrix3.makeScale(scaleX, scaleY, scaleZ)


        // Check if the scale values are properly set in the matrix
        assertEquals(scaleX, testSample[0, 0], tolerance)
        assertEquals(scaleY, testSample[1, 1], tolerance)
        assertEquals(scaleZ, testSample[2, 2], tolerance)
    }

    @Test
    fun `test vector multiplication with scaling matrix`() {
        val scaleX = 2.0f
        val scaleY = 3.0f
        val scaleZ = 4.0f

        val scalingMatrix = Matrix3.makeScale(scaleX, scaleY, scaleZ)

        // Define a vector
        val vector = Vector3(1.0f, 1.0f, 1.0f)

        // Multiply the vector by the scaling matrix
        val resultVector = scalingMatrix * vector

        // Check if the result is correctly scaled
        assertEquals(2.0f, resultVector.x, tolerance)
        assertEquals(3.0f, resultVector.y, tolerance)
        assertEquals(4.0f, resultVector.z, tolerance)
    }

    @Test
    fun `test scaling along arbitrary axis`() {
        val scale = 2.0f
        val axis = Vector3(1.0f, 0.0f, 0.0f) // Example axis along X

        val scalingMatrix = Matrix3.makeScale(scale, axis)

        assertEquals(2.0f, scalingMatrix[0, 0], tolerance)
        assertEquals(0.0f, scalingMatrix[0, 1], tolerance)
        assertEquals(0.0f, scalingMatrix[0, 2], tolerance)

        assertEquals(0.0f, scalingMatrix[1, 0], tolerance)
        assertEquals(1.0f, scalingMatrix[1, 1], tolerance)
        assertEquals(0.0f, scalingMatrix[1, 2], tolerance)

        assertEquals(0.0f, scalingMatrix[2, 0], tolerance)
        assertEquals(0.0f, scalingMatrix[2, 1], tolerance)
        assertEquals(1.0f, scalingMatrix[2, 2], tolerance)
    }

    private fun assertEquality(
        expected: Matrix3,
        result: Matrix3
    ) {
        assertEquals(expected[0, 0], result[0, 0], tolerance)
        assertEquals(expected[0, 1], result[0, 1], tolerance)
        assertEquals(expected[0, 2], result[0, 2], tolerance)

        assertEquals(expected[1, 0], result[1, 0], tolerance)
        assertEquals(expected[1, 1], result[1, 1], tolerance)
        assertEquals(expected[1, 2], result[1, 2], tolerance)

        assertEquals(expected[2, 0], result[2, 0], tolerance)
        assertEquals(expected[2, 1], result[2, 1], tolerance)
        assertEquals(expected[2, 2], result[2, 2], tolerance)
    }
}