package jp.jerome.cours1

import android.app.Activity
import android.os.Bundle
import android.util.Log

class Activity2: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        Log.d("Lifecycle2", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle2", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle2", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle2", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle2", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle2", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle2", "onRestart")
    }
}