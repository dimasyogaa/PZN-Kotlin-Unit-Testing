package com.yogadimas._9_menggunakan_tag

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

/**
 * Menggunakan Tag
 * ● Class atau function unit test bisa kita tambahkan tag (tanda) dengan menggunakan annotation
 * @Tag
 * ● Dengan menambahkan tag ke dalam unit test, kita bisa fleksibel ketika menjalan unit test, bisa
 * memilih tag mana yang mau di include atau di exclude
 * ● Jika kita menambahkan tag di class unit test, secara otomatis semua function unit test di dalam
 * class tersebut akan memiliki tag tersebut
 * ● Jika kita ingin menambahkan beberapa tag di satu class atau function unit test, kita bisa
 * menggunakan annotation @Tags
 * untuk include dan exclude berada di build.gradle.kts
 */

@Tag("integration-test")
@DisplayName("_9_menggunakan_tag - SampleIntegrationTest")
class SampleIntegrationTest {

    @Test
    fun testSample1(){
    }

    @Test
    fun testSample2(){
    }

}