package com.yogadimas._11_siklus_hidup_test

import org.junit.jupiter.api.*

/**
 * Urutan Eksekusi Test
 * ● Secara default, urutan eksekusi unit test tidak ditentukan, jadi jangan berharap jika sebuah
 * function berada diatas function lainnya, maka akan dijalankan lebih dulu
 * ● Hal ini karena memang sebaiknya function unit test itu harus independen, tidak saling
 * ketergantungan
 * ● Secara default pun, object class unit test akan selalu dibuat ulang tiap function, jadi jangan
 * berharap kita bisa menyimpan data di variable untuk digunakan di unit test function selanjutnya
 */


/**
 * Siklus Hidup Test
 * ● Secara default, lifecycle (siklus hidup) object test adalah independent per function test, artinya
 * object unit test akan selalu dibuat baru per function unit test, oleh karena itu kita tidak bisa
 * bergantung dengan function test lain
 * ● Cara pembuatan object test di JUnit ditentukan oleh annotation @TestInstance, dimana defaultnya
 * adalah Lifecycle.PER_METHOD, artinya tiap function akan dibuat sebuah instance / object baru
 * ● Kita bisa merubahnya menjado Lifecycle.PER_CLASS jika mau, dengan demikian instance / object
 * test haya dibuat sekali per class, dan function test akan menggunakan object test yang sama
 * ● Hal ini bisa kita manfaatkan ketika membuat test yang tergantung dengan test lain
 *
 * PER_CLASS : membuat object pada tiap class test
 * PER_METHOD : membuat object pada tiap function test
 */

@DisplayName("_11_siklus_hidup_test - OrderTest")
@TestMethodOrder(value = MethodOrderer.OrderAnnotation::class)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class OrderTest {

    var counter: Int = 0

    /**
     * Keuntungan Instance Per Class
     * ● Salah satu keuntungan saat menggunakan Lifecycle.PER_CLASS adalah, kita bisa menggunakan
     * @BeforeAll dan @AfterAll di function biasa, tidak harus menggunakan function object / static
     */

    @BeforeAll
    fun beforeAll(){

    }

    @AfterAll
    fun afterAll(){

    }

    @Test
    @Order(3)
    fun testA(){
        counter++
        println(counter)
        println(this.hashCode())
    }

    @Test
    @Order(1)
    fun testC(){
        counter++
        println(counter)
        println(this.hashCode())
    }

    @Test
    @Order(2)
    fun testB(){
        counter++
        println(counter)
        println(this.hashCode())
    }
}