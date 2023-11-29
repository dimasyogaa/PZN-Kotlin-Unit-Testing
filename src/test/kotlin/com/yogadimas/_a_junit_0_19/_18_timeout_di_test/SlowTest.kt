package com.yogadimas._a_junit_0_19._18_timeout_di_test

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.util.concurrent.TimeUnit


@DisplayName("_18_timeout_di_test - SlowTest")
class SlowTest {

    /**
     * Timeout di Test
     * ● Kadang kita ingin memastikan bahwa sebuah unit test berjalan tidak lebih dari sekian detik
     * ● Misal ketika kasus kita ingin memastikan kode program kita mempunyai performa bagus dan cepat
     * ● JUnit memiliki fitur timeout, yaitu memastikan bahwa unit test berjalan tidak lebih dari waktu yang
     * ditentukan, jika melebihi waktu yang ditentukan, secara otomatis unit test tersebut akan gagal
     * ● Kita bisa menggunakan annotation @Timeout untuk melakukan hal tersebut
     */
    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun testSlow1(){
        // Thread.sleep(10000) // 10 detik // gagal, karena unit test hanya mau menunggu 5 detik
        Thread.sleep(3000) // 3 detik
    }


}