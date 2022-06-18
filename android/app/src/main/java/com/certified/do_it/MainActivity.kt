package com.certified.do_it

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.certified.do_it.data.model.Category
import com.certified.do_it.ui.screens.AboutScreen
import com.certified.do_it.ui.screens.AnalyticsScreen
import com.certified.do_it.ui.screens.EditCategoryScreen
import com.certified.do_it.ui.screens.NotificationScreen
import com.certified.do_it.ui.theme.DoItTheme
import com.certified.do_it.ui.theme.PrimaryContainer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoItTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AboutScreen()
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