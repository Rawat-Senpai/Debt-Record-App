package com.example.udhari_kotlin

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class DataRepository (private  val dataDao: DataDao){

    val readAllData:LiveData<List<Data>> = dataDao.getAllData()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(data:Data){
        dataDao.insert(data)
    }

    suspend fun updateData(data:Data){
        dataDao.update(data)
    }

    suspend fun deleteData(data: Data){
        dataDao.deleteData(data)
    }
}