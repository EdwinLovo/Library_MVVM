package com.example.mvvm.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.Room.Entities.Author
import com.example.mvvm.Room.Entities.Book
import com.example.mvvm.Room.Entities.BookAuthor
import kotlinx.android.synthetic.main.book_info.view.*
import kotlinx.android.synthetic.main.fragment_library.view.*

class LibraryAdapter internal constructor(context: Context): RecyclerView.Adapter<LibraryAdapter.ViewHolder>(){

    private val inflater = LayoutInflater.from(context)
    private var books = emptyList<Book>()
    private var authors = emptyList<Author>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = inflater.inflate(R.layout.book_info, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentBook = books[position]
        var author = ""

        holder.name.text = currentBook.name
        holder.editorial.text = currentBook.editorial
        holder.favorite.text = currentBook.favorite.toString()

        authors.forEach {
            author = author + ", " + it.name
        }

        holder.author.text = author

    }

    internal fun setBooks(books:List<Book>){
        this.books = books
        notifyDataSetChanged()
    }

    internal fun setAuthors(authors:List<Author>){
        this.authors = authors
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val name:TextView = itemView.name
        val author:TextView = itemView.author
        val editorial:TextView = itemView.editorial
        val favorite:TextView = itemView.favorite
    }

}