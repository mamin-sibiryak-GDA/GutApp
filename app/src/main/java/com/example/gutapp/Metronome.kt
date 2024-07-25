package com.example.gutapp

import android.media.MediaPlayer
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class Metronome : AppCompatActivity() {
    private var myTimer1: Timer = Timer()
    private var myTimer2: Timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.metronome)

        var actionBar = getSupportActionBar()

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        val editText: EditText = findViewById(R.id.editTextNumber)

//        myTimer.schedule(object : TimerTask() {
//            override fun run() {
//                timerTick()
//            }
//        }, 0, 60000 / bpm)
//        myTimer.cancel()


        var metro1: MediaPlayer = MediaPlayer.create(this, R.raw.metro1)
        metro1.isLooping = true

        val button: Button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            if (button.text == "СТАРТ") {
                if (editText.text.toString().toInt() < 20) {
                    val toast = Toast.makeText(
                        applicationContext,
                        "Слишком маленький BPM",
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                } else if (editText.text.toString().toInt() > 240) {
                    val toast = Toast.makeText(
                        applicationContext,
                        "Слишком большой BPM",
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                } else {
                    button.setText("СТОП")

                    myTimer1 = Timer()
                    myTimer2 = Timer()

                    var bpm = editText.text.toString().toInt().toLong()
                    val spinner1 = findViewById<Spinner>(R.id.spinner5)
                    val selected1 = spinner1.selectedItem.toString().toInt().toLong()
                    val spinner2 = findViewById<Spinner>(R.id.spinner6)
                    val selected2 = spinner2.selectedItem.toString().toInt().toLong()

                    myTimer1.schedule(object : TimerTask() {
                        override fun run() {
                            timerTick1()
                        }
                    }, 0, 60000 / bpm * selected1 * 4 / selected2)

                    myTimer2.schedule(object : TimerTask() {
                        override fun run() {
                            timerTick2()
                        }
                    }, 0, 60000 / bpm * 4 / selected2)
                }
            }
            else if (button.text == "СТОП") {
                button.setText("СТАРТ")

                myTimer1.cancel()
                myTimer2.cancel()
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

    private fun timerTick1() {
        var metro1: MediaPlayer = MediaPlayer.create(this, R.raw.metro1)
        metro1.start()
        metro1.setOnCompletionListener { metro1 -> metro1.release() }
    }

    private fun timerTick2() {
        var metro1: MediaPlayer = MediaPlayer.create(this, R.raw.metro2)
        metro1.start()
        metro1.setOnCompletionListener { metro1 -> metro1.release() }
    }

    override fun onDestroy() {
        super.onDestroy()
        myTimer1.cancel()
        myTimer2.cancel()
    }
}
