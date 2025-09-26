package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PreferenciasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferencias)

        val nombre = intent.getStringExtra("nombre") ?: "Usuario"
        val edad = intent.getIntExtra("edad", 0)

        val tvBienvenida = findViewById<TextView>(R.id.tvBienvenida)
        val spColor = findViewById<Spinner>(R.id.spColor)
        val spHobby = findViewById<Spinner>(R.id.spHobby)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)

        tvBienvenida.text = "Hola $nombre ($edad años). Selecciona tus preferencias:"

        ArrayAdapter.createFromResource(
            this, R.array.colores_array, android.R.layout.simple_spinner_item
        ).also { a ->
            a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spColor.adapter = a
        }

        ArrayAdapter.createFromResource(
            this, R.array.hobbies_array, android.R.layout.simple_spinner_item
        ).also { a ->
            a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spHobby.adapter = a
        }

        btnMostrar.setOnClickListener {
            val colorSel = spColor.selectedItem?.toString().orEmpty()
            val hobbySel = spHobby.selectedItem?.toString().orEmpty()

            val i = Intent(this, ResumenActivity::class.java)
            i.putExtra("nombre", nombre)
            i.putExtra("edad", edad)
            i.putExtra("color", colorSel)
            i.putExtra("hobby", hobbySel)
            startActivity(i)
        }
    }
}
