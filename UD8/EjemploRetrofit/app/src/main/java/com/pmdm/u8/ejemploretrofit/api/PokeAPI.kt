package com.pmdm.u8.ejemploretrofit.api

import retrofit2.Call
import retrofit2.http.*

interface PokeAPI {
    // Método para crear un pokemo
    //Este no funcionará al ser un api público de solo consulta, pero la implementación sería correcta
    @POST("pokemon")
    fun crearPokemon(@Body pokemon: Pokemon): Call<Pokemon>

    // Método para obtener todos los pokemons
    @GET("pokemon")
    fun getPokemons(): Call<List<Pokemon>>

    // Método para obtener un pokemon por su id
    @GET("pokemon/{id}")
    fun getPokemon(@Path("id") id: Int): Call<Pokemon>

    // Método para actualizar un pokemon
    @PUT("pokemon/{id}")
    fun updatePokemon(@Path("id") id: Int, @Body movie: Pokemon): Call<Pokemon>

    // Método para eliminar un pokemon
    @DELETE("pokemon/{id}")
    fun deletePokemon(@Path("id") id: Int): Call<Void>
}