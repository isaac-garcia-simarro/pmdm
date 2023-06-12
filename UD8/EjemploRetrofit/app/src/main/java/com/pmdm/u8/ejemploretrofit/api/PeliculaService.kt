package com.pmdm.u8.ejemploretrofit.api

import com.pmdm.u8.ejemploretrofit.api.models.Pelicula
import retrofit2.Response
import retrofit2.http.*

interface PeliculaService {
    @POST("movie")
    suspend fun crearPelicula(@Body movie: Pelicula): Pelicula

    @GET("movie/popular")
    suspend fun obtenerPeliculasPopulares(): List<Pelicula>

    @GET("movie/{id}")
    suspend fun obtenerPeliculaId(@Path("id") id: Int): Pelicula

    @PUT("movie/{id}")
    suspend fun actualizarPelicula(@Path("id") id: Int, @Body movie: Pelicula): Pelicula

    @DELETE("movie/{id}")
    suspend fun borrarPelicula(@Path("id") id: Int)
}

