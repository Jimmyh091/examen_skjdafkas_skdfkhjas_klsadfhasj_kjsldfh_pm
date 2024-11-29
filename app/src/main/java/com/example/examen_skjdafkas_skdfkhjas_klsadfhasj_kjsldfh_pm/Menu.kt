package com.example.examen_skjdafkas_skdfkhjas_klsadfhasj_kjsldfh_pm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu : AppCompatActivity() {

    lateinit var boton1 : Button
    lateinit var boton2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        boton1 = findViewById(R.id.button1)
        boton2 = findViewById(R.id.button2)

        boton1.setOnClickListener {
            var intentAniadirPokemon = Intent(this, AniadirPokemon::class.java)
            startActivity(intentAniadirPokemon)
        }

        boton2.setOnClickListener {
            var intentMostrarPokemon = Intent(this, mostrarPokemon::class.java)
            startActivity(intentMostrarPokemon)
        }

    }
}