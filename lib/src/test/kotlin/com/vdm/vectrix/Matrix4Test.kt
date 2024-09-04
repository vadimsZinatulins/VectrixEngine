package com.vdm.vectrix

import com.vectrix.math.Matrix4
import com.vectrix.math.Vector4
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Matrix4Test {
    @Test
    fun `test identity creation`() {
        val testSample = Matrix4.identity()

        val expected = Matrix4(
            1f, 0f, 0f, 0f,
            0f, 1f, 0f, 0f,
            0f, 0f, 1f, 0f,
            0f, 0f, 0f, 1f
        )

        assertEquality(expected, testSample)
    }

    @Test
    fun `test as float array`() {
        val sample = Matrix4(
            1f, 2f, 3f, 4f,
            5f, 6f, 7f, 8f,
            9f, 10f, 11f, 12f,
            13f, 14f, 15f, 16f
        )

        val expected = floatArrayOf(
            1f, 2f, 3f, 4f,
            5f, 6f, 7f, 8f,
            9f, 10f, 11f, 12f,
            13f, 14f, 15f, 16f
        )

        val result = sample.asFloatArray

        expected.forEachIndexed { index, it -> assertEquals(it, result[index], 0.0001f) }
    }

    @Test
    fun `test addition`() {
        val a = Matrix4(
            1f, 2f, 3f, 4f,
            5f, 6f, 7f, 8f,
            9f, 10f, 11f, 12f,
            13f, 14f, 15f, 16f,
        )

        val b = Matrix4(
            1f, 2f, 3f, 4f,
            5f, 6f, 7f, 8f,
            9f, 10f, 11f, 12f,
            13f, 14f, 15f, 16f,
        )

        val expected = Matrix4(
            2f, 4f, 6f, 8f,
            10f, 12f, 14f, 16f,
            18f, 20f, 22f, 24f,
            26f, 28f, 30f, 32f
        )

        val result = a + b

        assertEquality(expected, result)
    }

    @Test
    fun `test subtraction`() {
        val a = Matrix4(
            5f, 6f, 7f, 8f,
            9f, 10f, 11f, 12f,
            13f, 14f, 15f, 16f,
            17f, 18f, 19f, 20f
        )

        val b = Matrix4(
            1f, 2f, 3f, 4f,
            5f, 6f, 7f, 8f,
            9f, 10f, 11f, 12f,
            13f, 14f, 15f, 16f
        )

        val expected = Matrix4(
            4f, 4f, 4f, 4f,
            4f, 4f, 4f, 4f,
            4f, 4f, 4f, 4f,
            4f, 4f, 4f, 4f
        )

        val result = a - b

        assertEquality(expected, result)
    }

    @Test
    fun `test matrix x scalar multiplication`() {
        val a = Matrix4(
            1f, 2f, 3f, 4f,
            5f, 6f, 7f, 8f,
            9f, 10f, 11f, 12f,
            13f, 14f, 15f, 16f
        )

        val scalar = 2f

        val expected = Matrix4(
            2f, 4f, 6f, 8f,
            10f, 12f, 14f, 16f,
            18f, 20f, 22f, 24f,
            26f, 28f, 30f, 32f
        )

        val result = a * scalar

        assertEquality(expected, result)
    }

    @Test
    fun `test matrix x vector multiplication`() {
        val matrix = Matrix4(
            1f, 2f, 3f, 4f,
            5f, 6f, 7f, 8f,
            9f, 10f, 11f, 12f,
            13f, 14f, 15f, 16f
        )

        val vector = Vector4(1f, 2f, 3f, 4f)

        val expected = Vector4(
            30f, 70f, 110f, 150f
        )

        val result = matrix * vector

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }

    @Test
    fun `test matrix x identity multiplication`() {
        val a = Matrix4(
            1f, 2f, 3f, 4f,
            5f, 6f, 7f, 8f,
            9f, 10f, 11f, 12f,
            13f, 14f, 15f, 16f
        )

        val b = Matrix4.identity()

        val expected = Matrix4(
            1f, 2f, 3f, 4f,
            5f, 6f, 7f, 8f,
            9f, 10f, 11f, 12f,
            13f, 14f, 15f, 16f
        )

        val result = a * b

        assertEquality(expected, result)
    }

    @Test
    fun `test matrix x matrix multiplication`() {
        val a = Matrix4(
            1f, 2f, 3f, 4f,
            5f, 6f, 7f, 8f,
            9f, 10f, 11f, 12f,
            13f, 14f, 15f, 16f
        )

        val b = Matrix4(
            1f, 2f, 3f, 4f,
            5f, 6f, 7f, 8f,
            9f, 10f, 11f, 12f,
            13f, 14f, 15f, 16f
        )

        val expected = Matrix4(
            90f, 100f, 110f, 120f,
            202f, 228f, 254f, 280f,
            314f, 356f, 398f, 440f,
            426f, 484f, 542f, 600f
        )

        val result = a * b

        assertEquality(expected, result)
    }

    @Test
    fun `test inverse calculation variation A`() {
        val matrix = Matrix4(
            4f, 7f, 2f, 3f,
            3f, 6f, 1f, 2f,
            2f, 5f, 3f, 1f,
            1f, 4f, 2f, 2f
        )

        val expected = Matrix4(
            7f / 9f, -5f / 9f, 1f / 9f, -2f / 3f,
            -11f / 18f, 13f / 18f, 1f / 18f, 1f / 6f,
            1f / 3f, -2f / 3f, 1f / 3f, 0f,
            1f / 2f, -1f / 2f, -1f / 2f, 1f / 2f
        )

        val result = matrix.inverse()

        assertEquality(expected, result)
    }

    @Test
    fun `test inverse calculation variation B`() {
        val matrix = Matrix4(
            1f, 2f, 3f, 0f,
            0f, 1f, 4f, 0f,
            5f, 6f, 0f, 1f,
            0f, 0f, 0f, 1f
        )

        val expected = Matrix4(
            -24f, 18f, 5f, -5f,
            20f, -15f, -4f, 4f,
            -5f, 4f, 1f, -1f,
            0f, 0f, 0f, 1f
        )

        val result = matrix.inverse()

        assertEquality(expected, result)
    }

    @Test
    fun `test matrix x matrix inverse multiplication`() {
        val testSubject = Matrix4(
            4f, 7f, 2f, 3f,
            3f, 6f, 1f, 2f,
            2f, 5f, 3f, 1f,
            1f, 4f, 2f, 2f
        )

        val expected = Matrix4.identity()

        val result = testSubject * testSubject.inverse()

        assertEquality(expected, result)
    }

    private fun assertEquality(
        expected: Matrix4,
        result: Matrix4
    ) {
        assertEquals(expected[0, 0], result[0, 0], 0.0001f)
        assertEquals(expected[0, 1], result[0, 1], 0.0001f)
        assertEquals(expected[0, 2], result[0, 2], 0.0001f)
        assertEquals(expected[0, 3], result[0, 3], 0.0001f)

        assertEquals(expected[1, 0], result[1, 0], 0.0001f)
        assertEquals(expected[1, 1], result[1, 1], 0.0001f)
        assertEquals(expected[1, 2], result[1, 2], 0.0001f)
        assertEquals(expected[1, 3], result[1, 3], 0.0001f)

        assertEquals(expected[2, 0], result[2, 0], 0.0001f)
        assertEquals(expected[2, 1], result[2, 1], 0.0001f)
        assertEquals(expected[2, 2], result[2, 2], 0.0001f)
        assertEquals(expected[2, 3], result[2, 3], 0.0001f)

        assertEquals(expected[3, 0], result[3, 0], 0.0001f)
        assertEquals(expected[3, 1], result[3, 1], 0.0001f)
        assertEquals(expected[3, 2], result[3, 2], 0.0001f)
        assertEquals(expected[3, 3], result[3, 3], 0.0001f)
    }
}