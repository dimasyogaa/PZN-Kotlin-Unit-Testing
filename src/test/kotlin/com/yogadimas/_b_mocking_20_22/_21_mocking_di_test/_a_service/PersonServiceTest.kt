package com.yogadimas._b_mocking_20_22._21_mocking_di_test._a_service

import com.yogadimas.mocking.model.Person
import com.yogadimas.mocking.repository.PersonRepository
import com.yogadimas.mocking.service.PersonService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class PersonServiceTest {

    lateinit var personService: PersonService

    // buat mock
    @Mock
    lateinit var personRepository: PersonRepository

    @BeforeEach
    fun beforeEach() {
        personService = PersonService(personRepository)
    }

    @Test
    fun testPersonIdIsNotValid(){
        // harus throw exception, jika tidak throw => error/gagal
        assertThrows<IllegalArgumentException> {
            // kita isi method get dengan blank, sehingga harapan kita harus throw exception
            personService.get("      ")
        }
    }

    @Test
    fun testPersonNotFound(){
        assertThrows<Exception> {
            personService.get("not found")
        }
    }

    @Test
    fun testGetPersonSuccess(){

        // beri behaviour
        Mockito.`when`(personRepository.selectById("yoga")).thenReturn(Person("yoga", "Yoga Dimas"))

        val person = personService.get("yoga");

        // test mock
        assertEquals("yoga", person.id)
        assertEquals("Yoga Dimas", person.name)
    }

}