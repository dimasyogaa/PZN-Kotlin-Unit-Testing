package com.yogadimas._15_pewarisan_di_test._a_membuat_parent

import com.yogadimas._14_depedency_injection_di_test._a_membuat_parameter_resolver.RandomParameterResolver
import com.yogadimas.calculator.Calculator
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions

/**
 * Pewarisan di Test
 * ● JUnit mendukung pewarisan di test, artinya jika kita membuat class atau interface dan
 * menambahkan informasi test disitu, maka ketika kita membuat turunannya, secara otomatis semua
 * fitur test nya dimiliki oleh turunannya
 * ● Ini sangat cocok ketika kita misal contohnya sering membuat code sebelum dan setelah test yang
 * berulang-ulang, sehingga dibanding dibuat di semua test class, lebih baik dibuat sekali di parent
 * test class, dan test class tinggal menjadi child class dari parent test class
 */

@DisplayName("_15_pewarisan_di_test - membuat parent - ParentCalculatorTest")
@Extensions(
    value = [
        ExtendWith(RandomParameterResolver::class)
    ]
) // extensions otomatis juga bisa berfungsi di child class-nya
abstract class ParentCalculatorTest {

    val calculator = Calculator() // bisa berfungsi di child class-nya, sehingga tidak perlu di deklarasikan di child class nya

    @BeforeEach
    fun beforeEach() {
        println("Before each")
    }

    @AfterEach
    fun afterEach() {
        println("After each")
    }


}