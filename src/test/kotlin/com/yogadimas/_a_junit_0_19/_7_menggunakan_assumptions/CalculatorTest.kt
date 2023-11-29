package com.yogadimas._a_junit_0_19._7_menggunakan_assumptions

import com.yogadimas._a_junit_0_19._5_sebelum_setelah_test._helper.Helper.show
import com.yogadimas.calculator.Calculator
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assumptions.assumeFalse
import org.junit.jupiter.api.Assumptions.assumeTrue
import org.opentest4j.TestAbortedException



@DisplayName("_7_menggunakan_assumptions - CalculatorTest")
class CalculatorTest {

    val calculator = Calculator()

    companion object {

        @BeforeAll
        @JvmStatic // untuk memberi tahu bahwa kode ini akan dicompile menjadi java static function
        fun beforeAll() {
            println("Sebelum Semua Unit Test\n")
        }

        @AfterAll
        @JvmStatic
        fun afterAll() {
            println("Setelah Semua Unit Test\n")
        }

    }

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


    @Disabled("Sedang Diperbaiki")
    @Test
    fun testComingSoon() {
        // belum selesai
    }

    @Test
    fun testAborted() {

        /** gunakan edit configuration lalu set pada environment variables*/
        val me = System.getenv()["ME"]

        if ("YOGADIMAS" != me) {
            println("Test Aborted because me NOT YOGADIMAS")
            throw TestAbortedException()
        }

        println("Test Not Aborted because me = YOGADIMAS")

    }


    /**
     * Menggunakan Assumptions
     * ● Sebelumnya kita sudah tahu jika ingin membatalkan test, kita bisa menggunakan exception
     * TestAbortedException
     * ● Namun sebenarnya ada cara yang lebih mudah, yaitu dengan menggunakan Assumptions
     * ● Penggunaan Assumptions mirip seperti Assertions, jika nilainya tidak sama, maka function
     * Assumptions akan thrown TestAbortedException, sehingga secara otomatis akan membatalkan
     * unit test yang sedang berjalan
     * ● https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assumptions.html
     */

    @Test
    fun `assumptions - MustBeSuccess`() {

        // assumeTrue(harus bernilai true)
        // jika false -> return throw TestAbortedException
        assumeTrue("DEV" == System.getenv()["PROFILE"])

        println("Test Not Aborted because PROFILE = DEV")

    }

    @Test
    fun `assumptions - MustBeSuccess - But Failed`() {

        assumeTrue("DEV" == System.getenv()["O"])

        println("Test Not Aborted because O = DEV")

    }

    @Test
    fun `assumptions - MustBeFailed`() {

        // assumeFalse(harus bernilai false)
        // jika true -> return throw TestAbortedException
        assumeFalse("DEV" == System.getenv()["O"])

        println("Test Not Aborted because O NOT DEV")

    }
}