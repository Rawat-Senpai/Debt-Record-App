package com.example.udhari_kotlin

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DataDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(data:Data)

    @Delete
    suspend fun deleteData(data:Data)

    @Update
    suspend fun update(data: Data)

    @Query("Select * From user_table")
    fun getAllData():LiveData<List<Data>>
}