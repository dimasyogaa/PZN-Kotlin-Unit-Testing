package com.yogadimas._b_mocking_20_22._20_pengenalan_mocking

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito

@DisplayName("_20_pengenalan_mocking - MockTest")
class MockTest {

    @Test
    fun testMock() {

        /* 1
            kita biasa nya membuat object seperti ini, tapi
            kita tidak ingin membuat objek seperti ini
        */
        val list0: List<String> = listOf("Yoga", "Dimas")

        /* 2. Membuat Mock - Mockito.mock()
            kita pengennya membuat object tiruannya
         */
        val list = Mockito.mock(List::class.java) as List<String>

        // 3. ini hasilnya null karena belum diberi behaviour
        println(list.get(0))  // get(0)-nya, dipanggil ke-1 kalinya
        println(list.get(1))  // get(1)-nya, dipanggil ke-1 kalinya

        println("------------")

        // 4. maka, beri behaviour pada object Mocknya
        Mockito.`when`(list.get(0)).thenReturn("Yoga")
        Mockito.`when`(list.get(1)).thenReturn("Dimas")

        // hasilnya
        println(list.get(0)) // Yoga // get(0)-nya, dipanggil ke-2 kalinya
        println(list.get(1)) // Dimas // get(1)-nya, dipanggil ke-2 kalinya

        // test mock
        assertEquals("Yoga", list.get(0)) // get(0)-nya, dipanggil ke-3 kalinya
        assertEquals("Dimas", list.get(1))  // get(1)-nya, dipanggil ke-3 kalinya

        // verify mock : memverifikasi bahwa object mock ini pernah dipanggil dan berapa kali dipanggilnya
        // secara default Mockito.times(1), artinya memverifikasi kalo dipanggil hanya satu kali
        // jika tidak sesuai dengan berapa kalinya dipanggil, maka akan terjadi error
        // jika tidak pernah dipanggil juga akan terjadi error


        // memverifikasi bahwa object mock list pernah dipanggil method get(0)-nya, 1 kali
        // Mockito.verify(list).get(0)

        // memverifikasi bahwa object mock list pernah dipanggil method get(0)-nya, 3 kali
        Mockito.verify(list, Mockito.times(3)).get(0)

        // memverifikasi bahwa object mock list pernah dipanggil method get(1)-nya, 3 kali
        Mockito.verify(list, Mockito.times(3)).get(1)


    }

}