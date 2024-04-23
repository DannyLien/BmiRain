package com.hank.rainbmi

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hank.rainbmi.databinding.ActivityMainBinding
import kotlin.math.log
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val game = GuessGame()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  //要留
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }   //可註解
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, getString(R.string.secret_number_is) + game.secret, Toast.LENGTH_LONG)
            .show()

    }

    fun guess(view: View) {
        if (!binding.number.text.toString().equals("")) {
            val num = binding.number.text.toString().toInt()
            val message = when (game.guess(num)) {
                GuessGame.Status.SMALLER -> getString(R.string.smaller)
                GuessGame.Status.BIGGER -> getString(R.string.bigger)
                else -> getString(R.string.you_got_it)
            }
            binding.counter.text = game.counter.toString()
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.info))
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok), null)
                .show()

        } else {
            Toast.makeText(this, getString(R.string.please_enter_a_number_1_10), Toast.LENGTH_LONG)
                .show()
        }
    }

}