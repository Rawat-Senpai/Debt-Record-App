package com.example.udhari_kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class DataViewModel (application: Application):AndroidViewModel(application){

    val readAllData:LiveData<List<Data>>
    val repository:DataRepository

    init {
     val dataDao= dataDatabase.getDatabase(application).dataDao()
        repository= DataRepository(dataDao)
        readAllData= repository.readAllData
    }

    fun insert(data:Data){
        viewModelScope.launch (Dispatchers.IO){
            repository.insert(data)
        }
    }
    fun  updateData(data: Data){
        viewModelScope.launch (Dispatchers.IO){
            repository.updateData(data)
        }
    }

    fun dataDelete(data: Data){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteData(data)
        }
    }



}