package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.model.ThemeMode

private val DarkColorScheme = darkColorScheme(
    primary = GoogleBlueDark,
    onPrimary = Color(0xFF002B75),
    primaryContainer = Color(0xFF1A3B70),
    onPrimaryContainer = Color(0xFFD6E3FF),
    secondary = MzabOchre,
    onSecondary = Color(0xFF3E2300),
    secondaryContainer = Color(0xFF5A3600),
    onSecondaryContainer = Color(0xFFFFDDB3),
    tertiary = GoogleGreenDark,
    onTertiary = Color(0xFF003915),
    background = MzabSandDark,
    onBackground = TextPrimaryDark,
    surface = CardDark,
    onSurface = TextPrimaryDark,
    surfaceVariant = Color(0xFF262C36),
    onSurfaceVariant = TextSecondaryDark,
    outline = BorderDark,
    error = GoogleRedDark,
    onError = Color(0xFF601410)
)

private val LightColorScheme = lightColorScheme(
    primary = GoogleBlue,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFD6E3FF),
    onPrimaryContainer = Color(0xFF001B3F),
    secondary = MzabTerracotta,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFFFDBCF),
    onSecondaryContainer = Color(0xFF390C00),
    tertiary = GoogleGreen,
    onTertiary = Color.White,
    background = MzabSandLight,
    onBackground = TextPrimaryLight,
    surface = CardLight,
    onSurface = TextPrimaryLight,
    surfaceVariant = Color(0xFFF1EDE6),
    onSurfaceVariant = TextSecondaryLight,
    outline = BorderLight,
    error = GoogleRed,
    onError = Color.White
)

@Composable
fun GDGGhardaiaTheme(
    themeMode: ThemeMode = ThemeMode.SYSTEM,
    content: @Composable () -> Unit
) {
    val darkTheme = when (themeMode) {
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
        ThemeMode.DARK -> true
        ThemeMode.LIGHT -> false
    }

    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
