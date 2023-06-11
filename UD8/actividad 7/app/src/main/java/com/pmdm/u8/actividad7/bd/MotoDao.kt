package com.pmdm.u8.actividad7.bd

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MotoDao {

    @Query("SELECT * from Moto")
    suspend fun getAll(): Flow<List<Moto>>

    @Query("SELECT * FROM Moto WHERE id = :id")
    suspend fun findById(id: Int): Moto

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(motos: List<Moto>)

    @Update
    suspend fun update(moto: Moto)

    @Delete
    suspend fun delete(moto: Moto)
}