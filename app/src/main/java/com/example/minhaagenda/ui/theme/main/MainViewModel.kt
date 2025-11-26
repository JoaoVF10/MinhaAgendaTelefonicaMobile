package com.example.minhaagenda.ui.theme.main



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.minhaagenda.data.model.Contact
import com.example.minhaagenda.data.repository.ContactRepository

class MainViewModel : ViewModel() {

    private val repo = ContactRepository()

    private val _contacts = MutableLiveData<List<Contact>>(emptyList())
    val contacts: LiveData<List<Contact>> get() = _contacts

    fun addContact(name: String, phone: String) {
        repo.add(Contact(name = name, phone = phone))
        _contacts.value = repo.getAll()
    }

    fun deleteContact(contact: Contact) {
        repo.delete(contact)
        _contacts.value = repo.getAll()
    }
}
