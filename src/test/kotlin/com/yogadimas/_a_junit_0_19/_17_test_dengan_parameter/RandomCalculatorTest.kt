package com.yogadimas._a_junit_0_19._17_test_dengan_parameter

import com.yogadimas._a_junit_0_19._15_pewarisan_di_test._a_membuat_parent.ParentCalculatorTest
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.*
import java.util.*
import java.util.stream.Stream


@DisplayName("_17_test_dengan_parameter - RandomCalculatorTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class RandomCalculatorTest : ParentCalculatorTest() {

    @Test
    @Disabled
    fun testRandom (random: Random) {

        val first = random.nextInt(10)
        println("first : $first")

        val second = random.nextInt(10)
        println("second : $second")

        val result = calculator.add(first, second)
        println("result : $result")

        assertEquals(first + second, result)
    }

    @Disabled
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

    /**
     * Test dengan Parameter
     * ● Sebelumnya kita sudah tau jika ingin menambahkan parameter di function unit test, maka kita
     * perlu membuat ParameterResolver
     * ● Namun jika terlalu banyak membuat ParameterResolver juga agak menyulitkan kita
     * ● JUnit memiliki fitur yang bernama @ParameterizedTest, dimana jenis unit test ini memang khusus
     * dibuat agar dapat menerima parameter
     * ● Yang perlu kita lakukan adalah dengan mengganti @Test menjadi @ParameterizedTest
     *
     * Sumber Parameter
     * @ParameterizedTest mendukung beberapa sumber parameter, yaitu
     * ● @ValueSource, untuk sumber Number, Char, Boolean dan String
     * ● @EnumSource, untuk sumber berupa enum
     * ● @MethodSource, untuk sumber dari function object (static)
     * ● @CsvSource, untuk sumber beruba data CSV
     * ● @CsvFileSource, untuk sumber beruba file CSV
     * ● @ArgumentSource, untuk data dari class ArgumentProvider
     */

    // Value Source
    @Order(1)
    @DisplayName("Test Calculator with parameter")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @ValueSource(ints = [10, 20, 30, 40, 50])
    fun testWithParameter(value: Int) {
        val result = calculator.add(value, value)
        assertEquals(value + value, result)
        println(result)
    }

    // Method Source
    companion object {

        @JvmStatic // agar dianggap static function oleh junit di jvm
        fun parameterSource(): List<Int> {
            return listOf(100, 200, 300, 400, 500)
        }

    }

    @Order(2)
    @ParameterizedTest
    @MethodSource(value = ["parameterSource"])
    fun testWithMethodSource(value: Int){
        val result = calculator.add(value, value)
        assertEquals(value + value, result)
        println(result)
    }

    // Enum Source
    enum class Weekday { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY }

    @Order(3)
    @ParameterizedTest
    @EnumSource(Weekday::class)
    fun testWithEnumSource(day: Weekday) {
        // Implement your test using the 'day' parameter, representing different weekdays
    }


    // CSV Source
    @Order(4)
    @ParameterizedTest
    @CsvSource(
        "1, 2, 3",
        "4, 5, 9",
        "7, 8, 15"
    )
    fun testWithCsvSource(a: Int, b: Int, sum: Int) {
        val result = calculator.add(a, b)
        assertEquals(sum, result)
        println(result)
    }

    // CSV File Source
    @Order(5)
    @ParameterizedTest
    @CsvFileSource(resources = ["/testWithCsvFileSource.csv"])
    fun testWithCsvFileSource(a: Int, b: Int, sum: Int) {
        val result = calculator.add(a, b)
        assertEquals(sum, result)
        println(result)
    }

    // Argument Source
    class MyArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(4, 5, 9),
                Arguments.of(7, 8, 15)
            )
        }
    }

    @Order(6)
    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider::class)
    fun testWithArgumentProvider(a: Int, b: Int, sum: Int) {
        val result = calculator.add(a, b)
        assertEquals(sum, result)
        println(result)
    }




}

















