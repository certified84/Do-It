package com.certified.do_it.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Primary,
    primaryVariant = OnPrimaryContainer,
    secondary = Secondary,
    secondaryVariant = OnSecondaryContainer,
    background = Background,
    surface = Surface,
    error = Error,
    onPrimary = White,
    onSecondary = White,
    onBackground = OnBackground,
    onSurface = OnSurface,
    onError = White
)

private val LightColorPalette = lightColors(
    primary = Primary,
    primaryVariant = OnPrimaryContainer,
    secondary = Secondary,
    secondaryVariant = OnSecondaryContainer,
    background = Background,
    surface = Surface,
    error = Error,
    onPrimary = White,
    onSecondary = White,
    onBackground = OnBackground,
    onSurface = OnSurface,
    onError = White
)

@Composable
fun DoItTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}