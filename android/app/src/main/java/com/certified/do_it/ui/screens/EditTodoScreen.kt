package com.certified.do_it.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.certified.do_it.R
import com.certified.do_it.data.model.Todo
import com.certified.do_it.ui.theme.OnBackground
import com.certified.do_it.ui.theme.Primary
import com.certified.do_it.ui.theme.SpaceGrotesk
import com.certified.do_it.ui.theme.White
import com.certified.do_it.utils.Extensions.showToast

@Composable
fun EditTodoScreen(todo: Todo) {

    val context = LocalContext.current
    val currentTodo = remember { mutableStateOf(todo) }

    val scrollState = rememberScrollState()
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                state = scrollState,
                orientation = Orientation.Vertical
            )
    ) {
        val (closeButton, todoEditText, datePicker, flag, category, colorPicker, saveButton) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = "Close button",
            modifier = Modifier
                .clickable { showToast(context, "You'll be able to close this screen soon") }
                .constrainAs(closeButton) {
                    top.linkTo(parent.top, 28.dp)
                    end.linkTo(parent.end, 24.dp)
                })

        val topGuideline = createGuidelineFromTop(.35f)

        val todoText = remember { mutableStateOf(currentTodo.value.todo) }
        val emptyTextError = remember { mutableStateOf(false) }
        OutlinedTextField(
            value = todoText.value,
            onValueChange = { todoText.value = it },
            isError = emptyTextError.value,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 24.dp, start = 24.dp)
                .constrainAs(todoEditText) {
                    top.linkTo(topGuideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            maxLines = 4,
            textStyle = TextStyle(
                fontFamily = SpaceGrotesk,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            ),
            placeholder = {
                Text(
                    text = "Enter new todo",
                    fontFamily = SpaceGrotesk,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp, modifier = Modifier.alpha(.5f)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )

        val reminder = remember { mutableStateOf(currentTodo.value.reminder) }
        ExtendedFloatingActionButton(text = {
            Text(
                text = "Today",
                fontFamily = SpaceGrotesk,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp, color = OnBackground
            )
        }, onClick = { /*TODO*/ }, icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_calendar),
                contentDescription = "Date picker",
                tint = OnBackground
            )
        }, modifier = Modifier
            .alpha(.5f)
            .constrainAs(datePicker) {
                top.linkTo(todoEditText.bottom, 10.dp)
                start.linkTo(parent.start, 24.dp)
                end.linkTo(flag.start)
            }
            .border(
                border = BorderStroke(1.dp, OnBackground),
                shape = RoundedCornerShape(15.dp)
            ), backgroundColor = White
        )

        FloatingActionButton(onClick = { /*TODO*/ }, modifier = Modifier
            .constrainAs(flag) {
                top.linkTo(datePicker.top)
                bottom.linkTo(datePicker.bottom)
                start.linkTo(datePicker.end)
                end.linkTo(category.start)
            }
            .alpha(.5f), backgroundColor = White) {
            Icon(
                painter = painterResource(id = R.drawable.ic_flag),
                contentDescription = "Priority picker",
                tint = OnBackground
            )
        }

        FloatingActionButton(onClick = { /*TODO*/ }, modifier = Modifier
            .constrainAs(category) {
                top.linkTo(datePicker.top)
                bottom.linkTo(datePicker.bottom)
                start.linkTo(flag.end)
                end.linkTo(colorPicker.start)
            }
            .alpha(.5f), backgroundColor = White) {
            Icon(
                painter = painterResource(id = R.drawable.ic_category),
                contentDescription = "Category picker",
                tint = OnBackground
            )
        }

        Box(
            modifier = Modifier
//                .alpha(.5f)
                .size(45.dp)
                .border(
                    border = BorderStroke(
                        width = 2.dp,
                        color = Color(red = .33f, green = .26f, blue = .25f, alpha = .5f)
                    ),
                    shape = CircleShape
                )
                .background(shape = CircleShape, color = White)
                .constrainAs(colorPicker) {
                    top.linkTo(datePicker.top)
                    bottom.linkTo(datePicker.bottom)
                    start.linkTo(category.end)
                    end.linkTo(parent.end, 24.dp)
                }
        ) {
            Box(
                modifier = Modifier
                    .size(25.dp)
                    .border(
                        border = BorderStroke(
                            width = 1.dp,
                            color = currentTodo.value.category.color
                        ),
                        shape = CircleShape
                    )
                    .background(shape = CircleShape, color = White)
                    .align(Alignment.Center)
            ) {
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .background(shape = CircleShape, color = currentTodo.value.category.color)
                        .align(Alignment.Center)
                )
            }
        }

//        FloatingActionButton(onClick = { /*TODO*/ }, modifier = Modifier.constrainAs(colorPicker) {
//            top.linkTo(datePicker.top)
//            bottom.linkTo(datePicker.bottom)
//            start.linkTo(category.end)
//            end.linkTo(parent.end, 24.dp)
//        }) {
//            Icon(
//                painter = painterResource(id = R.drawable.ic_flag),
//                contentDescription = "Color picker"
//            )
//        }

        ExtendedFloatingActionButton(text = {
            Text(
                text = "Save",
                fontFamily = SpaceGrotesk,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
        }, onClick = {
            showToast(context, "Coming soon")
            if (todoText.value.isBlank()) emptyTextError.value = true
        }, icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = "Save button"
            )
        }, modifier = Modifier.constrainAs(saveButton) {
            bottom.linkTo(parent.bottom, 32.dp)
            end.linkTo(closeButton.end)
        }, backgroundColor = Primary)
    }
}