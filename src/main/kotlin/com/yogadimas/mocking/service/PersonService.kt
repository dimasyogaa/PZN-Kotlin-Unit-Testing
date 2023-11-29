package com.yogadimas.mocking.service

import com.yogadimas.mocking.model.Person
import com.yogadimas.mocking.repository.PersonRepository

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
}