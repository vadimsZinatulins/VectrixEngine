package com.vdm.vectrix

import com.vectrix.math.Vector3
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Vector3Test {
    @Test
    fun `test default constructor`() {
        val testSubject = Vector3()

        assertEquals(0.0f, testSubject.x, 0.0001f)
        assertEquals(0.0f, testSubject.y, 0.0001f)
        assertEquals(0.0f, testSubject.z, 0.0001f)
    }

    @Test
    fun `test parameterized constructor`() {
        val testSubject = Vector3(1.0f, 2.0f, 3.0f)

        assertEquals(1.0f, testSubject.x, 0.0001f)
        assertEquals(2.0f, testSubject.y, 0.0001f)
        assertEquals(3.0f, testSubject.z, 0.0001f)
    }

    @Test
    fun `test setters`() {
        val v = Vector3()

        v.x = 4.0f
        v.y = 5.0f
        v.z = 6.0f

        assertEquals(4.0f, v.x, 0.0001f)
        assertEquals(5.0f, v.y, 0.0001f)
        assertEquals(6.0f, v.z, 0.0001f)
    }

    @Test
    fun `test addition variation A`() {
        val a = Vector3(1.0f, 2.0f, 3.0f)
        val b = Vector3(4.0f, 5.0f, 6.0f)

        val expected = Vector3(5.0f, 7.0f, 9.0f)

        val result = a + b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test addition variation B`() {
        val a = Vector3(0.0f, 0.0f, 0.0f)
        val b = Vector3(1.0f, -1.0f, 2.0f)

        val expected = Vector3(1.0f, -1.0f, 2.0f)

        val result = a + b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test addition variation C`() {
        val a = Vector3(-2.0f, 3.0f, -4.0f)
        val b = Vector3(2.0f, -3.0f, 4.0f)

        val expected = Vector3(0.0f, 0.0f, 0.0f)

        val result = a + b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test subtraction variation A`() {
        val a = Vector3(5.0f, 7.0f, 9.0f)
        val b = Vector3(1.0f, 2.0f, 3.0f)

        val expected = Vector3(4.0f, 5.0f, 6.0f)

        val result = a - b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test subtraction variation B`() {
        val a = Vector3(0.0f, 0.0f, 0.0f)
        val b = Vector3(1.0f, 2.0f, 3.0f)

        val expected = Vector3(-1.0f, -2.0f, -3.0f)

        val result = a - b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test subtraction variation C`() {
        val a = Vector3(-1.0f, 2.0f, -3.0f)
        val b = Vector3(-4.0f, 5.0f, -6.0f)

        val expected = Vector3(3.0f, -3.0f, 3.0f)

        val result = a - b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test multiplication variation A`() {
        val a = Vector3(1.0f, 2.0f, 3.0f)
        val scalar = 2.0f

        val expected = Vector3(2.0f, 4.0f, 6.0f)

        val result = a * scalar

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test multiplication variation B`() {
        val a = Vector3(-1.0f, 0.0f, 3.0f)
        val scalar = -2.0f

        val expected = Vector3(2.0f, 0.0f, -6.0f)

        val result = a * scalar

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test multiplication variation C`() {
        val a = Vector3(0.5f, 1.5f, -2.5f)
        val scalar = 4.0f

        val expected = Vector3(2.0f, 6.0f, -10.0f)

        val result = a * scalar

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test division variation A`() {
        val a = Vector3(4.0f, 8.0f, 12.0f)
        val scalar = 2.0f

        val expected = Vector3(2.0f, 4.0f, 6.0f)

        val result = a / scalar

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test division variation B`() {
        val a = Vector3(-6.0f, 3.0f, 9.0f)
        val scalar = 3.0f

        val expected = Vector3(-2.0f, 1.0f, 3.0f)

        val result = a / scalar

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test division variation C`() {
        val a = Vector3(5.0f, 10.0f, 15.0f)
        val scalar = 5.0f

        val expected = Vector3(1.0f, 2.0f, 3.0f)

        val result = a / scalar

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test squared magnitude variation A`() {
        val a = Vector3(1.0f, 2.0f, 3.0f)

        val expected = 14.0f  // 1^2 + 2^2 + 3^2 = 14

        val result = a.squaredMagnitude()

        assertEquals(expected, result, 0.0001f)
    }

    @Test
    fun `test squared magnitude variation B`() {
        val a = Vector3(0.0f, 0.0f, 0.0f)

        val expected = 0.0f

        val result = a.squaredMagnitude()

        assertEquals(expected, result, 0.0001f)
    }

    @Test
    fun `test squared magnitude variation C`() {
        val a = Vector3(-3.0f, 4.0f, 0.0f)

        val expected = 25.0f

        val result = a.squaredMagnitude()

        assertEquals(expected, result, 0.0001f)
    }

    @Test
    fun `test magnitude variation A`() {
        val a = Vector3(1.0f, 2.0f, 2.0f)

        val expected = 3.0f

        val result = a.magnitude()

        assertEquals(expected, result, 0.0001f)
    }

    @Test
    fun `test magnitude variation B`() {
        val a = Vector3(0.0f, 0.0f, 0.0f)

        val expected = 0.0f

        val result = a.magnitude()

        assertEquals(expected, result, 0.0001f)
    }

    @Test
    fun `test magnitude variation C`() {
        val a = Vector3(-3.0f, 4.0f, 0.0f)

        val expected = 5.0f

        val result = a.magnitude()

        assertEquals(expected, result, 0.0001f)
    }

    @Test
    fun `test normalized variation A`() {
        val a = Vector3(3.0f, 0.0f, 4.0f)

        val expected = Vector3(0.6f, 0.0f, 0.8f)

        val result = a.normalized()

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test normalized variation B`() {
        val a = Vector3(0.0f, 0.0f, 0.0f)

        val expected = Vector3(0.0f, 0.0f, 0.0f)

        val result = a.normalized()

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test normalized variation C`() {
        val a = Vector3(6.0f, 8.0f, 0.0f)

        val expected = Vector3(0.6f, 0.8f, 0.0f)

        val result = a.normalized()

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test dot product variation A`() {
        val a = Vector3(1.0f, 2.0f, 3.0f)
        val b = Vector3(4.0f, 5.0f, 6.0f)

        val expected = 32.0f

        val result = a dot b

        assertEquals(expected, result, 0.0001f)
    }

    @Test
    fun `test dot product variation B`() {
        val a = Vector3(0.0f, 0.0f, 0.0f)
        val b = Vector3(1.0f, 2.0f, 3.0f)

        val expected = 0.0f

        val result = a dot b

        assertEquals(expected, result, 0.0001f)
    }

    @Test
    fun `test dot product variation C`() {
        val a = Vector3(1.0f, 0.0f, 0.0f)
        val b = Vector3(0.0f, 1.0f, 0.0f)

        val expected = 0.0f

        val result = a dot b

        assertEquals(expected, result, 0.0001f)
    }

    @Test
    fun `test cross product variation A`() {
        val a = Vector3(1.0f, 0.0f, 0.0f)
        val b = Vector3(0.0f, 1.0f, 0.0f)

        val expected = Vector3(0.0f, 0.0f, 1.0f)

        val result = a cross b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test cross product variation B`() {
        val a = Vector3(1.0f, 2.0f, 3.0f)
        val b = Vector3(4.0f, 5.0f, 6.0f)

        val expected = Vector3(-3.0f, 6.0f, -3.0f)

        val result = a cross b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test cross product variation C`() {
        val a = Vector3(0.0f, 0.0f, 0.0f)
        val b = Vector3(1.0f, 2.0f, 3.0f)

        val expected = Vector3(0.0f, 0.0f, 0.0f)

        val result = a cross b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test project variation A`() {
        val a = Vector3(1.0f, 2.0f, 3.0f)
        val b = Vector3(1.0f, 0.0f, 0.0f)

        val expected = Vector3(1.0f, 0.0f, 0.0f)

        val result = a project b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test project variation B`() {
        val a = Vector3(1.0f, 2.0f, 3.0f)
        val b = Vector3(0.0f, 1.0f, 0.0f)

        val expected = Vector3(0.0f, 2.0f, 0.0f)

        val result = a project b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test project variation C`() {
        val a = Vector3(1.0f, 1.0f, 1.0f)
        val b = Vector3(0.0f, 0.0f, 1.0f)

        val expected = Vector3(0.0f, 0.0f, 1.0f)

        val result = a project b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test reject variation A`() {
        val a = Vector3(1.0f, 2.0f, 3.0f)
        val b = Vector3(1.0f, 0.0f, 0.0f)

        val expected = Vector3(0.0f, 2.0f, 3.0f)

        val result = a reject b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test reject variation B`() {
        val a = Vector3(1.0f, 2.0f, 3.0f)
        val b = Vector3(0.0f, 1.0f, 0.0f)

        val expected = Vector3(1.0f, 0.0f, 3.0f)

        val result = a reject b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }

    @Test
    fun `test reject variation C`() {
        val a = Vector3(1.0f, 1.0f, 1.0f)
        val b = Vector3(0.0f, 0.0f, 1.0f)

        val expected = Vector3(1.0f, 1.0f, 0.0f)
        val result = a reject b

        assertEquals(expected.x, result.x, 0.0001f)
        assertEquals(expected.y, result.y, 0.0001f)
        assertEquals(expected.z, result.z, 0.0001f)
    }
}