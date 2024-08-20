package com.akirachix.mycontacts.Model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "contacts", indices = [Index(value = arrayOf("phoneNumber"), unique = true)])
data class Contact(
    @PrimaryKey(autoGenerate = true) var contactId:Int,
    var name: String,
    var phoneNumber: String,
    var email: String,
    var avatar: String
)
