package com.yogadimas._5_sebelum_setelah_test._a_each

import com.yogadimas._5_sebelum_setelah_test._helper.Helper.show
import com.yogadimas.calculator.Calculator
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals

@DisplayName("_5_sebelum_setelah_test - each - CalculatorTest")
class CalculatorTest {

    val calculator = Calculator()

    @BeforeEach
    fun beforeEach() {
        println("Sebelum Unit Test")
    }

    @AfterEach
    fun afterEach() {
        println("Setelah Unit Test\n")
    }

    @Test
    fun testAddSuccess() {
        "testAddSuccess".show()


        val result = calculator.add(10, 10)

        assertEquals(20, result, "Hasil harusnya 20")


    }


    @Disabled
    @Test
    fun testAddSuccess2() {


        val result = calculator.add(10, 10)

        // assertEquals(ekspetasi kita, result, pesan yang tampil jika test gagal)
        assertEquals(40, result, "Hasil harusnya 20")


    }

    @Test
    fun testAddFailed() {
        "testAddFailed".show()

        val result = calculator.add(10, 10)

        assertNotEquals(40, result)

    }

    @Test
    fun testDivideSuccess() {
        "testDivideSuccess".show()

        val result = calculator.divide(100, 10)
        assertEquals(10, result)

    }


    @Test
    fun testDivideFailed() {
        "testDivideFailed".show()

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