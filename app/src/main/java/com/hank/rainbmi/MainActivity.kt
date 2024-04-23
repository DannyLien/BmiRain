package com.hank.rainbmi

import android.graphics.drawable.Icon
import android.hardware.lights.Light
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hank.rainbmi.ui.theme.BmiRainTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiRainTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    SearchBar()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(text = "Test2")
        Text(text = "Test3 blablabla")
    }
}

@Composable //宣告式畫面元件設計方法
fun SearchBar(modifier: Modifier = Modifier) {
    Column {    //layout
        TextField(          //文字
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Search")
            },
            leadingIcon = {     //Icon
                androidx.compose.material3.Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = ""
                )
            },
            modifier = modifier.fillMaxWidth()  //設定寬度
        )
    }
}

@Preview(showBackground = true)  //監視畫面
@Composable
fun MyPreview() {
    BmiRainTheme {
//       Greeting("Android")
        SearchBar()
    }
}