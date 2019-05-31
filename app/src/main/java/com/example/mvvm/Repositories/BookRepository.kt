package com.example.mvvm.Repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.mvvm.Room.Dao.BookDao
import com.example.mvvm.Room.Entities.Book

class BookRepository(private val bookDao: BookDao) {

    fun getAllBooks():LiveData<List<Book>> = bookDao.getAllBooks()

    @WorkerThread
    suspend fun insert(book: Book) = bookDao.insert(book)

    @WorkerThread
    suspend fun updateFavorite(idBook:Int, favorite:Boolean) = bookDao.updateFavoriteState(idBook,favorite)

}