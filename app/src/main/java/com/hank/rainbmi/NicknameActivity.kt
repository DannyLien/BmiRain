package com.hank.rainbmi

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hank.rainbmi.databinding.ActivityNicknameBinding

class NicknameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNicknameBinding
    val TAG = NicknameActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNicknameBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_nickname)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val level = intent.getIntExtra("EXTRA_LEVEL", 0)
        val name = intent.getStringExtra("NAME")

        Log.d(TAG, "onCreate: $level $name")

    }

    fun save(view: View) {
        val nickname = binding.edNickname.text.toString()
        setResult(RESULT_OK, intent.putExtra("NICK", nickname))
        finish()
    }

}