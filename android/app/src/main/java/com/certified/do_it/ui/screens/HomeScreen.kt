package com.certified.do_it.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.certified.do_it.R
import com.certified.do_it.data.model.Category
import com.certified.do_it.data.model.Emoji
import com.certified.do_it.data.model.Todo
import com.certified.do_it.data.model.User
import com.certified.do_it.ui.components.CategoryContent
import com.certified.do_it.ui.theme.*
import com.google.gson.Gson

@Composable
fun HomeScreen(user: User) {
    val context = LocalContext.current
    val json = context.resources.openRawResource(R.raw.emoji)
        .bufferedReader().use { it.readText() }
    val emojis = Gson().fromJson(json, Array<Emoji>::class.java)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = if (isSystemInDarkTheme()) BackgroundDark else Background)
            .padding(24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(modifier = Modifier.weight(1f)) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_navigation),
                        contentDescription = "Drawer button",
                        tint = Primary
                    )
                }
            }

            Row {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.background(color = PrimaryContainer, shape = CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search button",
                        tint = OnPrimaryContainer
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.background(color = PrimaryContainer, shape = CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_notification),
                        contentDescription = "Notification button",
                        tint = OnPrimaryContainer
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Hey, ",
            color = if (isSystemInDarkTheme()) OnBackgroundDark else OnBackground,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )

        Row {
            Text(
                text = user.name,
                color = if (isSystemInDarkTheme()) OnBackgroundDark else OnBackground,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.width(2.dp))

            Text(
                text = if (user.emoji == null) emojis[0].emoji else user.emoji.emoji,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(36.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_category),
                contentDescription = "Category",
                tint = if (isSystemInDarkTheme()) OnBackgroundDark else OnBackground,
                modifier = Modifier.size(22.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = "Categories",
                color = if (isSystemInDarkTheme()) OnBackgroundDark else OnBackground,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        ListCategories(items = user.categories)
    }
}

@Composable
fun ListCategories(items: List<Category>) {
    LazyRow {
        items(count = items.size, key = null, itemContent = { index ->
            CategoryContent(items[index])

            Spacer(modifier = Modifier.width(10.dp))
        })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    DoItTheme {
        HomeScreen(
            User(
                name = "Sammie", categories = listOf(
                    Category(
                        name = "Work",
                        description = "Work shit. You gerrit?",
                        color = Primary,
                        todos = listOf(
                            Todo(
                                id = 0,
                                todo = "Let's Get this shit done.",
                                isDone = true,
                                categoryColor = Color.Cyan
                            ),
                            Todo(id = 1, todo = "Let's Get this shit done.", isDone = true),
                            Todo(id = 2, todo = "Let's Get this shit done.", isDone = true),
                            Todo(id = 3, todo = "Let's Get this shit done.", isDone = true),
                            Todo(id = 4, todo = "Let's Get this shit done.", isDone = true),
                            Todo(id = 5, todo = "Let's Get this shit done.", isDone = true)
                        )
                    ), Category(
                        name = "School",
                        description = "Work shit. You gerrit?",
                        color = Color.Blue,
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
                    ), Category(
                        name = "Personal",
                        description = "Work shit. You gerrit?",
                        color = Color.DarkGray,
                        todos = listOf(
                            Todo(
                                id = 0,
                                todo = "Let's Get this shit done.",
                                isDone = true,
                                categoryColor = Color.Cyan
                            ),
                            Todo(id = 1, todo = "Let's Get this shit done.", isDone = true),
                            Todo(id = 2, todo = "Let's Get this shit done.", isDone = false),
                            Todo(id = 3, todo = "Let's Get this shit done.", isDone = false),
                            Todo(id = 4, todo = "Let's Get this shit done.", isDone = true),
                            Todo(id = 5, todo = "Let's Get this shit done.", isDone = true)
                        )
                    ), Category(
                        name = "Others",
                        description = "Work shit. You gerrit?",
                        color = Color.Magenta,
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
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreviewNight() {
    DoItTheme {
        HomeScreen(
            User(
                name = "Sammie", categories = listOf(
                    Category(
                        name = "Work",
                        description = "Work shit. You gerrit?",
                        color = Primary,
                        todos = listOf(
                            Todo(
                                id = 0,
                                todo = "Let's Get this shit done.",
                                isDone = true,
                                categoryColor = Color.Cyan
                            ),
                            Todo(id = 1, todo = "Let's Get this shit done.", isDone = true),
                            Todo(id = 2, todo = "Let's Get this shit done.", isDone = true),
                            Todo(id = 3, todo = "Let's Get this shit done.", isDone = true),
                            Todo(id = 4, todo = "Let's Get this shit done.", isDone = true),
                            Todo(id = 5, todo = "Let's Get this shit done.", isDone = true)
                        )
                    ), Category(
                        name = "School",
                        description = "Work shit. You gerrit?",
                        color = Color.Blue,
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
                    ), Category(
                        name = "Personal",
                        description = "Work shit. You gerrit?",
                        color = Color.DarkGray,
                        todos = listOf(
                            Todo(
                                id = 0,
                                todo = "Let's Get this shit done.",
                                isDone = true,
                                categoryColor = Color.Cyan
                            ),
                            Todo(id = 1, todo = "Let's Get this shit done.", isDone = true),
                            Todo(id = 2, todo = "Let's Get this shit done.", isDone = false),
                            Todo(id = 3, todo = "Let's Get this shit done.", isDone = false),
                            Todo(id = 4, todo = "Let's Get this shit done.", isDone = true),
                            Todo(id = 5, todo = "Let's Get this shit done.", isDone = true)
                        )
                    ), Category(
                        name = "Others",
                        description = "Work shit. You gerrit?",
                        color = Color.Magenta,
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
            )
        )
    }
}