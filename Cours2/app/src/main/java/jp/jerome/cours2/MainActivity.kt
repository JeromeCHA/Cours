package jp.jerome.cours2

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import jp.jerome.cours2.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.user = User("Cha", "")
        binding.activity = this
    }

    fun clickMe() {
        Toast.makeText(this, "こんばんは！", Toast.LENGTH_SHORT).show()
    }
}