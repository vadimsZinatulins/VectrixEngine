package com.vdm.vectrix

import com.vectrix.math.Vector4
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Vector4Test {
    @Test
    fun `test addition variation A`() {
        val a = Vector4(1.0f, 2.0f, 3.0f, 4.0f)
        val b = Vector4(5.0f, 6.0f, 7.0f, 8.0f)

        val expected = Vector4(6.0f, 8.0f, 10.0f, 12.0f)

        val result = a + b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }

    @Test
    fun `test addition variation B`() {
        val a = Vector4(0.0f, 0.0f, 0.0f, 0.0f)
        val b = Vector4(1.0f, -1.0f, 2.0f, -2.0f)

        val expected = Vector4(1.0f, -1.0f, 2.0f, -2.0f)

        val result = a + b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }

    @Test
    fun `test addition variation C`() {
        val a = Vector4(-1.0f, -2.0f, -3.0f, -4.0f)
        val b = Vector4(1.0f, 2.0f, 3.0f, 4.0f)

        val expected = Vector4(0.0f, 0.0f, 0.0f, 0.0f)

        val result = a + b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }

    @Test
    fun `test subtraction variation A`() {
        val a = Vector4(5.0f, 6.0f, 7.0f, 8.0f)
        val b = Vector4(1.0f, 2.0f, 3.0f, 4.0f)
        
        val expected = Vector4(4.0f, 4.0f, 4.0f, 4.0f)

        val result = a - b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }

    @Test
    fun `test subtraction variation B`() {
        val a = Vector4(1.0f, 2.0f, 3.0f, 4.0f)
        val b = Vector4(0.0f, 0.0f, 0.0f, 0.0f)

        val expected = Vector4(1.0f, 2.0f, 3.0f, 4.0f)

        val result = a - b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }

    @Test
    fun `test subtraction variation C`() {
        val a = Vector4(-1.0f, -2.0f, -3.0f, -4.0f)
        val b = Vector4(1.0f, 2.0f, 3.0f, 4.0f)

        val expected = Vector4(-2.0f, -4.0f, -6.0f, -8.0f)

        val result = a - b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }

    @Test
    fun `test multiplication variation A`() {
        val a = Vector4(1.0f, 2.0f, 3.0f, 4.0f)

        val scalar = 2.0f

        val expected = Vector4(2.0f, 4.0f, 6.0f, 8.0f)

        val result = a * scalar

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }

    @Test
    fun `test multiplication variation B`() {
        val a = Vector4(-1.0f, -2.0f, -3.0f, -4.0f)

        val scalar = -2.0f

        val expected = Vector4(2.0f, 4.0f, 6.0f, 8.0f)

        val result = a * scalar

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }

    @Test
    fun `test multiplication variation C`() {
        val a = Vector4(1.5f, 2.5f, 3.5f, 4.5f)

        val scalar = 2.0f

        val expected = Vector4(3.0f, 5.0f, 7.0f, 9.0f)

        val result = a * scalar

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }

    @Test
    fun `test division variation A`() {
        val a = Vector4(4.0f, 8.0f, 12.0f, 16.0f)

        val scalar = 2.0f

        val expected = Vector4(2.0f, 4.0f, 6.0f, 8.0f)

        val result = a / scalar

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }

    @Test
    fun `test division variation B`() {
        val a = Vector4(3.0f, 6.0f, 9.0f, 12.0f)

        val scalar = 3.0f

        val expected = Vector4(1.0f, 2.0f, 3.0f, 4.0f)

        val result = a / scalar

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }

    @Test
    fun `test division variation C`() {
        val a = Vector4(10.0f, 20.0f, 30.0f, 40.0f)

        val scalar = 10.0f

        val expected = Vector4(1.0f, 2.0f, 3.0f, 4.0f)

        val result = a / scalar

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }

    @Test
    fun `test squared magnitude variation A`() {
        val a = Vector4(1.0f, 2.0f, 3.0f, 4.0f)

        val expected = 30.0f

        val result = a.squaredMagnitude()

        assertEquals(expected, result, 0.0001f)
    }

    @Test
    fun `test squared magnitude variation B`() {
        val a = Vector4(0.0f, 0.0f, 0.0f, 0.0f)

        val expected = 0.0f

        val result = a.squaredMagnitude()

        assertEquals(expected, result, 0.0001f)
    }

    @Test
    fun `test squared magnitude variation C`() {
        val a = Vector4(-2.0f, 2.0f, 1.0f, 3.0f)

        val expected = 18.0f

        val result = a.squaredMagnitude()

        assertEquals(expected, result, 0.0001f)
    }

    @Test
    fun `test magnitude variation A`() {
        val a = Vector4(1.0f, 2.0f, 3.0f, 4.0f)

        val expected = 5.4772f

        val result = a.magnitude()

        assertEquals(expected, result, 0.0001f)
    }

    @Test
    fun `test magnitude variation B`() {
        val a = Vector4(0.0f, 0.0f, 0.0f, 0.0f)

        val expected = 0.0f

        val result = a.magnitude()

        assertEquals(expected, result, 0.0001f)
    }

    @Test
    fun `test magnitude variation C`() {
        val a = Vector4(3.0f, 4.0f, 0.0f, 0.0f)

        val expected = 5.0f

        val result = a.magnitude()

        assertEquals(expected, result, 0.0001f)
    }

    @Test
    fun `test normalized variation A`() {
        val a = Vector4(1.0f, 0.0f, 0.0f, 0.0f)

        val expected = Vector4(1.0f, 0.0f, 0.0f, 0.0f)

        val result = a.normalized()

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }

    @Test
    fun `test normalized variation B`() {
        val a = Vector4(0.0f, 0.0f, 0.0f, 0.0f)

        val expected = Vector4(0.0f, 0.0f, 0.0f, 0.0f)

        val result = a.normalized()

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }

    @Test
    fun `test normalized variation C`() {
        val a = Vector4(3.0f, 0.0f, 4.0f, 0.0f)

        val expected = Vector4(0.6f, 0.0f, 0.8f, 0.0f)

        val result = a.normalized()

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
        assertEquals(expected.w, result.w, 0.0001f)
    }
}