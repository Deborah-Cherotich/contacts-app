package com.akirachix.mycontacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.akirachix.mycontacts.databinding.ActivityMainBinding
import com.akirachix.mycontacts.databinding.ContactListItemBinding

class ContactsAdapter(var contactsList: List<Contact>):RecyclerView.Adapter<ContactsViewHolder>() {
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
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }
}
class ContactsViewHolder(var binding: ContactListItemBinding):
    RecyclerView.ViewHolder(binding.root)


