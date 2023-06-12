package com.pmdm.u8.bdconroom.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(
    @ColumnInfo(name = "nombre") val nombre: String?,
    @ColumnInfo(name = "apellidos") val apellidos: String?
){

    @PrimaryKey(autoGenerate = true) var uid: Int = 0
}

