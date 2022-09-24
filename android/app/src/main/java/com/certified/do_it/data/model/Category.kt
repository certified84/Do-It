package com.certified.do_it.data.model

import android.content.Context
import androidx.compose.ui.graphics.Color
import com.certified.do_it.ui.theme.Primary
import kotlin.math.roundToInt

data class Category(
    val id: Int = 0,
    var name: String = "",
    var description: String = "",
    var color: Color = Primary,
    var todos: List<Todo> = listOf(),
    var emoji: Emoji = Emoji()
) {
    val percent: Float

    init {
        val count = todos.count { it.isDone } / todos.size.toFloat()
        val i = (count * 10000).roundToInt() / 100.0f
        println(i)
        percent =
            if (todos.isNotEmpty()) i else 0.0f
    }

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