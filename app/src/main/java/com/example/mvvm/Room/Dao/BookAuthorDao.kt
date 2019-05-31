package com.example.mvvm.Room.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm.Room.Entities.Author
import com.example.mvvm.Room.Entities.Book
import com.example.mvvm.Room.Entities.BookAuthor

@Dao
interface BookAuthorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insert(bookAuthor: BookAuthor)

    @Query("select * from bookauthor")
    fun getAllBookAuthor():LiveData<List<BookAuthor>>

    @Query("delete from bookauthor")
    fun deleteAllBookAuthor()

    @Query("select * from author inner join bookauthor on author.id =authorId where bookId=:idBook")
    fun getAuthorsForBook(idBook:Int):LiveData<List<Author>>

    @Query("select * from book inner join bookauthor on book.id=bookId where authorId=:idAuthor")
    fun getBooksForAuthor(idAuthor:Int):LiveData<List<Book>>

}