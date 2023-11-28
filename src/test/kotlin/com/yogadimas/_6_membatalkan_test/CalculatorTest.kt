package com.yogadimas._6_membatalkan_test

import com.yogadimas._5_sebelum_setelah_test._helper.Helper.show
import com.yogadimas.calculator.Calculator
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.opentest4j.TestAbortedException

@DisplayName("_6_membatalkan_test - CalculatorTest")
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


        /**
         * buka terminal windows (cmd) dengan  run as administrator
         *
         * untuk set variabel env
         * setx PROFILESAYA "DEV"
         *
         * untuk menghapus variabel env
         * set PROFILESAYA=
         *
         * close dulu intelij idea, setelah itu buka kembali, jalankan unit test kembali
         *
         */


        /* val profile = System.getenv("PROFILESAYA")

        if ("DEV" != profile) throw TestAbortedException()

        println("Test Not Aborted because Dev Profile") */



        /** atau bisa gunakan edit configuration lalu set pada environment variables*/
        val me = System.getenv()["ME"]

        if ("YOGADIMAS" != me) {
            println("Test Aborted because me NOT YOGADIMAS")
            throw TestAbortedException()
        }

        println("Test Not Aborted because me = YOGADIMAS")


        /**
         *  jika tidak mau ribet, pengkondisiannya gunakan tipe data primitif
         */

        /* val x = 0

        if (1 != x) {
            println("Test Aborted because x != 1")
            throw TestAbortedException()
        }

        println("Test Not Aborted because x = 1") */








    }
}