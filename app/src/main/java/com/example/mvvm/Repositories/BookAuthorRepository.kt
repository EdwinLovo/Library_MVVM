package com.example.mvvm.Repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.mvvm.Room.Dao.BookAuthorDao
import com.example.mvvm.Room.Entities.Author
import com.example.mvvm.Room.Entities.Book
import com.example.mvvm.Room.Entities.BookAuthor

class BookAuthorRepository(private val bookAuthorDao: BookAuthorDao) {

    fun getAll():LiveData<List<BookAuthor>> = bookAuthorDao.getAllBookAuthor()

    fun getBooksForAuthor(idAuthor:Int):LiveData<List<Book>> = bookAuthorDao.getBooksForAuthor(idAuthor)

    fun getAuthorsForBook(idBook:Int):LiveData<List<Author>> = bookAuthorDao.getAuthorsForBook(idBook)

    @WorkerThread
    suspend fun insert(bookAuthor: BookAuthor) = bookAuthorDao.Insert(bookAuthor)
}