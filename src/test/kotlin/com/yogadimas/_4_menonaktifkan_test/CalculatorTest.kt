package com.yogadimas._4_menonaktifkan_test

import com.yogadimas._1_3.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("_4_menonaktifkan_test - CalculatorTest")
class CalculatorTest {

    val calculator = Calculator()

    @Test
    fun testAddSuccess () {

        val result = calculator.add(10,10)

        assertEquals(20, result, "Hasil harusnya 20")


    }


    @Disabled
    @Test
    fun testAddSuccess2() {

        val result = calculator.add(10,10)

        // assertEquals(ekspetasi kita, result, pesan yang tampil jika test gagal)
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


    @Disabled
    @Test
    fun testComingSoon() {
        // belum selesai
    }
}