package com.certified.do_it.data.model

import android.content.Context
import androidx.compose.ui.graphics.Color
import com.certified.do_it.ui.theme.Primary
import com.certified.do_it.ui.MainActivity

data class Category(
    var name: String = "",
    var description: String = "",
    var color: Color = Primary,
    var todos: List<Todo> = listOf(),
    var emoji: Emoji = Emoji()
) {
    val percent =
        if (todos.isNotEmpty()) (todos.count { it.isDone } / todos.count()) * 100f else 0.0f

//    val emoji = JSON
}

fun readJSONFile(context: Context) {
//    val text = context.resources.openRawResource(R.raw.emoji)
//        .bufferedReader().use { it.readText() }
}

//data class EmojiList(v)
data class Emoji(
    val emoji: String = "",
    val description: String = "",
    val category: String = "",
    val aliases: List<String> = listOf(),
    val tags: List<String> = listOf(),
    val unicode_version: String? = null,
    val ios_version: String? = null
)