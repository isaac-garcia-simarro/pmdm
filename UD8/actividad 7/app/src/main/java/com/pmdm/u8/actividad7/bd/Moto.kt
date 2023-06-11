package com.pmdm.u8.actividad7.bd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Moto(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "marca") val marca: String,
    @ColumnInfo(name = "modelo") val modelo: String,
    @ColumnInfo(name = "anyo") val anyo: Int,
    @ColumnInfo(name = "color") val color: String
)