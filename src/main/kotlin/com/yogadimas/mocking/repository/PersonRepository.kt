package com.yogadimas.mocking.repository

import com.yogadimas.mocking.model.Person

// anggap saja kontrak untuk integrasi ke database
interface PersonRepository {

    fun selectById(id: String): Person

}