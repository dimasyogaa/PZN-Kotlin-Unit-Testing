package com.yogadimas._8_test_berdasarkan_kondisinya

import org.junit.jupiter.api.*
import org.junit.jupiter.api.condition.*


/**
 * Test Berdasarkan Kondisi
 * ● Sebenarnya kita bisa menggunakan Assumptions untuk menjalankan unit test berdasarkan kondisi
 * tertentu
 * ● Namun JUnit menyediakan fitur yang lebih mudah untuk pengecekan beberapa kondisi, seperti
 * kondisi sistem operasi, versi java, system property atau environment variable
 * ● Ini lebih mudah dibandingkan menggunakan Assumptions
 */

@TestMethodOrder(value = MethodOrderer.OrderAnnotation::class)
@DisplayName("_8_test_berdasarkan_kondisi - ConditionalTest")
class ConditionalTest {


    /** Kondisi Sistem Operasi
    ● Untuk kondisi sistem operasi, kita bisa menggunakan beberapa annotation
    ● @EnabledOnOs digunakan untuk penanda bahwa unit test boleh berjalan di sistem operasi yang
    ditentukan
    ● @DisabledOnOs digunakan untuk penanda bahwa unit test tidak boleh berjalan di sistem operasi
    yang ditentukan
     */

    @Test
    @Order(1)
    @EnabledOnOs(value = [OS.WINDOWS])
    fun enabledOnWindows() {
        // hanya bisa berjalan di windows
    }

    @Test
    @Order(2)
    @EnabledOnOs(value = [OS.MAC])
    fun enabledOnMAC() {
        // hanya bisa berjalan di mac
    }


    @Test
    @Order(3)
    @EnabledOnOs(value = [OS.WINDOWS, OS.LINUX])
    fun enabledOnWindowsOrLinux() {
        // hanya bisa berjalan di windows atau linux
    }

    @Test
    @Order(4)
    @DisabledOnOs(value = [OS.WINDOWS])
    fun disabledOnWindows() {
        // hanya tidak bisa berjalan di windows
    }

    @Test
    @Disabled
    @Order(5)
    fun `=============================================================================`() {}

    /** Kondisi Versi Java
    ● Untuk kondisi versi Java yang kita gunakan, kita bisa menggunakan beberapa annotation
    ● @EnabledOnJre digunakan untuk penanda bahwa unit test boleh berjalan di Java versi tertentu
    ● @DisabledOnJre digunakan untuk penanda bahwa unit test tidak boleh berjalan di Java versi
    tertentu
    ● @EnabledForJreRange digunakan untuk penanda bahwa unit test boleh berjalan di range Java
    versi tertentu
    ● @DisabledForJreRange digunakan untuk penanda bahwa unit test tidak boleh berjalan di range
    Java versi tertentu
     */

    @Test
    @Order(6)
    @EnabledOnJre(value = [JRE.JAVA_8])
    fun onlyRunOnJava8() {

    }

    @Test
    @Order(7)
    @DisabledOnJre(value = [JRE.JAVA_8])
    fun disabledRunOnJava8() {

    }

    @Test
    @Order(8)
    @EnabledOnJre(value = [JRE.JAVA_14])
    fun onlyRunOnJava14() {

    }

    @Test
    @Order(9)
    @DisabledOnJre(value = [JRE.JAVA_14])
    fun disabledRunOnJava14() {

    }

    @Test
    @Order(10)
    @EnabledForJreRange(min =JRE.JAVA_8, max = JRE.JAVA_11)
    fun enabledRunOnJava8ToJava11() {

    }

    @Test
    @Order(11)
    @EnabledForJreRange(min =JRE.JAVA_11, max = JRE.JAVA_14)
    fun enabledRunOnJava11ToJava14() {

    }

    @Test
    @Order(12)
    @DisabledForJreRange(min =JRE.JAVA_11, max = JRE.JAVA_14)
    fun disabledRunOnJava11ToJava14() {

    }

    @Test
    @Disabled
    @Order(13)
    fun `============================================================================`() {}

    /** Kondisi System Property
    ● Untuk kondisi nilai dari system property, kita bisa menggunakan beberapa annotation
    ● @EnabledIfSystemProperty untuk penanda bahwa unit test boleh berjalan jika system property
    sesuai dengan yang ditentukan
    ● @DisabledIfSystemProperty untuk penanda bahwa unit test tidak boleh berjalan jika system
    property sesuai dengan yang ditentukan
    ● Jika kondisinya lebih dari satu, kita bisa menggunakan @EnabledIfSystemProperties dan
    @DisabledIfSystemProperties
     */


    @Test
    @Order(14)
    fun printSystemProperties() {
        System.getProperties().forEach { key, value ->
            println("$key => $value")
        }
    }

    @Test
    @Order(15)
    @EnabledIfSystemProperties(value = [
        EnabledIfSystemProperty(named = "java.vendor", matches = "Azul Systems, Inc.")
    ])
    fun enabledOnAzul() {

    }

    @Test
    @Order(16)
    @DisabledIfSystemProperties(value = [
        DisabledIfSystemProperty(named = "java.vendor", matches = "Azul Systems, Inc.")
    ])
    fun disabledOnAzul() {

    }

    @Test
    @Order(17)
    @DisabledIfSystemProperties(value = [
        DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    ])
    fun disabledOnOracle() {

    }

    @Test
    @Disabled
    @Order(18)
    fun `==============================================================================`() {}


    /** Kondisi Environment Variable
    ● Untuk kondisi nilai dari environment variable, kita bisa menggunakan beberapa annotation
    ● @EnabledIfEnvironmentVariable untuk penanda bahwa unit test boleh berjalan jika environment
    variable sesuai dengan yang ditentukan
    ● @DisabledIfEnvironmentVariable untuk penanda bahwa unit test tidak boleh berjalan jika
    environment variable sesuai dengan yang ditentukan
    ● Jika kondisinya lebih dari satu, kita bisa menggunakan @EnabledIfEnvironmentVariables dan
    @DisabledIfEnvironmentVariables
     */

    @Test
    @Order(19)
    @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    fun enabledOnDev(){

    }

    @Test
    @Order(20)
    @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    fun disabledOnDev(){

    }



}

