package com.salas.jorge.usolayoutsv4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Ejercicio02_1 : AppCompatActivity() {
    private lateinit var txtNombre: TextView
    private lateinit var txtNumero: TextView
    private lateinit var txtProducto: TextView
    private lateinit var txtUbicacion: TextView
    private lateinit var btnLlamar: Button
    private lateinit var btnWhatsapp: Button
    private lateinit var btnMaps: Button

    private var numero: String? = null
    private var direccion: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio02_1)

        txtNombre = findViewById(R.id.txtNombre)
        txtNumero = findViewById(R.id.txtNumero)
        txtProducto = findViewById(R.id.txtProducto)
        txtUbicacion = findViewById(R.id.txtUbicacion)
        btnLlamar = findViewById(R.id.btnLlamar)
        btnWhatsapp = findViewById(R.id.btnWhatsapp)
        btnMaps = findViewById(R.id.btnMaps)

        val extras = intent.extras

        if (extras != null) {
            val nombre = extras.getString("nombre")
            val apellido = extras.getString("apellido")
            numero = extras.getString("numero")
            val productos = extras.getString("productos")
            direccion = extras.getString("direccion")

            txtNombre.text = "$nombre $apellido"
            txtNumero.text = numero
            txtProducto.text = productos
            txtUbicacion.text = direccion
        }

        btnLlamar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$numero")
            startActivity(intent)
        }

        btnWhatsapp.setOnClickListener {
            val mensaje = "Hola $txtNombre"
            val uri = Uri.parse("smsto:+51$numero")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", mensaje)
            intent.setPackage("com.whatsapp")
            if (intent.resolveActivity(this.packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "wtsp no está instalado", Toast.LENGTH_SHORT).show()
            }
        }
        btnMaps.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q= $direccion")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

    }
}
