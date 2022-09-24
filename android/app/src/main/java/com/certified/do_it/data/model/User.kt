/*
 * Copyright (c) 2021 Samson Achiaga
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.certified.do_it.data.model

import android.graphics.Bitmap
import androidx.compose.ui.graphics.Color

data class User(
    val id: String = "",
    val name: String = "",
    val profileImage: Bitmap? = null,
    val emoji: Emoji? = Emoji(
        emoji = "\uD83D\uDC51",
        description = "crown",
        category = "objects",
        aliases = listOf("crown"),
        tags = listOf("king", "queen", "royal"),
        unicode_version = "6.0",
        ios_version = "6.0"
    ),
    val categories: List<Category> = listOf()
) {
    val todos: MutableList<Todo> = mutableListOf()

    init {
        categories.forEach { category -> todos.addAll(category.todos) }
    }
}