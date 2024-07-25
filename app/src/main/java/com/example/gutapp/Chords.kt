package com.example.gutapp

import android.media.MediaPlayer
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class Chords : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chords)

        val actionBar = getSupportActionBar()

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        val spinner1 = findViewById<Spinner>(R.id.spinner)
        var selected1 = spinner1.selectedItem.toString()
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        var selected2 = spinner2.selectedItem.toString()

        var chordName = selected1.lowercase().replace('#', '_') + selected2
        var chordId = resources.getIdentifier(chordName, "drawable", packageName)
        val imageView = findViewById<ImageView>(R.id.imageView8)
        imageView.setImageResource(chordId)

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val choose = resources.getStringArray(R.array.notes)
                selected1 = choose[position]
                chordName = selected1.lowercase().replace('#', '_') + selected2
                chordId = resources.getIdentifier(chordName, "drawable", packageName)
                imageView.setImageResource(chordId)
            }
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val choose = resources.getStringArray(R.array.chords)
                selected2 = choose[position]
                chordName = selected1.lowercase().replace('#', '_') + selected2
                chordId = resources.getIdentifier(chordName, "drawable", packageName)
                imageView.setImageResource(chordId)
            }
        }

        val button: ImageButton = findViewById<View>(R.id.imageButton) as ImageButton
        var mp: MediaPlayer = MediaPlayer.create(this, R.raw.amin)
        var soundId = resources.getIdentifier(chordName, "raw", packageName)
        button.setOnClickListener {
            mp.reset()
            soundId = resources.getIdentifier(chordName, "raw", packageName)
            mp = MediaPlayer.create(this, soundId)
            mp.start()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
