package com.example.barbershop

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.barbershop.databinding.ActivityCitaBinding
import com.example.barbershop.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("Servicios")



        binding.cardView.setOnClickListener {
            Toast.makeText(this, ""+binding.welcome.text.toString() , Toast.LENGTH_SHORT).show()
            myRef.child("Barba").setValue("Corte de Barba")

            val intent = Intent(this, CitaActivity::class.java)
            startActivity(intent)


        }

    }


}