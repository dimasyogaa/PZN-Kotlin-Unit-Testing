package com.yogadimas._14_depedency_injection_di_test._b_menggunakan_parameter_resolver

import com.yogadimas._14_depedency_injection_di_test._a_membuat_parameter_resolver.RandomParameterResolver
import com.yogadimas.calculator.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
import java.util.*


/**
 * Menggunakan Parameter Resolver
 * ● Untuk menggunakan parameter resolver yang sudah kita buat, kita bisa menggunakan annontation
 * @ExtendWith di test class
 * ● Jika lebih dari 1 parameter resolver, kita bisa menggunakan @Extentions
 */

/**
 * Kode : Membuat Random Parameter Resolver
 */

@DisplayName("_14_dependency_injection - menggunakan parameter resolver - RandomCalculatorTest")
@Extensions(
    value = [
        ExtendWith(RandomParameterResolver::class)
    ]
)
class RandomCalculatorTest {

    private val calculator = Calculator()

    // menggunakan dependency injection, sehingga cukup di parameternya
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

    /** Jika tanpa dependency injection, maka harus membuat object pada tiap test atau class
     *
     *     @Test
     *     fun testRandom () {
     *     val random = Random()
     *         val first = random.nextInt(10)
     *         println("first : $first")
     *         val second = random.nextInt(10)
     *         println("second : $second")
     *
     *         val result = calculator.add(first, second)
     *
     *         assertEquals(first + second, result)
     *     }
     */

}

















