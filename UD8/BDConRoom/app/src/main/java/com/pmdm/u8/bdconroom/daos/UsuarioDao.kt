package com.pmdm.u8.bdconroom.daos

import androidx.room.*
import com.pmdm.u8.bdconroom.entities.Usuario

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM usuario")
    suspend fun getAll(): List<Usuario>

    @Query("SELECT * FROM usuario WHERE uid = :id")
    suspend fun findById(id: Int): Usuario

    @Query("SELECT * FROM usuario WHERE nombre LIKE :nom LIMIT 1")
    suspend fun findByName(nom: String): Usuario

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(usuario: Usuario)

    @Update
    suspend fun update(usuario: Usuario)

    @Delete
    suspend fun delete(usuario: Usuario)
}
