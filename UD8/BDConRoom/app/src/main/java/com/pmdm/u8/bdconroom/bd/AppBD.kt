package com.pmdm.u8.bdconroom.bd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pmdm.u8.bdconroom.daos.UsuarioDao
import com.pmdm.u8.bdconroom.entities.Usuario

@Database(entities = [Usuario::class], version = 1)
abstract class AppBD : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao

    companion object {
        private const val DATABASE_NAME = "app_BD"

        @Volatile
        private var INSTANCE: AppBD? = null
        fun getInstance(context: Context): AppBD {
            INSTANCE ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppBD::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE!!
        }
    }
}



