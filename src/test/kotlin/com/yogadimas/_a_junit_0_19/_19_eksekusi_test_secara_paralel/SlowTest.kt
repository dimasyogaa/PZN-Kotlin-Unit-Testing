package com.yogadimas._a_junit_0_19._19_eksekusi_test_secara_paralel

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import java.util.concurrent.TimeUnit


/**
 * Eksekusi Test Secara Paralel
 * ● Secara default, JUnit tidak mendukung eksekusi unit test secara paralel, artinya unit test akan
 * dijalankan secara sequential satu per satu
 * ● Namun kadang ada kasus kita ingin mempercepat proses unit test sehingga dijalankan secara
 * paralel, hal ini bisa kita lakukan di JUnit, namun perlu beberapa langkah
 * ● Tapi ingat, pastikan unit test kita aman ketika dijalankan secara paralel
 * // race condiciton : satu function mengubah value function lainnya
 *
 * Menambah Konfigurasi Paralel
 * ● Hal pertama yang perlu kita lakukan adalah membuat file junit-platform.properties di resource
 * ● Lalu menambah value :
 * ○ junit.jupiter.execution.parallel.enabled = true
 *
 * Menggunakan @Execution
 * ● Walaupun sudah mengaktifkan fitur paralel, tapi bukan berarti secara otomatis semua unit test
 * berjalan paralel, agar unit test berjalan paralel, kita perlu menggunakan annotation @Execution
 * ● Lalu memilih jenis execution nya, misal untuk paralel bisa menggunakan
 * ExecutionMode.CONCURRENT
 */


@DisplayName("_19_eksekusi_test_secara_paralel - SlowTest")
@Execution(ExecutionMode.CONCURRENT)
class SlowTest {


    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun testSlow1(){
        Thread.sleep(3000) // 3 detik
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun testSlow2(){
        Thread.sleep(3000)
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun testSlow3(){
        Thread.sleep(3000)
    }

}