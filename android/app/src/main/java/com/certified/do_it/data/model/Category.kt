package com.certified.do_it.data.model

import androidx.compose.ui.graphics.Color
import com.certified.do_it.ui.theme.Primary

data class Category(
    var name: String = "",
    var color: Color = Primary,
    var todos: List<Todo> = listOf()
)