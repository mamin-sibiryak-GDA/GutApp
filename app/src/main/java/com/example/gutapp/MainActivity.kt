package com.example.gutapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickChords(view: View){
        val intent = Intent(this@MainActivity, Chords::class.java)
        startActivity(intent)
    }

    fun onClickCircle(view: View){
        val intent = Intent(this@MainActivity, Circle::class.java)
        startActivity(intent)
    }

    fun onClickNotes(view: View){
        val intent = Intent(this@MainActivity, Notes::class.java)
        startActivity(intent)
    }

    fun onClickPentas(view: View){
        val intent = Intent(this@MainActivity, Pentatonics::class.java)
        startActivity(intent)
    }

    fun onClickMetro(view: View){
        val intent = Intent(this@MainActivity, Metronome::class.java)
        startActivity(intent)
    }
}