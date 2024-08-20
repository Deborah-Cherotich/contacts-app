package com.akirachix.mycontacts.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.akirachix.mycontacts.Model.Contact
import com.akirachix.mycontacts.R
import com.akirachix.mycontacts.databinding.ActivityMainBinding
import com.akirachix.mycontacts.viewmodel.ContactsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    val contactsViewModel:ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)


    }

    override fun onResume() {
        super.onResume()
        binding.floatingActionButton.setOnClickListener{startActivity(Intent(this, AddContactActivity::class.java))}
        contactsViewModel.getAllContacts().observe(this){contactsList->
            displayContacts(contactsList)

        }
        binding

    }
    fun displayContacts(contactsList: List<Contact>){
val contactAdapter = ContactsAdapter(contactsList, this)
        binding.rvContacts.adapter = contactAdapter

    }
}