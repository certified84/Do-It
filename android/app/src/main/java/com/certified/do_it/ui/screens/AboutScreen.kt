package com.certified.do_it.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.certified.do_it.R
import com.certified.do_it.ui.theme.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AboutScreen() {

    val context = LocalContext.current

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 28.dp)
            .background(color = Background)
    ) {
        val (backButton, title, appLogo, appVersion, licenceCard) = createRefs()

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
            text = "About",
            fontSize = 26.sp,
            fontFamily = SpaceGrotesk,
            color = OnBackground,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(backButton.top)
                bottom.linkTo(backButton.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Image(
            painter = painterResource(id = R.drawable.ic_logo_about),
            contentDescription = "Application Logo",
            modifier = Modifier.constrainAs(appLogo) {
                top.linkTo(title.bottom, 64.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = stringResource(id = R.string.app_version),
            fontSize = 14.sp,
            fontFamily = SpaceGrotesk,
            color = OnBackground,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .constrainAs(appVersion) {
                    top.linkTo(appLogo.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .alpha(.6f)
        )

//        Box(
//            modifier = Modifier
//                .clickable { }
//                .fillMaxWidth()
//                .constrainAs(licenceCard) {
//                    top.linkTo(appVersion.bottom)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                }
//                .padding(top = 30.dp)
//                .background(color = PrimaryContainer, shape = RoundedCornerShape(corner = CornerSize(15.dp)))
//        ) {
//            Column {
//                Text(
//                    text = "Attributions & Licence",
//                    fontFamily = SpaceGrotesk,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 18.sp,
//                    modifier = Modifier.padding(top = 16.dp, start = 24.dp)
//                )
//
//                Text(
//                    text = "Licenced under Apache Licence, Version 2.0",
//                    fontFamily = SpaceGrotesk,
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 14.sp,
//                    modifier = Modifier.padding(start = 24.dp, bottom = 16.dp)
//                )
//            }
//        }

        Card(
            backgroundColor = PrimaryContainer,
            onClick = { },
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(licenceCard) {
                    top.linkTo(appVersion.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(top = 30.dp)
        ) {
            Column {
                Text(
                    text = "Attributions & Licence",
                    fontFamily = SpaceGrotesk,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 16.dp, start = 24.dp)
                )

                Text(
                    text = "Licenced under Apache Licence, Version 2.0",
                    fontFamily = SpaceGrotesk,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 24.dp, bottom = 16.dp)
                )
            }
        }
    }
}