package com.example.gutapp

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class Pentatonics : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pentatonics)

        var actionBar = getSupportActionBar()

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        val spinner1 = findViewById<Spinner>(R.id.spinner3)
        var selected1 = (spinner1.selectedItemPosition + 1).toString()
        val spinner2 = findViewById<Spinner>(R.id.spinner4)
        var selected2 = spinner2.selectedItem.toString()

        var pentaName = "p" + selected1 + selected2
        var pentaId = resources.getIdentifier(pentaName, "drawable", packageName)
        val imageView = findViewById<ImageView>(R.id.imageView10)
        imageView.setImageResource(pentaId)

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selected1 = (position + 1).toString()
                pentaName = "p" + selected1 + selected2
                pentaId = resources.getIdentifier(pentaName, "drawable", packageName)
                imageView.setImageResource(pentaId)
            }
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val choose = resources.getStringArray(R.array.chords)
                selected2 = choose[position]
                pentaName = "p" + selected1 + selected2
                pentaId = resources.getIdentifier(pentaName, "drawable", packageName)
                imageView.setImageResource(pentaId)
            }
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
