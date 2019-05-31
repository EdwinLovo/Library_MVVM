package com.example.mvvm.Room.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm.Room.Entities.Author

@Dao
interface AuthorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(author: Author)

    @Query("select * from author")
    fun getAllAuthors():LiveData<List<Author>>

    @Query("delete from author")
    fun deleteAllAuthors()

    @Query("select * from author where id = :id")
    fun getAuthorById(id:Int):LiveData<Author>

}