package com.yogadimas._13_informasi_test

import org.junit.jupiter.api.*

/**
 * Informasi Test
 * ● Walaupun mungkin jarang kita gunakan, tapi kita juga bisa mendapatkan informasi test yang
 * sedang berjalan menggunakan interface TestInfo
 * ● Kita bisa menambahkan TestInfo sebagai parameter di function unit test
 */

@DisplayName("_13_informasi_test - InformationTest")
class InformationTest {

    @Test
    @Tags(value = [
        Tag("contoh1"),
        Tag("contoh2")
    ])

    @DisplayName("sample test one")
    fun sampleTest(testInfo: TestInfo){
        println("displayName : ${testInfo.displayName}")
        println("tags : ${testInfo.tags}")
        println("testClass : ${testInfo.testClass}")
        println("testMethod : ${testInfo.testMethod}")
    }

}