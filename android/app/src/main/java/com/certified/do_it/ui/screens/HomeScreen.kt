package com.certified.do_it.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.certified.do_it.data.model.Todo
import com.certified.do_it.ui.theme.DoItTheme

@Composable
fun HomeScreen() {
    Column() {
        Row() {
            
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    DoItTheme {
        HomeScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreviewNight() {
    DoItTheme {
        HomeScreen()
    }
}