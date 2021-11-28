package com.example.udhari_kotlin

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized


@Database(entities = [Data::class],version = 1,exportSchema = false)
abstract class dataDatabase : RoomDatabase() {
    abstract fun dataDao():DataDao

    companion object{
        @Volatile
        private var INSTANCE: dataDatabase? = null


        
        @InternalCoroutinesApi
        fun getDatabase(context: Context):dataDatabase{

            return INSTANCE ?: synchronized(this) {
                val instance =  Room.databaseBuilder(
                    context.applicationContext,
                    dataDatabase::class.java,
                    "amount_database"
                ).build()
                INSTANCE = instance
                instance
            }

        }

    }
}