package com.example.mvvm.Repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.mvvm.Room.Dao.AuthorDao
import com.example.mvvm.Room.Entities.Author

class AuthorRepository(private val authorDao: AuthorDao) {

    fun getAllAuthors():LiveData<List<Author>> = authorDao.getAllAuthors()

    fun getAuthorById(id:Int):LiveData<Author> = authorDao.getAuthorById(id)

    @WorkerThread
    suspend fun insert(author: Author) = authorDao.insert(author)
}