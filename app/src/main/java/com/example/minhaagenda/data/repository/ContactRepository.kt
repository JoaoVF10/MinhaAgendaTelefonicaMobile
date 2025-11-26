package com.example.minhaagenda.data.repository

import com.example.minhaagenda.data.model.Contact

class ContactRepository {
    private val list = mutableListOf<Contact>()
    fun getAll(): List<Contact> = list
    fun add(contact: Contact) = list.add(contact)
    fun delete(contact: Contact) = list.remove(contact)
}
