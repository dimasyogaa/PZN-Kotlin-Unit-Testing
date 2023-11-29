package com.yogadimas._16_test_berulang

import com.yogadimas._15_pewarisan_di_test._a_membuat_parent.ParentCalculatorTest
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import java.util.*


@DisplayName("_16_test_berulang - RandomCalculatorTest")
class RandomCalculatorTest : ParentCalculatorTest() {

    @Test
    fun testRandom (random: Random) {

        val first = random.nextInt(10)
        println("first : $first")

        val second = random.nextInt(10)
        println("second : $second")

        val result = calculator.add(first, second)
        println("result : $result")

        assertEquals(first + second, result)
    }


    /**
     * Test Berulang
     * ● JUnit mendukung eksekusi unit test berulang kali sesuai dengan jumlah yang kita tentukan
     * ● Untuk mengulang eksekusi unit test, kita bisa menggunakan annotation @RepeatedTest di function
     * unit test nya
     * ● @RepeatedTest juga bisa digunakan untuk mengubah detail nama test nya, dan kita bisa
     * menggunakan value {displayName} untuk mendapatkan display name, {currentRepetition} untuk
     * mendapatkan perulangan ke berapa saat ini, dan {totalRepetitions} untuk mendapatkan total
     * perulangan nya
     *
     * Informasi Perulangan
     * ● @RepeatedTest juga memiliki object RepetitionInfo yang di inject oleh class
     * RepetitionInfoParameterResolver, sehingga kita bisa mendapatkan informasi RepetitionInfo
     * melalui parameter function unit test
     */

    @DisplayName("Test calculator random")
    @RepeatedTest(
        value = 10,
        name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    fun testRandomRepeated(random: Random, repetitionInfo: RepetitionInfo, testInfo: TestInfo){

        println("${testInfo.displayName} ke ${repetitionInfo.currentRepetition} dari ${repetitionInfo.totalRepetitions}")

        val first = random.nextInt(10)
        println("first : $first")

        val second = random.nextInt(10)
        println("second : $second")

        val result = calculator.add(first, second)
        println("result : $result")

        assertEquals(first + second, result)
    }



}

















