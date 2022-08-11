package com.certified.do_it.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.certified.do_it.R
import com.certified.do_it.ui.theme.*

@Composable
fun NotificationScreen() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = if (isSystemInDarkTheme()) BackgroundDark else Background)
            .padding(start = 24.dp, end = 24.dp, top = 28.dp)
    ) {
        val (backButton, title, comingSoon) = createRefs()

        IconButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .size(40.dp)
                .alpha(1f)
//                .background(shape = CircleShape)
                .constrainAs(backButton) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back button",
                tint = if (!isSystemInDarkTheme()) OnPrimaryContainer else OnPrimaryContainerDark,
                modifier = Modifier.size(24.dp)
            )
        }

        Text(
            text = "Notifications",
            fontSize = 26.sp,
            fontFamily = SpaceGrotesk,
            color = if (isSystemInDarkTheme()) OnBackgroundDark else OnBackground,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(backButton.top)
                bottom.linkTo(backButton.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = "Nothing's here yet...",
            fontSize = 26.sp,
            fontFamily = SpaceGrotesk,
            color = if (isSystemInDarkTheme()) OnBackgroundDark else OnBackground,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .constrainAs(comingSoon) {
                    top.linkTo(title.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .alpha(.5f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NotificationScreenPreview() {
    DoItTheme {
        NotificationScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NotificationScreenPreviewNight() {
    DoItTheme {
        NotificationScreen()
    }
}