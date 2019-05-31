package com.example.mvvm.Room.Entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "bookauthor",
    primaryKeys = ["bookId", "authorId"],
    foreignKeys = [
        ForeignKey(entity = Book::class, parentColumns = ["id"], childColumns = ["bookId"]),
        ForeignKey(entity = Author::class, parentColumns = ["id"], childColumns = ["authorId"])
    ]
)
data class BookAuthor(
    val bookId:Int,
    val authorId:Int
)