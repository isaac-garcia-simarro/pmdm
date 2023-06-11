package com.pmdm.u8.actividad7.bd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Moto::class], version = 1)
abstract class MotosDB : RoomDatabase() {

    abstract fun motoDao(): MotoDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MotosDB? = null

        fun getDatabase(context: Context): MotosDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MotosDB::class.java,
                    "MotosDB"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}