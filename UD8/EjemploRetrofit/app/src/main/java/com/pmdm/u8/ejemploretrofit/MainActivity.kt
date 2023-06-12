package com.pmdm.u8.ejemploretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.pmdm.u8.ejemploretrofit.api.PeliculaService
import com.pmdm.u8.ejemploretrofit.api.autenticacion.InterceptorTokenAutenticacion
import com.pmdm.u8.ejemploretrofit.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPeliculaEjemplo()
    }

    private fun getPeliculaEjemplo(){
        CoroutineScope(Dispatchers.IO).launch {
            val id = 385687//id de una peli que hemos comprobado que existe
            val peli = getRetrofit().create(PeliculaService::class.java).obtenerPeliculaId(id)
            runOnUiThread {
                Toast.makeText(applicationContext, "La película con id $id corresponde a ${peli.title}",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        //Se crea interceptor para todas las peticiones con el token de autenticación válido
        val client =  OkHttpClient.Builder()
            .addInterceptor(InterceptorTokenAutenticacion("Bearer", "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3NTY2OGQwYzBlNTY2OTQ1OWZlMmMyZDJiY2Q2OTUzMyIsInN1YiI6IjY0ODZlMTEwOTkyNTljMDExYzQxMzE3OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XRnbohWo39y4gfkrO64Rk2oeCAdw6jWeSqMemASMk-o"))
            .build()
        //se crea y devuelve instancia de retrofit con el token de autenticación
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}