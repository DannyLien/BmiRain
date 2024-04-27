package com.hank.rainbmi

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.hank.rainbmi.databinding.ActivityMainBinding
import kotlin.math.log
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    private val NICKNAME_REQ: Int = 11
    private lateinit var viewModel: GuessViewModel
    val TAG = MainActivity2::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    val game = GuessGame()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  //要留
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ViewModel 監聽 建立
        viewModel = ViewModelProvider(this).get(GuessViewModel::class.java)
        //LiveData 監聽
        viewModel.counter.observe(this) { counter ->
            binding.counter.text = counter.toString()
        }
        //LiveData
        viewModel.status.observe(this) { status ->
            val message = when (status) {
                GameStatus.BIGGER -> getString(R.string.bigger)
                GameStatus.SMALLER -> getString(R.string.smaller)
                GameStatus.INIT -> ""
                else -> getString(R.string.you_got_it)
            }
            if (status != GameStatus.INIT) {
                AlertDialog.Builder(this)
                    .setTitle("Info")
                    .setMessage(message)
                    .setPositiveButton("OK", null)
                    .setNegativeButton("Replay") { dialog, which ->
                        Log.d(TAG, "Replay ")
                        viewModel.reset()
                    }
                    .show()
            }
        }

        viewModel.secretData.observe(this) { secret ->
            Toast.makeText(
                this,
                getString(R.string.secret_number_is) + "$secret",
                Toast.LENGTH_LONG
            ).show()
        }

    }

    fun guess(view: View) {
        if (!binding.number.text.toString().equals("")) {
            //viewModel
            viewModel.guess(binding.number.text.toString().toInt())
        }

    }

    fun setNickname(view: View) {
        val intent = Intent(this, NicknameActivity::class.java)
        intent.putExtra("EXTRA_LEVEL", 3)
        intent.putExtra("NAME", "Hank")
//        startActivity(intent)

        startActivityForResult(intent, NICKNAME_REQ)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NICKNAME_REQ) {
            Log.d(TAG, "onActivityResult: $resultCode ")
            val nickname = data?.getStringExtra("NICK")
            Log.d(TAG, "onActivityResult: $nickname")
        }

    }
}