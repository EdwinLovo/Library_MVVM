package com.example.mvvm.Room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "author")
data class Author(

    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "name")
    var name:String
)