package com.certified.do_it.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.certified.do_it.data.model.Category
import com.certified.do_it.data.model.Todo
import com.certified.do_it.ui.theme.White


@Composable
fun CategoryContent(category: Category) {
    Card(
        shape = RoundedCornerShape(30.dp),
        backgroundColor = category.color,
        modifier = Modifier
            .width(175.dp)
    ) {
        Column(
            modifier = Modifier.padding(
                top = 24.dp,
                bottom = 24.dp,
                end = 16.dp,
                start = 16.dp
            )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = category.emoji.emoji.ifEmpty { "\uD83C\uDFA9" },
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

//                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = category.name,
                    maxLines = 1,
                    color = if (isSystemInDarkTheme()) White else Color.Black,
                    fontSize = 24.sp,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "${category.todos.size} to-dos",
                color = if (isSystemInDarkTheme()) White else Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Progress",
                    fontSize = 14.sp,
                    color = if (isSystemInDarkTheme()) White else Color.Black,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "${category.percent} %",
                    color = if (isSystemInDarkTheme()) White else Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            LinearProgressIndicator(progress = 40f, backgroundColor = White)
        }
    }
}

@Preview
@Composable
fun CategoryContentPreview() {
    CategoryContent(
        category = Category(
            name = "Work",
            description = "Work shit. You gerrit?",
            color = Color.Cyan,
            todos = listOf(
                Todo(
                    id = 0,
                    todo = "Let's Get this shit done.",
                    isDone = true,
                    categoryColor = Color.Cyan
                ),
                Todo(id = 1, todo = "Let's Get this shit done.", isDone = true),
                Todo(id = 2, todo = "Let's Get this shit done.", isDone = false),
                Todo(id = 3, todo = "Let's Get this shit done.", isDone = true),
                Todo(id = 4, todo = "Let's Get this shit done.", isDone = true),
                Todo(id = 5, todo = "Let's Get this shit done.", isDone = true)
            )
        )
    )
}