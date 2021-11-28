package com.example.udhari_kotlin

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName="user_table")
data class Data(
    @PrimaryKey(autoGenerate = true)
    val id:Int= 0,
    @ColumnInfo val Name:String,
    @ColumnInfo val Price:String,
    @ColumnInfo val note:String

):Parcelable
