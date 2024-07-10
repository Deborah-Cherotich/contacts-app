package com.akirachix.mycontacts

import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.akirachix.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.rvContacts.LayoutManager = linearLayoutManager(this)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        displayContacts()

    }
    fun displayContacts(){
        val contact1 = Contact("Debbie","0700870092","cherotich@gmail.com","")
        val contact2 = Contact("Zeddie","0700870092","cherotich@gmail.com","")

        val contact3 = Contact("Jaycob","0700870092","cherotich@gmail.com","")

        val contact4 = Contact("Trevor","0700870092","cherotich@gmail.com","")
        val contact5 = Contact("Joe","0700870092","cherotich@gmail.com","")

        val contact6 = Contact("Jane","0700870092","cherotich@gmail.com","")

        val contact7 = Contact("Mike","0700870092","cherotich@gmail.com","")

        val contact8 = Contact("Ivan","0700870092","cherotich@gmail.com","")

        val contact9 = Contact("Laura","0700870092","cherotich@gmail.com","")

        val contact10 = Contact("Keith","0700870092","cherotich@gmail.com","")
        val contactList = listOf(contact1,contact2,contact3,contact4,contact5,contact6,contact7,contact8,contact9,contact10)
        val contactsAdapter = ContactsAdapter(contactList)
        binding.rvContacts.adapter = contactsAdapter

    }
}