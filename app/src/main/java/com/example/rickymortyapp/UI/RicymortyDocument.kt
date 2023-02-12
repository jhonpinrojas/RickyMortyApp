package com.example.rickymortyapp.UI

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.rickymortyapp.databinding.ActivityMainBinding
import com.example.rickymortyapp.databinding.ActivityRicymortyDocumentBinding
import com.example.rickymortyapp.viewmodel.Rickymortyviewmodel

class RicymortyDocument : AppCompatActivity() {
    //private lateinit var viewModel: Rickymortyviewmodel
    private lateinit var binding: ActivityRicymortyDocumentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityRicymortyDocumentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //viewModel = ViewModelProvider(this).get(Rickymortyviewmodel::class.java)
        initUI()
    }

    private fun initUI() {
        //val id = intent.extras?.get("id")
        val name= intent.extras?.get("name") as String
        val Status=intent.extras?.get("status") as String
        val Origen =intent.extras?.get("origen") as String
        val Gender=intent.extras?.get("gender") as String
        val Location =intent.extras?.get("location") as String
        val Created =intent.extras?.get("created") as String
        binding.tvNombre.text = "Name: ${name}"
        binding.tvStatus.text = "Status: ${Status}"
        binding.tvOrigen.text = "Origen: ${Origen}"
        binding.tvGender.text = "Gender: ${Gender}"
        binding.tvLocation.text = "Location: ${Location}"
        binding.tvCreate.text = "Created: ${Created}"
        val URL = intent.extras?.get("img") as String
        Glide.with(this).load(URL).into(binding.iVCharacter)

    }

}