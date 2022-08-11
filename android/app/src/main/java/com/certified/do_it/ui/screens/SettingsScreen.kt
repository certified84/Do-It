package com.certified.do_it.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.certified.do_it.R
import com.certified.do_it.ui.theme.*

@Composable
fun SettingsScreen() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = if (isSystemInDarkTheme()) BackgroundDark else Background)
            .padding(start = 24.dp, end = 24.dp, top = 28.dp)
    ) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val (backButton, title, profileImage, changeImageButton, userName, editProfileButton) = createRefs()

            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(40.dp)
                    .alpha(1f)
                    .background(color = PrimaryContainer, shape = CircleShape)
                    .constrainAs(backButton) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Back button",
                    tint = OnPrimaryContainer,
                    modifier = Modifier.size(24.dp)
                )
            }

            Text(
                text = "Settings",
                fontSize = 26.sp,
                fontFamily = SpaceGrotesk,
                color = if (isSystemInDarkTheme()) White else OnBackground,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(backButton.top)
                    bottom.linkTo(backButton.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            Box(
                modifier = Modifier
                    .size(140.dp)
                    .border(
                        border = BorderStroke(width = 3.dp, color = OnBackground),
                        shape = CircleShape
                    )
                    .background(shape = CircleShape, color = White)
                    .constrainAs(profileImage) {
                        top.linkTo(title.bottom, 36.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {

                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(R.drawable.avatar)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.avatar),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .align(Alignment.Center)
                        .size(128.dp)
                )
            }

            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(50.dp)
                    .alpha(1f)
                    .border(border = BorderStroke(2.dp, White), shape = CircleShape)
                    .background(color = OnBackground, shape = CircleShape)
                    .constrainAs(changeImageButton) {
                        bottom.linkTo(profileImage.bottom)
                        end.linkTo(profileImage.end)
                    }) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_camera),
                    contentDescription = "Change profile image button",
                    tint = White,
                    modifier = Modifier.size(24.dp)
                )
            }

            Text(
                text = "Samson Achiaga",
                fontSize = 18.sp,
                fontFamily = SpaceGrotesk,
                color = if (isSystemInDarkTheme()) White else OnBackground,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.constrainAs(userName) {
                    top.linkTo(profileImage.bottom, 18.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(corner = CornerSize(50.dp)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .constrainAs(editProfileButton) {
                        top.linkTo(userName.bottom, 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
                Text(
                    text = "Edit Profile",
                    fontSize = 16.sp,
                    fontFamily = SpaceGrotesk,
                    color = White,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingsScreenPreview() {
    DoItTheme {
        SettingsScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SettingsScreenPreviewNight() {
    DoItTheme {
        SettingsScreen()
    }
}