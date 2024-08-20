package com.akirachix.mycontacts.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.akirachix.mycontacts.R
import com.akirachix.mycontacts.databinding.ActivityAddContactBinding
import com.akirachix.mycontacts.databinding.ActivityViewContactBinding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding:ActivityViewContactBinding
    var contactId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.extras!=null){
            contactId = intent.getIntExtra("CONTACT_ID", 0)
        }
        else{
            finish()
        }


    }
}