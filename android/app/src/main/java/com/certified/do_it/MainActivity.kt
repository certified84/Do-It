package com.certified.do_it

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.certified.do_it.data.model.Category
import com.certified.do_it.data.model.Emoji
import com.certified.do_it.ui.screens.CategoryDetailScreen
import com.certified.do_it.ui.screens.EditCategoryScreen
import com.certified.do_it.ui.screens.NotificationScreen
import com.certified.do_it.ui.theme.DoItTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoItTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EditCategoryScreen(Category())
//                    val json = Gson().toJson(R.raw.emoji)
                    val json = LocalContext.current.resources.openRawResource(R.raw.emoji)
                        .bufferedReader().use { it.readText() }
                    val objects = Gson().fromJson(json, Array<Emoji>::class.java)
                    Log.d("TAG", "onCreate: ${objects[1]}")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DoItTheme {
        Greeting("Android")
    }
}