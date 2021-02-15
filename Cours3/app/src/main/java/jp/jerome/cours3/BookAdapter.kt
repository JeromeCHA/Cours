package jp.jerome.cours3

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import jp.jerome.cours3.databinding.ItemRowBinding

class BookAdapter(private val context: Context) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    var bookList = listOf<Book>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRowBinding.inflate(layoutInflater, parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        if (position < bookList.size) {
            val book = bookList[position]
            holder.binding.bookTitle.text = book.title
            holder.binding.bookAuthor.text = book.author

            if (book.publishedDate == null) {
                holder.itemView.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.red
                    )
                )
            } else {
                holder.itemView.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.white
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    class BookViewHolder(var binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)
}