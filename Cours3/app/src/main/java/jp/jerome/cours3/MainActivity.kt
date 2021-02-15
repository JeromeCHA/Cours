package jp.jerome.cours3

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import jp.jerome.cours3.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Creer notre liste de livres
        val list = mutableListOf<Book>()
        (0..50).forEach {
            list.add(
                Book(
                    title = "Le seigneur des anneaux ${it + 1}",
                    author = "J.R.R. Tolkien",
                    image = null,
                    publishedDate = if (it == 4) null else "2021/02/13"
                )
            )
        }

        // Creer l'adapter
        val adapter = BookAdapter(this)
        // Changer la liste de l'adapteur
        adapter.bookList = list

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }
}