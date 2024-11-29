package com.example.examen_skjdafkas_skdfkhjas_klsadfhasj_kjsldfh_pm

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class AniadirPokemon : AppCompatActivity() {

    lateinit var imagenAtras : ImageView
    lateinit var nombretiet : TextInputEditText
    lateinit var entrenadortiet : TextInputEditText
    lateinit var spinnertiet: Spinner
    lateinit var estaturatiet : TextInputEditText
    lateinit var comentariostiet : TextInputEditText
    lateinit var fechatiet : TextInputEditText
    lateinit var boton : FloatingActionButton

    var atras = Intent(this, Menu::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_aniadir_pokemon)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imagenAtras = findViewById(R.id.imageView)
        imagenAtras.setOnClickListener {
            startActivity(atras)
        }

        nombretiet = findViewById(R.id.nombre)
        entrenadortiet = findViewById(R.id.entrenador)
        spinnertiet = findViewById(R.id.spinner)
        estaturatiet = findViewById(R.id.estatura)
        comentariostiet = findViewById(R.id.comentarios)
        fechatiet = findViewById(R.id.fecha)
        boton = findViewById(R.id.botonflotante)

        val pokemonElements = listOf("agua", "fuego", "planta", "electrico", "veneno", "psiquico", "lucha", "normal", "volador", "roca")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, pokemonElements)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnertiet.adapter = adapter

        fechatiet.setOnClickListener {
            val builder = MaterialDatePicker.Builder.datePicker()
            val picker = builder.build()

            picker.addOnPositiveButtonClickListener {
                fechatiet.setText(picker.headerText)
            }

            picker.show(supportFragmentManager, "Fecha atrapada")
        }

        boton.setOnClickListener {

            var comprobarNombre = comprobarNombre(nombretiet.text.toString())
            var comprobarEntrenador = comprobarEntrenador(nombretiet.text.toString())

            var comprobarEstatura = true
            try {
                var a = estaturatiet.text.toString().toInt()
            }catch (e: NumberFormatException){
                comprobarEstatura = false
            }

            var comprobarFecha = comprobarFecha(nombretiet.text.toString())

            if (comprobarNombre && comprobarEntrenador && comprobarEstatura && comprobarFecha){

                val lista : List<String> = listOf(nombretiet.text.toString(),
                    entrenadortiet.text.toString(),
                    spinnertiet.selectedItem.toString(),
                    estaturatiet.text.toString(),
                    comentariostiet.text.toString(),
                    fechatiet.text.toString()
                )

                intent.putStringArrayListExtra("lista", lista as ArrayList<String>)
            }

        }
    }

    fun comprobarNombre(n : String) : Boolean{

        val nombre = n

        return nombre[0].isLowerCase() || nombre.length < 3

    }
    fun errorNombre(){
        val nombre = nombretiet.text.toString()

        if (comprobarNombre(nombre)){
            nombretiet.error = "Nombre no valido"
        }else{
            nombretiet.error = null
        }
    }

    fun comprobarEntrenador(n : String) : Boolean{

        val entrenador = n

        var hayVocal = false
        for(it in n){
            if (it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u'){
                hayVocal = true
                break
            }
        }

        if (!hayVocal) return false

        return entrenador.length <= 25

    }
    fun errorEnternador(){
        val entrenador = entrenadortiet.text.toString()

        if (comprobarEntrenador(entrenador)){
            nombretiet.error = "Entrenador no valido"
        }else{
            nombretiet.error = null
        }
    }

    fun errorEstatura(){

        var estaturaInt = true

        try {
            val nombreInt = estaturatiet.text.toString().toInt()
        } catch (e: NumberFormatException) {
            estaturaInt = false
        }

        if (estaturaInt){
            nombretiet.error = "Estatura no valida"
        }else{
            nombretiet.error = null
        }
    }

    fun comprobarFecha(n : String) : Boolean{

        val entrenador = n

        var hayVocal = false
        for(it in n){
            if (it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u'){
                hayVocal = true
                break
            }
        }

        if (!hayVocal) return false

        return entrenador.length <= 25

    }
    fun errorFecha(){
        val entrenador = entrenadortiet.text.toString()

        if (comprobarEntrenador(entrenador)){
            nombretiet.error = "Entrenador no valido"
        }else{
            nombretiet.error = null
        }
    }
}