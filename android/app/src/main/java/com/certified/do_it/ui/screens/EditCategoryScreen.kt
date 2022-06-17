package com.certified.do_it.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import com.certified.do_it.data.model.Category
import com.certified.do_it.ui.theme.OnBackground
import com.certified.do_it.ui.theme.Primary
import com.certified.do_it.ui.theme.SpaceGrotesk
import com.certified.do_it.ui.theme.White
import com.certified.do_it.utils.Extensions.showToast

@Composable
fun EditCategoryScreen(category: Category) {

    val context = LocalContext.current
    val currentCategory = remember { mutableStateOf(category) }

    val scrollState = rememberScrollState()
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                state = scrollState,
                orientation = Orientation.Vertical
            )
    ) {
        val (closeButton, title, categoryTitleEditText, divider, categoryDescriptionEditText, flag, colorPicker, saveButton) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = "Close button",
            modifier = Modifier
                .clickable { showToast(context, "You'll be able to close this screen soon") }
                .constrainAs(closeButton) {
                    top.linkTo(parent.top, 28.dp)
                    end.linkTo(parent.end, 24.dp)
                })

        val topGuideline = createGuidelineFromTop(.30f)

        Text(
            text = "Enter category details",
            fontFamily = SpaceGrotesk,
            fontWeight = FontWeight.Medium,
            fontSize = 26.sp, modifier = Modifier.constrainAs(title) {
                top.linkTo(topGuideline)
                start.linkTo(parent.start, 24.dp)
            }
        )

        Divider(
            color = Primary,
            modifier = Modifier
                .width(3.dp)
                .height(40.dp)
                .constrainAs(divider) {
                    top.linkTo(categoryTitleEditText.top)
                    bottom.linkTo(categoryTitleEditText.bottom)
                    start.linkTo(categoryTitleEditText.start, 16.dp)
                })

        val categoryTitle = remember { mutableStateOf(currentCategory.value.name) }
        val emptyTitleTextError = remember { mutableStateOf(false) }
        OutlinedTextField(
            value = categoryTitle.value,
            onValueChange = {
                categoryTitle.value = it
                if (it.isNotEmpty()) emptyTitleTextError.value = false
            },
            isError = emptyTitleTextError.value,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 24.dp, start = 24.dp)
                .constrainAs(categoryTitleEditText) {
                    top.linkTo(title.bottom, 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            singleLine = true,
            textStyle = TextStyle(
                fontFamily = SpaceGrotesk,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            ),
            placeholder = {
                Text(
                    text = "Title",
                    fontFamily = SpaceGrotesk,
                    fontWeight = FontWeight.Medium,
                    fontSize = 26.sp, modifier = Modifier.alpha(.5f)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )

        val categoryDescription = remember { mutableStateOf(currentCategory.value.description) }
        val emptyDescriptionTextError = remember { mutableStateOf(false) }
        OutlinedTextField(
            value = categoryDescription.value,
            onValueChange = {
                categoryDescription.value = it
                if (it.isNotEmpty()) emptyDescriptionTextError.value = false
            },
            isError = emptyDescriptionTextError.value,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 24.dp, start = 24.dp)
                .constrainAs(categoryDescriptionEditText) {
                    top.linkTo(categoryTitleEditText.bottom, 1.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            maxLines = 4,
            textStyle = TextStyle(
                fontFamily = SpaceGrotesk,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            ),
            placeholder = {
                Text(
                    text = "Description",
                    fontFamily = SpaceGrotesk,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp, modifier = Modifier.alpha(.5f)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )

        FloatingActionButton(onClick = { /*TODO*/ }, modifier = Modifier
            .constrainAs(flag) {
                top.linkTo(categoryDescriptionEditText.bottom, 30.dp)
                start.linkTo(parent.start, 24.dp)
                end.linkTo(colorPicker.start)
            }
            .alpha(.5f), backgroundColor = White) {
            Icon(
                painter = painterResource(id = R.drawable.ic_flag),
                contentDescription = "Priority picker",
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
                    top.linkTo(flag.top)
                    bottom.linkTo(flag.bottom)
                    start.linkTo(flag.end)
                    end.linkTo(parent.end, 24.dp)
                }
        ) {
            Box(
                modifier = Modifier
                    .size(25.dp)
                    .border(
                        border = BorderStroke(
                            width = 1.dp,
                            color = currentCategory.value.color
                        ),
                        shape = CircleShape
                    )
                    .background(shape = CircleShape, color = White)
                    .align(Alignment.Center)
            ) {
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .background(shape = CircleShape, color = currentCategory.value.color)
                        .align(Alignment.Center)
                )
            }
        }

        ExtendedFloatingActionButton(text = {
            Text(
                text = "Save",
                fontFamily = SpaceGrotesk,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
        }, onClick = {
            showToast(context, "Coming soon")
            if (categoryTitle.value.isBlank()) emptyTitleTextError.value = true
            if (categoryDescription.value.isBlank()) emptyDescriptionTextError.value = true
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