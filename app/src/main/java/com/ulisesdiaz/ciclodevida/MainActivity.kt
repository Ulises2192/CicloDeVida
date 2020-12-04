package com.ulisesdiaz.ciclodevida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var nombre = "Ulises"
    val clave = "nombre"

    /**
     * Aqui comienza el ciclo de vida de una actividad y se activa cuando un usuario inicia la
     * aplicacion para comenzar a renderizar la vista
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonUno = findViewById<Button>(R.id.btnUno)

        botonUno.setOnClickListener(View.OnClickListener {
            nombre = "Ivan"
            Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
        })
    }

    /**
     * Recupera la instancia y valores de la variable cuando ya se realizo un cambio de pantalla
     * Landscape o portraitya que  se destruye la actividad anterior para comenzar una nueva
     * de este modo vuelve a entrar al ciclo de vida inicial onCreate pero persistiendo los valores
     * de la actividad anterior
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        nombre = savedInstanceState?.getString(clave)!!
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
    }

    /**
     * Guarda la instancia de una actividdad para recuperar los valores de una variable cuando
     * se detecta un cambio de pantalla Landscape o Portrait
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putString(clave, nombre)
    }


    /**
     * Se activa cuando hay una transicion, ejemplo cambiar una aplicación por otra
     */
    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "En transición", Toast.LENGTH_SHORT).show()
    }

    /**
     * Se activa cuando el usuario deja de ver la acticvidad
     */
    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "Aplicativo Oculto", Toast.LENGTH_SHORT).show()
    }

    /**
     * Se activa cuando el aplicativo vuelve a estar visible para el usuario
     */
    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Aplicativo visible", Toast.LENGTH_SHORT).show()
    }

    /**
     * Se activa cuando una app sale del stack de aplicaciones
     */
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Aplicativo destruido", Toast.LENGTH_SHORT).show()
    }


}