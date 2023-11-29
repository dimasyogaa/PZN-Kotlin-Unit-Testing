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

















