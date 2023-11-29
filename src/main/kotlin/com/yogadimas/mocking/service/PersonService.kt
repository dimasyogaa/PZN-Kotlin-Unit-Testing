package com.yogadimas.mocking.service

import com.yogadimas.mocking.model.Person
import com.yogadimas.mocking.repository.PersonRepository
import java.util.*

// tempat menyimpan business logic
class PersonService(private val personRepository: PersonRepository) {


    fun get(id:String) : Person {

        // untuk validasi id
        if(id.isBlank()) {
            throw IllegalArgumentException("Person id is not valid")
        }

        // simpan ke database
        val person = personRepository.selectById(id)
        if (person != null) {
            return person
        } else {
            throw Exception("Person not found")
        }

    }

    fun register(name: String): Person {

        if (name.isBlank()) {
            throw IllegalArgumentException("Person name is blank")
        }

        // buat id random
        val id = UUID.randomUUID().toString()

        val person = Person(id, name)

        // menyimpan ke database
        personRepository.insert(person) // ini harus diverifikasi di unit test karena tidak mengembalikan nilai dan pastikan berapa kali kode ini dipanggil

        // mengembalikan objek Person
        return person

    }
}