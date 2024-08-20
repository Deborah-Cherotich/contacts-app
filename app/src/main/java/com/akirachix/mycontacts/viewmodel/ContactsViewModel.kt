package com.akirachix.mycontacts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akirachix.mycontacts.Model.Contact
import com.akirachix.mycontacts.Repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactsViewModel:ViewModel() {
    val contactsRepo = ContactsRepository()
    fun saveContact(contact: Contact){
        viewModelScope.launch {
            contactsRepo.saveContact(contact)
        }
    }
    fun getAllContacts():LiveData<List<Contact>>{
        return contactsRepo.getAllContacts()
    }

}