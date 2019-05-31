package com.example.mvvm.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvm.Repositories.AuthorRepository
import com.example.mvvm.Repositories.BookAuthorRepository
import com.example.mvvm.Repositories.BookRepository
import com.example.mvvm.Room.Dao.BookDao
import com.example.mvvm.Room.Entities.Author
import com.example.mvvm.Room.Entities.Book
import com.example.mvvm.Room.Entities.BookAuthor
import com.example.mvvm.Room.LibraryDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(app:Application): AndroidViewModel(app) {

    private val bookRepository:BookRepository
    private val authorRepository:AuthorRepository
    private val bookAuthorRepository:BookAuthorRepository

    init {
        val bookDao = LibraryDB.getInstance(app).bookDao()
        val authorDao = LibraryDB.getInstance(app).authorDao()
        val bookAuthorDao = LibraryDB.getInstance(app).bookAuhtorDao()
        bookRepository = BookRepository(bookDao)
        authorRepository = AuthorRepository(authorDao)
        bookAuthorRepository = BookAuthorRepository(bookAuthorDao)
    }

    fun getAllBooks():LiveData<List<Book>> = bookRepository.getAllBooks()
    fun getAllAuthors():LiveData<List<Author>> = authorRepository.getAllAuthors()
    fun getAuthorById(id:Int):LiveData<Author> = authorRepository.getAuthorById(id)
    fun getAuthorsForBook(idBook:Int):LiveData<List<Author>> = bookAuthorRepository.getAuthorsForBook(idBook)
    fun getBooksForAuthor(idAuthor:Int):LiveData<List<Book>> = bookAuthorRepository.getBooksForAuthor(idAuthor)

    fun insertBook(book: Book) = viewModelScope.launch(Dispatchers.IO){
        bookRepository.insert(book)
    }

    fun updateFavorite(id: Int, favorite:Boolean) = viewModelScope.launch(Dispatchers.IO){
        bookRepository.updateFavorite(id,favorite)
    }

    fun insertAuthor(author: Author) = viewModelScope.launch(Dispatchers.IO){
        authorRepository.insert(author)
    }

    fun insertBookAuthor(bookAuthor: BookAuthor) = viewModelScope.launch(Dispatchers.IO){
        bookAuthorRepository.insert(bookAuthor)
    }

}