package com.akirachix.mycontacts.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.akirachix.mycontacts.Model.Contact
import com.akirachix.mycontacts.R
import com.akirachix.mycontacts.databinding.ActivityAddContactBinding
import com.akirachix.mycontacts.databinding.ContactListItemBinding
import com.akirachix.mycontacts.viewmodel.ContactsViewModel

class ContactsAdapter(var contactsList: List<Contact>, val context: Context):RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val binding = ContactListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)



        return  ContactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
       val contact = contactsList[position]
        holder.binding.tvName.text = contact.name
        holder.binding.tvPhoneNumber.text = contact.phoneNumber
        holder.binding.tvEmail.text = contact.email
        holder.binding.cvContact.setOnClickListener(){
            val intent = Intent(context,ViewContactActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }
}
class ContactsViewHolder(var binding: ContactListItemBinding):
    RecyclerView.ViewHolder(binding.root)


class AddContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddContactBinding
    val contactsViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()
        binding.btnSave.setOnClickListener {
            validateContact()
        }

    }
    fun validateContact(){
        val name = binding. etName.text.toString()
        val phone = binding. etPhoneNumber.text.toString()
        val email = binding.etEmail.text.toString()
        var error = false
if (name.isBlank()){
    error = true
    binding.etName.error = getString(R.string.name_is_required)
}

if (phone.isBlank()){
    error = true
    binding.etPhoneNumber.error = getString(R.string.phone_is_required)
}

        if (email.isBlank()) {
         error = true
    binding.etEmail.error = getString(R.string.email)
       }

        if (!error){


            val newContact =
                Contact(contactId = 0, name = name, email = email, phoneNumber = phone, avatar = "")
            contactsViewModel.saveContact(newContact)
        }

    }
}