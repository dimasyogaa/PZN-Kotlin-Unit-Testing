package com.yogadimas._15_pewarisan_di_test._b_membuat_child

import com.yogadimas._15_pewarisan_di_test._a_membuat_parent.ParentCalculatorTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*

@DisplayName("_15_pewarisan_di_test - membuat child - RandomCalculatorTest")
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


}

















