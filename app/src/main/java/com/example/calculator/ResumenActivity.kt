package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResumenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val tvResumen = findViewById<TextView>(R.id.tvResumen)
        val btnFinalizar = findViewById<Button>(R.id.btnFinalizar)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        val nombre = intent.getStringExtra("nombre") ?: "Usuario"
        val edad = intent.getIntExtra("edad", 0)
        val color = intent.getStringExtra("color") ?: "—"
        val hobby = intent.getStringExtra("hobby") ?: "—"

        val gustan = if (hobby.contains(",") || hobby.contains(" y ")) "te gustan" else "te gusta"
        tvResumen.text = "Hola $nombre ($edad años), tu color favorito es $color y $gustan $hobby."

        btnFinalizar.setOnClickListener { finishAffinity() }

        btnRegresar.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
            finish()
        }
    }
}
