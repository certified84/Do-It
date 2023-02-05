package com.certified.do_it.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.certified.do_it.R
import com.certified.do_it.data.model.Category
import com.certified.do_it.data.model.Emoji
import com.certified.do_it.data.model.User
import com.certified.do_it.ui.screens.EditCategoryScreen
import com.certified.do_it.ui.screens.HomeScreen
import com.certified.do_it.ui.theme.DoItTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoItTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(User())
                    context = LocalContext.current
                    val json = context.resources.openRawResource(R.raw.emoji)
                        .bufferedReader().use { it.readText() }
                    val objects = Gson().fromJson(json, Array<Emoji>::class.java)
                    Log.d("TAG", "onCreate: $objects")
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
        val json = LocalContext.current.resources.openRawResource(R.raw.emoji)
            .bufferedReader().use { it.readText() }
        val objects = Gson().fromJson(json, Array<Emoji>::class.java)
        EditCategoryScreen(
            category = Category(
                name = "Go Fuck yourself",
                description = "I ain't gat one bitch!",
                emoji = objects[0]
            )
        )
    }
}