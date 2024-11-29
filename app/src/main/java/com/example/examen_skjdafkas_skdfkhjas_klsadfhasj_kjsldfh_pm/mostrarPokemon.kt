package com.example.examen_skjdafkas_skdfkhjas_klsadfhasj_kjsldfh_pm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class mostrarPokemon : AppCompatActivity() {

    lateinit var botonAtras : ImageView
    lateinit var sv : ScrollView
    lateinit var cl : ConstraintLayout

    var atras = Intent(this, Menu::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mostrar_pokemon)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        botonAtras = findViewById(R.id.botonatras)
        botonAtras.setOnClickListener {
            startActivity(atras)
        }
        sv = findViewById(R.id.sv)
        cl = findViewById(R.id.cl)

        var lista = intent.getStringArrayListExtra("lista")

        if (lista != null) {
            for (it in lista) {
                val textView = TextView(this)
                textView.text = it
                cl.addView(textView)
            }
        }

        cl.requestLayout()
        sv.fullScroll(View.FOCUS_DOWN)
    }


}