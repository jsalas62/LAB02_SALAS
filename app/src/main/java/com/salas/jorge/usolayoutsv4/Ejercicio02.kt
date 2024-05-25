package com.salas.jorge.usolayoutsv4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Ejercicio02 : AppCompatActivity() {

    private lateinit var btnGuardar: Button
    private lateinit var editCliente: EditText
    private lateinit var editNumero: EditText
    private lateinit var editProductos: EditText
    private lateinit var editApellido: EditText
    private lateinit var editDireccion: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio02)

        btnGuardar = findViewById<Button>(R.id.btnGuardar)
        editCliente = findViewById(R.id.editCliente)
        editApellido = findViewById(R.id.editApellido)
        editNumero = findViewById(R.id.editNumero)
        editProductos = findViewById(R.id.editProductos)
        editDireccion = findViewById(R.id.editDireccion)

        btnGuardar.setOnClickListener {
            val intent = Intent(this, Ejercicio02_1::class.java)
            intent.putExtra("nombre", editCliente.text.toString())
            intent.putExtra("numero", editNumero.text.toString())
            intent.putExtra("productos", editProductos.text.toString())
            intent.putExtra("apellido", editApellido.text.toString())
            intent.putExtra("direccion", editDireccion.text.toString())
            startActivity(intent)
        }
    }
}