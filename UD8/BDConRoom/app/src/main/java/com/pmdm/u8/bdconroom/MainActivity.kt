package com.pmdm.u8.bdconroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.pmdm.u8.bdconroom.bd.AppBD
import com.pmdm.u8.bdconroom.databinding.ActivityMainBinding
import com.pmdm.u8.bdconroom.entities.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.Console

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.button.setOnClickListener { guardarUsuarioEnBD() }
        setContentView(binding.root)

        cargarPrimerUsuario()
    }

    private fun cargarPrimerUsuario(){
        CoroutineScope(Dispatchers.IO).launch {
            val usuarios = AppBD.getInstance(applicationContext).usuarioDao().getAll()
            runOnUiThread {
                if(usuarios.isNotEmpty()){
                    val primerUsuario = usuarios.get(0)
                    Log.d("AppBD", "${primerUsuario.uid} ${primerUsuario.nombre} ${primerUsuario.apellidos}")
                }
            }
        }
    }

    private fun guardarUsuarioEnBD() {
        val nuevoUsuario = Usuario(nombre=binding.etNombre.text.toString(),
            apellidos = binding.etApellidos.text.toString());
        CoroutineScope(Dispatchers.IO).launch {
            AppBD.getInstance(applicationContext).usuarioDao().insert(nuevoUsuario)
            runOnUiThread {
                Toast.makeText(applicationContext, "Usuario insertado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}