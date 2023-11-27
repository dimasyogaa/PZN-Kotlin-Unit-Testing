package com.yogadimas._1_membuat_test

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {

    val calculator = Calculator()

    @Test
    fun testAddSuccess() {

        val result = calculator.add(10,10)

        assertEquals(20, result, "Hasil harusnya 20")


    }

    @Test
    fun testAddSuccess2() {

        val result = calculator.add(10,10)

        // assertNotEquals(ekspetasi kita, result, pesan yang tampil jika test gagal)
        assertEquals(40, result, "Hasil harusnya 20")


    }

    @Test
    fun testAddFailed() {

        val result = calculator.add(10,10)

        assertNotEquals(40, result)

    }

    @Test
    fun testDivideSuccess() {

        val result = calculator.divide(100, 10)
        assertEquals(10, result)

    }


    @Test
    fun testDivideFailed() {

        // harapannya throw exceptionnya
        assertThrows<IllegalArgumentException> {
            calculator.divide(100, 0)
        }

    }
}