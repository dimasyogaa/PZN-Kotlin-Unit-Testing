package com.yogadimas._a_junit_0_19._14_depedency_injection_di_test._a_membuat_parameter_resolver

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver
import java.util.*

/**
 * Dependency Injection di Test
 * ● Tidak ada magic di JUnit, sebenarnya fitur TestInfo yang sebelumnya kita bahas adalah bagian dari
 * dependency injection di JUnit
 * ● Dependency Injection sederhananya adalah bagaimana kita bisa memasukkan dependency
 * (object/instance) ke dalam unit test secara otomatis tanpa proses manual
 * ● Saat kita menambah parameter di function unit test, sebenarnya kita bisa secara otomatis
 * memasukkan parameter tersebut dengan bantuan ParameterResolver
 * ● Contohnya TestInfo yang kita bahas sebelumya, sebenarnya objectnya dibuat oleh
 * TestInfoParameterResolver
 */

/**
 * Kode : Membuat Random Parameter Resolver
 */
class RandomParameterResolver: ParameterResolver {

    private val random: Random = Random()

    // jika parameternya memiliki tipe data class Random
    override fun supportsParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext): Boolean {
        return parameterContext.parameter.type == Random::class.java
    }

    // maka kembalikan nilai dari object Random()
    override fun resolveParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext): Any {
       return random
    }
}