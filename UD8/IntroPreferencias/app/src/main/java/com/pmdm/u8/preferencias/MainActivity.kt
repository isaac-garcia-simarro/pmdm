package com.pmdm.u8.preferencias

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pmdm.u8.preferencias.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.btnGuardar.setOnClickListener { guardarPreferencias() }
        setContentView(binding.root)

        //Cargar dato de preferencias, si hay algo guardado

        val prefs = getSharedPreferences("PreferenciasApp", Context.MODE_PRIVATE);
        val nombre = prefs.getString("nombre", "");


        if(nombre!!.isNotEmpty())
            binding.etPreferencias.setText(nombre)

    }



    private fun guardarPreferencias() {

        val prefs = getSharedPreferences("PreferenciasApp", Context.MODE_PRIVATE);
        with(prefs.edit()){
            putString("nombre", "Isaac");
            apply();
        }
    }
}