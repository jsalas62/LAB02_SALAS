package com.salas.jorge.usolayoutsv4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class Ejercicio01 : AppCompatActivity() {

    private lateinit var btnMostrar: Button
    private lateinit var btnOcultar: Button
    private lateinit var viewVerde: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio01)

        btnMostrar = findViewById<Button>(R.id.btnMostrar)
        btnOcultar = findViewById<Button>(R.id.btnOcultar)
        viewVerde = findViewById<ImageView>(R.id.viewVerde)

        btnMostrar.setOnClickListener {
            viewVerde.visibility = View.VISIBLE
        }

        btnOcultar.setOnClickListener {
            viewVerde.visibility = View.GONE
        }
    }
}
