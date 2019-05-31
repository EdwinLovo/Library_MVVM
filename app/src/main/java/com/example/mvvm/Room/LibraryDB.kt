package com.example.mvvm.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm.Room.Dao.AuthorDao
import com.example.mvvm.Room.Dao.BookAuthorDao
import com.example.mvvm.Room.Dao.BookDao
import com.example.mvvm.Room.Entities.Author
import com.example.mvvm.Room.Entities.Book
import com.example.mvvm.Room.Entities.BookAuthor
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Book::class, Author::class, BookAuthor::class], version = 1, exportSchema = false)
abstract  class LibraryDB:RoomDatabase() {

    abstract fun bookDao():BookDao
    abstract fun authorDao():AuthorDao
    abstract fun bookAuhtorDao():BookAuthorDao

    companion object {
        @Volatile
        private var INSTANCE: LibraryDB? = null

        fun getInstance(appContext:Context): LibraryDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this){
                val instance = Room
                    .databaseBuilder(appContext, LibraryDB::class.java, "library_db")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}