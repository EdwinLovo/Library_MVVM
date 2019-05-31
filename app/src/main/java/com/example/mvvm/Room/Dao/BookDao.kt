package com.example.mvvm.Room.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm.Room.Entities.Book

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: Book)

    @Query("select * from book")
    fun getAllBooks():LiveData<List<Book>>

    @Query("delete from book")
    fun deleteAllBooks()

    @Query("update book set favorite = :favorite where id = :id")
    suspend fun updateFavoriteState(id:Int, favorite:Boolean)

}