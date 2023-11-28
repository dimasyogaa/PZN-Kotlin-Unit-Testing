package com.yogadimas._3_mengubah_nama_test

import com.yogadimas._1_3.Calculator
import com.yogadimas._3_mengubah_nama_test.generator.SimpleDisplayNameGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("_3_mengubah_nama_test - CalculatorTest")
@DisplayNameGeneration(SimpleDisplayNameGenerator::class)
class CalculatorTest {

    val calculator = Calculator()

    @Test
    // @DisplayName("Test for function Calculator.add(10,10)")
    fun testAddSuccess () {

        val result = calculator.add(10,10)

        assertEquals(20, result, "Hasil harusnya 20")


    }

    @Test
    fun `test Add Success 2`() {

        val result = calculator.add(10,10)

        assertNotEquals(40, result)


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