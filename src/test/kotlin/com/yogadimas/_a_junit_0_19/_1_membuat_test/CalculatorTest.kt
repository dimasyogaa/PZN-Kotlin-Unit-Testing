package com.yogadimas._a_junit_0_19._1_membuat_test

import com.yogadimas.calculator.Calculator
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("_1_membuat_test - CalculatorTest")
class CalculatorTest {

    val calculator = Calculator()

    @Test
    fun testAddSuccess () {

        val result = calculator.add(10,10)

    }

    @Test
    fun testAddSuccess2() {

        val result = calculator.add(10,10)

    }
    
}