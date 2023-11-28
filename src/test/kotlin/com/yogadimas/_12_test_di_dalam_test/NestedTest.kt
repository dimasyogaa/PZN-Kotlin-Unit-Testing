package com.yogadimas._12_test_di_dalam_test

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * Test di dalam Test
 * ● Saat membuat unit test, ada baiknya ukuran test class nya tidak terlalu besar, karena akan sulit di
 * baca dan dimengerti.
 * ● Jika test class sudah semakin besar, ada baiknya kita pecah menjadi beberapa test class, lalu kita
 * grouping sesuai dengan jenis function test nya.
 * ● JUnit mendukun pembuatan class test di dalam class test, jadi kita bisa memecah sebuah class test,
 * tanpa harus membuat class di file berbeda, kita bisa cukup menggunakan inner class
 * ● Untuk memberi tahu bahwa inner class tersebut adalah test class, kita bisa menggunakan
 * annotation @Nested
 */


@DisplayName("_12_test_di_dalam_test - NestedTest")
class NestedTest {

    @Test
    fun test1(){

    }

    @Nested
    @DisplayName("inner class MyNestedTest")
    inner class MyNestedTest {

        @Test
        fun test1(){

        }

    }

}