package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etEdad = findViewById<EditText>(R.id.etEdad)
        val btnSiguiente = findViewById<Button>(R.id.btnSiguiente)

        btnSiguiente.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val edadStr = etEdad.text.toString().trim()

            if (nombre.isEmpty() || edadStr.isEmpty()) {
                Toast.makeText(this, "Completa nombre y edad", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val edad = edadStr.toIntOrNull()
            if (edad == null || edad < 0) {
                Toast.makeText(this, "Edad inválida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val i = Intent(this, PreferenciasActivity::class.java)
            i.putExtra("nombre", nombre)
            i.putExtra("edad", edad)
            startActivity(i)
        }
    }
}
